package Controleur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import IHM.Fenetre;
import IHM.IDrawable;
import IHM.IMovableDrawable;
import IHM.INonOverlapMouseAdapterObservable;
import IHM.INonOverlapMouseAdapterObservateur;
import IHM.ISimpleMouseMediatorListenerObservateur;
import IHM.ISimpleMouseMediatorVueObservable;
import IHM.ISimpleMouseMediatorVueObservateur;
import IHM.JCanvas;
import IHM.JForm;
import IHM.MarsupialDrawable;
import IHM.NonOverlapMoveAdapterObservable;
import IHM.SimpleMouseListenerObservable;
import Metier.IObservateur;
import Metier.Inspecteur;
import Metier.Marsupial;
import javax.swing.JPanel;

/**
 * Classe Mediator, permettant de traiter les �changes entre la partie m�tier et IHM selon 
 * le pattern MVC.
 * Design pattern : MVC / Mediator, Observateur,
 * @author RemiPortable
 *
 */
public class Mediator implements ISimpleMouseMediatorListenerObservateur, ISimpleMouseMediatorVueObservable ,INonOverlapMouseAdapterObservateur, INonOverlapMouseAdapterObservable{
	
	// Liste de Marsupiaux dessinables
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
	
	// Liste des observateurs sur des �v�nements souris (L'IHM s'abonne dessus)
	protected List<ISimpleMouseMediatorVueObservateur> smoObs = new ArrayList<ISimpleMouseMediatorVueObservateur>();
	protected List<INonOverlapMouseAdapterObservateur> nomaObs = new ArrayList<INonOverlapMouseAdapterObservateur>();
	
	// Variables permettant de g�rer une IHM
	protected JCanvas jc;
	protected Fenetre fenetre;
	protected JForm form;
	
	public Mediator(){
		//on creait le canvas avec le médiator passé en parametre
		this.jc=new JCanvas(this);
		
		//on créait le le form pour le passé a la fenetre
		this.form= new JForm();
		
		//on créait la fenetre en passant le canvas et le form
		Fenetre fenetre=new Fenetre(this,jc,form);
		
		// Abonnement des listener sur la vue, et abonnement de notre mediator sur
		// les listener.
		// Permet d'�viter aux listeners de connaitre leurs voisins (On ajoute une deuxi�me IHM
		// pour montrer l'utilit�). Le couplage faible n'est pas enti�rement termin� du fait que
		// l'on r�f�rence notre premier canvas dans les autres fonctions du mediator. Il faudrait
		// g�rer une liste de Vue et la parcourir par exemple.
		SimpleMouseListenerObservable smlo = new SimpleMouseListenerObservable(jc);
		smlo.ajouterObservateur(this);
		NonOverlapMoveAdapterObservable nomao = new NonOverlapMoveAdapterObservable(jc);
		nomao.ajouterObservateur(this);
		
		// on ajoute le canvas comme observateur sur le mediateur
		this.ajouterObservateur(jc);
		
		// Test de fonctionnement du couplage faible sur les �v�nements
		// au travers de la cr�ation d'une nouvelle fenetre miroir de la premi�re
		JForm jf2 = new JForm();
		//onrécupere le JCanvas de la fenetre
		JCanvas jc2 = new JCanvas(this);
		//on créait la fenetre
		Fenetre fenetre2=new Fenetre(this, jc2, jf2);
				
		this.ajouterObservateur(jc2);
	}
	
	public JCanvas getCanvas()
	{
		return jc;
	}

	@Override
	public void actualiser(Object objet) {		
	}
	
	// ----------- SimpleMouseEvents ------------- //

	/*
	 * M�thode permettant de r�cup�rer le click gauche depuis un listener de SimpleMouse
	 * Permet de cr�er une AnimalDrawable et notifie les IHM abonn� d'un click gauche
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorListenerObservateur#leftClick(java.awt.Point)
	 */
	@Override
	public void leftClick(Point point) {
		// V�rification si on a cliqu� sur un objet existant ou non
		IDrawable drawable = jc.getDrawableFromPoint(point);
		// Si l'objet n'existe pas, on cr�� un drawable � l'aide d'un inspecteur
		// puis on notifie la vue que l'on a fait un click gauche
		if(drawable == null)
		{
			//on récupere le nom de la classe passez en parametre et on lui ajoute "Drawable"
			String nomC = "IHM."+form.getRace()+"Drawable";
			
			//on créait la liste d'argument pour l'inspecteur
			Object[] args={point, jc.getDimension(), form.getNom()};
			
			//on créait un inspecteur puis on appelle la fonction getObject pour créait un marsu en fonction du nom de la classe
			Inspecteur inspecteur=new Inspecteur();
			IDrawable nouveauDrawable = (IDrawable) inspecteur.getObject(nomC, args) ;
			notifierLeftClick(nouveauDrawable);
		}
		// Sinon on change d'�tat sur le drawable, puis on notifie la vue que l'on a fait
		// un click gauche
		else
		{
			// On change d'�tat
			MarsupialDrawable drawableM = (MarsupialDrawable) drawable;
			drawableM.changerEtat();
			notifierLeftClick(drawable);
		}
	}
	
