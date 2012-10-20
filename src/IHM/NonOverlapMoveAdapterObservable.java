package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import Metier.IObservateur;



public class NonOverlapMoveAdapterObservable extends NonOverlapMoveAdapter
		implements INonOverlapMouseAdapterObservable {
	private List<INonOverlapMouseAdapterObservateur> observateurs = new ArrayList<INonOverlapMouseAdapterObservateur>();

	public NonOverlapMoveAdapterObservable(JCanvas canvas) {
		super(canvas);
	}

	@Override
	public void ajouterObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.add((INonOverlapMouseAdapterObservateur)obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.remove((INonOverlapMouseAdapterObservateur)obs);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		notifierMouseReleased(e, drawable, initialLocation);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		notifierMousePressed(e, drawable, initialLocation);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		notifierMouseDragged(e, drawable);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifierMouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : observateurs)
		{
			obs.mouseReleased(e, d, p);
		}
	}

	@Override
	public void notifierMousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		super.mousePressed(e);
		for(INonOverlapMouseAdapterObservateur obs : observateurs)
		{
			obs.mousePressed(e, d, p);
		}
	}

	@Override
	public void notifierMouseDragged(MouseEvent e, IMovableDrawable d) {
		// TODO Auto-generated method stub
		for(INonOverlapMouseAdapterObservateur obs : observateurs)
		{
			obs.mouseDragged(e, d);
		}
	}

}
