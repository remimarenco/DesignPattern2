package IHM;

import java.awt.Point;

import Metier.IObservateur;

public interface ISimpleMouseMediatorListenerObservateur extends IObservateur {
	public void leftClick(Point p);
	public void rightClick(Point p);
}
