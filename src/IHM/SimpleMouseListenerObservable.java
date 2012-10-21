package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import Metier.IObservateur;

/**
 * Design pattern Observation et Template Method.
 * Classe permettant d'etre observée pour relayer les informations de 
 * MouseM avec gestion d'Overlap
 * @author RemiPortable
 *
 */
public class SimpleMouseListenerObservable extends SimpleMouseListener implements ISimpleMouseMediatorListenerObservable {
	private List<ISimpleMouseMediatorListenerObservateur> observateurs = new ArrayList<ISimpleMouseMediatorListenerObservateur>();
	
	public SimpleMouseListenerObservable(JCanvas canvas) {
		super(canvas);
	}
	
	protected void rightClickAction(MouseEvent e) {
		super.rightClickAction(e);
		Point p = e.getPoint();
		notifierRightClick(p);
	}

	protected void leftClickAction(MouseEvent e) {
		super.leftClickAction(e);
		Point p = e.getPoint();
		notifierLeftClick(p);
	}

	@Override
	public void ajouterObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.add((ISimpleMouseMediatorListenerObservateur)obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.remove((ISimpleMouseMediatorListenerObservateur)obs);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifierLeftClick(Point point) {
		for(ISimpleMouseMediatorListenerObservateur obs : observateurs)
		{
			obs.leftClick(point);
		}
	}

	@Override
	public void notifierRightClick(Point point) {
		for(ISimpleMouseMediatorListenerObservateur obs : observateurs)
		{
			obs.rightClick(point);
		}
	}

}
