package IHM;

import java.awt.Point;

import Metier.IObservable;


public interface ISimpleMouseMediatorListenerObservable extends IObservable {
	public void notifierLeftClick(Point p);
	public void notifierRightClick(Point p);
}
