import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;


public class Mediator implements ISimpleMouseObservateur, INonOverlapMouseAdapterObservateur, INonOverlapMouseAdapterObservable{
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
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
		
		
		/*//on créait la fenetre en passant le canvas et le form
		Fenetre fenetre2=new Fenetre(this,canvas,form);
				
		//onrécupere le JCanvas de la fenetre
		JCanvas jc2 = fenetre2.getCanvas();
		this.ajouterObservateur(jc2);*/
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
	public void leftClick(MouseEvent e) {
		// Demande de v�rification si on a cliqu� sur un objet existant ou non
		IDrawable drawable = jc.getDrawableFromPoint(e.getPoint());
		if(drawable == null)
		{
			jc.leftClickAction(e);
			//TODO: retiré cette  fonction et directement passer les parametres au left click
			jc.addDrawable(jc.createDrawable(e, form.getRace(), form.getNom()));
		}
		else
		{
			//on caste le drawable en MarsupialDrawable
			MarsupialDrawable drawableM = (MarsupialDrawable) drawable;
			
			//fonction qui va changer l'etat du marsu et sa couleur
			drawableM.changerEtat();
			
		}
	}

	@Override
	public void rightClick(MouseEvent e) {
		// On r�cup�re l'�l�ment drawable de la vue
		jc.rightClickAction(e);

		jc.actualiser();
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
		nomaObs.add((INonOverlapMouseAdapterObservateur)obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		nomaObs.remove((INonOverlapMouseAdapterObservateur)obs);
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