	/*
	 * Permet de r�cup�rer le click droit depuis les listener
	 * On retire le drawable de la liste puis on notifie les IHM que l'on a recu un click droit
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorListenerObservateur#rightClick(java.awt.Point)
	 */
	@Override
	public void rightClick(Point point) {
		// On r�cup�re l'�l�ment drawable de la vue
		IDrawable drawable = jc.getDrawableFromPoint(point);
		lMarsupialDrawable.remove(drawable);
		// TODO : Modifier en notification clickDroit
		notifierRightClick(drawable);
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * SimpleMouse
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorVueObservable#notifierLeftClick(IHM.IDrawable)
	 */
	@Override
	public void notifierLeftClick(IDrawable drawable) {
		// TODO Auto-generated method stub
		for(ISimpleMouseMediatorVueObservateur obs : smoObs)
		{
			obs.leftClick(drawable);
		}
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * SimpleMouse
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorVueObservable#notifierRightClick(IHM.IDrawable)
	 */
	@Override
	public void notifierRightClick(IDrawable drawable) {
		// TODO Auto-generated method stub
		for(ISimpleMouseMediatorVueObservateur obs : smoObs)
		{
			obs.rightClick(drawable);
		}
	}
	
	// ---------- MouseMotionEvents Observation --------- //
	
	/*
	 * Pattern observateur, partie observateur pour r�cup�rer les �v�nements
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservateur#mouseReleased(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void mouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMouseReleased(e, d, p);		
	}
	
	/*
	 * Pattern observateur, partie observateur pour r�cup�rer les �v�nements
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservateur#mousePressed(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void mousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMousePressed(e, d, p);
	}
	
	/*
	 * Pattern observateur, partie observateur pour r�cup�rer les �v�nements
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservateur#mouseDragged(java.awt.event.MouseEvent, IHM.IMovableDrawable)
	 */
	@Override
	public void mouseDragged(MouseEvent e, IMovableDrawable d) {
		notifierMouseDragged(e, d);
	}
	
	// ---------- MouseMotionEvents Observable --------- //
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#ajouterObservateur(Metier.IObservateur)
	 */
	@Override
	public void ajouterObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions pr�cises sans switch
		nomaObs.add((INonOverlapMouseAdapterObservateur)obs);
		smoObs.add((ISimpleMouseMediatorVueObservateur) obs);
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#supprimerObservateur(Metier.IObservateur)
	 */
	@Override
	public void supprimerObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions pr�cises sans switch
		nomaObs.remove((INonOverlapMouseAdapterObservateur)obs);
		smoObs.remove((ISimpleMouseMediatorVueObservateur) obs);
	}

	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#notifierObservateurs()
	 */
	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservable#notifierMouseReleased(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void notifierMouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mouseReleased(e, d, p);
		}
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservable#notifierMousePressed(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void notifierMousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mousePressed(e, d, p);
		}
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'�v�nement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservable#notifierMouseDragged(java.awt.event.MouseEvent, IHM.IMovableDrawable)
	 */
	@Override
	public void notifierMouseDragged(MouseEvent e, IMovableDrawable d) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mouseDragged(e, d);
		}
	}	
	
	/*
	 * R�cup�ration de l'it�rateur sur le parcours des marsupiaux iterator() 
	 */
	public Iterator<MarsupialDrawable> marsuDrawIterator()
	{
		return lMarsupialDrawable.iterator();
	}
	
	/*
	 * Ajout du marsupial
	 */
	public void addMarsu(IDrawable drawable)
	{
		lMarsupialDrawable.add((MarsupialDrawable)drawable);
	}
	
	public void removeMarsu(IDrawable drawable)
	{
		lMarsupialDrawable.remove(drawable);
	}
	
	public void clearMarsu()
	{
		lMarsupialDrawable.clear();
	}
}
