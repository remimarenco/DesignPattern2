import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Mediator implements ISimpleMouseObservateur, ISimpleMouseObservable ,INonOverlapMouseAdapterObservateur, INonOverlapMouseAdapterObservable{
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
	protected List<ISimpleMouseObservateur> smoObs = new ArrayList<ISimpleMouseObservateur>();
	protected List<INonOverlapMouseAdapterObservateur> nomaObs = new ArrayList<INonOverlapMouseAdapterObservateur>();
	protected JCanvas jc;
	protected Fenetre fenetre;
	
	public Mediator(){		
		//on crÃ©ait la fenetre
		fenetre=new Fenetre(this);
				
		//on rÃ©cupere le JCanvas de la fenetre
		jc = fenetre.getCanvas();
		SimpleMouseListenerObservable smlo = new SimpleMouseListenerObservable(jc);
		smlo.ajouterObservateur(this);
		NonOverlapMoveAdapterObservable nomao = new NonOverlapMoveAdapterObservable(jc);
		nomao.ajouterObservateur(this);
		
		this.ajouterObservateur(jc);
		
		//on crÃ©ait la fenetre
		Fenetre fenetre2=new Fenetre(this);
				
		//onrÃ©cupere le JCanvas de la fenetre
		//JCanvas jc2 = fenetre2.getCanvas();
		//this.ajouterObservateur(jc2);
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
		// Demande de vérification si on a cliqué sur un objet existant ou non
		// TODO:Trouver une autre solution
		if(jc.isFree(drawable.getRectangle()))
		{
			notifierLeftClick(drawable);
		}
		else
		{
			// On change d'état
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
		// On récupère l'élèment drawable de la vue
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
		//TODO : Refaire des fonctions précises sans switch
		nomaObs.add((INonOverlapMouseAdapterObservateur)obs);
		smoObs.add((ISimpleMouseObservateur) obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		//TODO : Refaire des fonctions précises sans switch
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
