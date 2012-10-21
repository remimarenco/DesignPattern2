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
 * Classe Mediator, permettant de traiter les échanges entre la partie métier et IHM selon 
 * le pattern MVC.
 * Design pattern : MVC / Mediator, Observateur,
 * @author RemiPortable
 *
 */
public class Mediator implements ISimpleMouseMediatorListenerObservateur, ISimpleMouseMediatorVueObservable ,INonOverlapMouseAdapterObservateur, INonOverlapMouseAdapterObservable{
	
	// Liste de Marsupiaux dessinables
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
	
	// Liste des observateurs sur des évènements souris (L'IHM s'abonne dessus)
	protected List<ISimpleMouseMediatorVueObservateur> smoObs = new ArrayList<ISimpleMouseMediatorVueObservateur>();
	protected List<INonOverlapMouseAdapterObservateur> nomaObs = new ArrayList<INonOverlapMouseAdapterObservateur>();
	
	// Variables permettant de gérer une IHM
	protected JCanvas jc;
	protected Fenetre fenetre;
	protected JForm form;
	
	public Mediator(){
		//on creait le canvas avec le mÃ©diator passÃ© en parametre
		this.jc=new JCanvas(this);
		
		//on crÃ©ait le le form pour le passÃ© a la fenetre
		this.form= new JForm();
		
		//on crÃ©ait la fenetre en passant le canvas et le form
		Fenetre fenetre=new Fenetre(this,jc,form);
		
		// Abonnement des listener sur la vue, et abonnement de notre mediator sur
		// les listener.
		// Permet d'éviter aux listeners de connaitre leurs voisins (On ajoute une deuxième IHM
		// pour montrer l'utilité). Le couplage faible n'est pas entièrement terminé du fait que
		// l'on référence notre premier canvas dans les autres fonctions du mediator. Il faudrait
		// gérer une liste de Vue et la parcourir par exemple.
		SimpleMouseListenerObservable smlo = new SimpleMouseListenerObservable(jc);
		smlo.ajouterObservateur(this);
		NonOverlapMoveAdapterObservable nomao = new NonOverlapMoveAdapterObservable(jc);
		nomao.ajouterObservateur(this);
		
		// on ajoute le canvas comme observateur sur le mediateur
		this.ajouterObservateur(jc);
		
		// Test de fonctionnement du couplage faible sur les évènements
		// au travers de la création d'une nouvelle fenetre miroir de la première
		JForm jf2 = new JForm();
		//onrÃ©cupere le JCanvas de la fenetre
		JCanvas jc2 = new JCanvas(this);
		//on crÃ©ait la fenetre
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
	 * Méthode permettant de récupérer le click gauche depuis un listener de SimpleMouse
	 * Permet de créer une AnimalDrawable et notifie les IHM abonné d'un click gauche
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorListenerObservateur#leftClick(java.awt.Point)
	 */
	@Override
	public void leftClick(Point point) {
		// Vérification si on a cliqué sur un objet existant ou non
		IDrawable drawable = jc.getDrawableFromPoint(point);
		// Si l'objet n'existe pas, on créé un drawable à l'aide d'un inspecteur
		// puis on notifie la vue que l'on a fait un click gauche
		if(drawable == null)
		{
			//on rÃ©cupere le nom de la classe passez en parametre et on lui ajoute "Drawable"
			String nomC = "IHM."+form.getRace()+"Drawable";
			
			//on crÃ©ait la liste d'argument pour l'inspecteur
			Object[] args={point, jc.getDimension(), form.getNom()};
			
			//on crÃ©ait un inspecteur puis on appelle la fonction getObject pour crÃ©ait un marsu en fonction du nom de la classe
			Inspecteur inspecteur=new Inspecteur();
			IDrawable nouveauDrawable = (IDrawable) inspecteur.getObject(nomC, args) ;
			notifierLeftClick(nouveauDrawable);
		}
		// Sinon on change d'état sur le drawable, puis on notifie la vue que l'on a fait
		// un click gauche
		else
		{
			// On change d'ï¿½tat
			MarsupialDrawable drawableM = (MarsupialDrawable) drawable;
			drawableM.changerEtat();
			notifierLeftClick(drawable);
		}
	}
	
	/*
	 * Permet de récupérer le click droit depuis les listener
	 * On retire le drawable de la liste puis on notifie les IHM que l'on a recu un click droit
	 * (non-Javadoc)
	 * @see IHM.ISimpleMouseMediatorListenerObservateur#rightClick(java.awt.Point)
	 */
	@Override
	public void rightClick(Point point) {
		// On rï¿½cupï¿½re l'ï¿½lï¿½ment drawable de la vue
		IDrawable drawable = jc.getDrawableFromPoint(point);
		lMarsupialDrawable.remove(drawable);
		// TODO : Modifier en notification clickDroit
		notifierRightClick(drawable);
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
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
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
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
	 * Pattern observateur, partie observateur pour récupérer les évènements
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservateur#mouseReleased(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void mouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMouseReleased(e, d, p);		
	}
	
	/*
	 * Pattern observateur, partie observateur pour récupérer les évènements
	 * MouseMotion
	 * (non-Javadoc)
	 * @see IHM.INonOverlapMouseAdapterObservateur#mousePressed(java.awt.event.MouseEvent, IHM.IMovableDrawable, java.awt.Point)
	 */
	@Override
	public void mousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMousePressed(e, d, p);
	}
	
	/*
	 * Pattern observateur, partie observateur pour récupérer les évènements
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
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#ajouterObservateur(Metier.IObservateur)
	 */
	@Override
	public void ajouterObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions prï¿½cises sans switch
		nomaObs.add((INonOverlapMouseAdapterObservateur)obs);
		smoObs.add((ISimpleMouseMediatorVueObservateur) obs);
	}
	
	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#supprimerObservateur(Metier.IObservateur)
	 */
	@Override
	public void supprimerObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions prï¿½cises sans switch
		nomaObs.remove((INonOverlapMouseAdapterObservateur)obs);
		smoObs.remove((ISimpleMouseMediatorVueObservateur) obs);
	}

	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
	 * MouseMotion
	 * (non-Javadoc)
	 * @see Metier.IObservable#notifierObservateurs()
	 */
	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
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
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
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
	 * Pattern observateur, partie observable pour notifier les vues sur l'évènement
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
	 * Récupération de l'itérateur sur le parcours des marsupiaux iterator() 
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
