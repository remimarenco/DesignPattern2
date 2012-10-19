import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;


public class Mediator implements ISimpleMouseObservateur, ISimpleMouseObservable ,INonOverlapMouseAdapterObservateur, INonOverlapMouseAdapterObservable{
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
	protected List<ISimpleMouseObservateur> smoObs = new ArrayList<ISimpleMouseObservateur>();
	protected List<INonOverlapMouseAdapterObservateur> nomaObs = new ArrayList<INonOverlapMouseAdapterObservateur>();
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

		SimpleMouseListenerObservable smlo = new SimpleMouseListenerObservable(jc);
		smlo.ajouterObservateur(this);
		NonOverlapMoveAdapterObservable nomao = new NonOverlapMoveAdapterObservable(jc);
		nomao.ajouterObservateur(this);
		
		//on ajoute le anvas comme observateur sur le mediateur
		this.ajouterObservateur(jc);
		
		
	}
	
	public JCanvas getCanvas()
	{
		return jc;
	}

	@Override
	public void actualiser(Object objet) {
		// TODO Auto-generated method stub
		
	}
	
	// ----------- SimpleMouseEvents ------------- //

	@Override
	public void leftClick(IDrawable drawable) {
		// Demande de v�rification si on a cliqu� sur un objet existant ou non
		// TODO:Trouver une autre solution
		if(jc.isFree(drawable.getRectangle()))
		{
			//on récupere le nom de la classe passez en parametre et on lui ajoute "Drawable"
			String nomC = form.getRace()+"Drawable";
			
			//on créait la liste d'argument pour l'inspecteur
			Object[] args={drawable, form.getNom()};
			
			//on créait un inspecteur puis on appelle la fonction getObject pour créait un marsu en fonction du nom de la classe
			Inspecteur inspecteur=new Inspecteur();
			IDrawable nouveauDrawable = (IDrawable) inspecteur.getObject(nomC, args) ;

			notifierLeftClick(drawable);
			
			//TODO: retiré cette  fonction et directement passer les parametres au left click
			
		}
		else
		{
			// On change d'�tat
			MarsupialDrawable drawableM = (MarsupialDrawable) drawable;
			Marsupial marsu = drawableM.getMarsupial();
			marsu.changerEtat();
			if(marsu.estReveille)
			{
				jc.changerCouleur(drawableM, Color.RED);
			}
			else
			{
				jc.changerCouleur(drawableM, Color.BLUE);
			}
			notifierLeftClick(drawable);
		}
	}
	
	@Override
	public void rightClick(IDrawable drawable) {
		// On r�cup�re l'�l�ment drawable de la vue
		lMarsupialDrawable.remove(drawable);
		
		// TODO : Modifier en notification clickDroit
		notifierRightClick(drawable);
	}
	
	@Override
	public void notifierLeftClick(IDrawable drawable) {
		// TODO Auto-generated method stub
		for(ISimpleMouseObservateur obs : smoObs)
		{
			obs.leftClick(drawable);
		}
	}

	@Override
	public void notifierRightClick(IDrawable drawable) {
		// TODO Auto-generated method stub
		for(ISimpleMouseObservateur obs : smoObs)
		{
			obs.rightClick(drawable);
		}
	}
	
	// ---------- MouseMotionEvents Observation --------- //

	@Override
	public void mouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMouseReleased(e, d, p);		
	}

	@Override
	public void mousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		notifierMousePressed(e, d, p);
	}

	@Override
	public void mouseDragged(MouseEvent e, IMovableDrawable d) {
		notifierMouseDragged(e, d);
	}
	
	// ---------- MouseMotionEvents Observable --------- //

	@Override
	public void ajouterObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions pr�cises sans switch
		nomaObs.add((INonOverlapMouseAdapterObservateur)obs);
		smoObs.add((ISimpleMouseObservateur) obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions pr�cises sans switch
		nomaObs.remove((INonOverlapMouseAdapterObservateur)obs);
		smoObs.remove((ISimpleMouseObservateur) obs);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifierMouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mouseReleased(e, d, p);
		}
	}

	@Override
	public void notifierMousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mousePressed(e, d, p);
		}
	}

	@Override
	public void notifierMouseDragged(MouseEvent e, IMovableDrawable d) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : nomaObs)
		{
			obs.mouseDragged(e, d);
		}
	}	
}
