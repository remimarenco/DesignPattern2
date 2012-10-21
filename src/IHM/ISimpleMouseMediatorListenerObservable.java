package IHM;

import java.awt.Point;

import Metier.IObservable;

/**
 * Interface permettant de définir le design pattern d'observation
 * entre les listeners et le mediator. Cette interface permet d'être observé.
 * @author RemiPortable
 *
 */
public interface ISimpleMouseMediatorListenerObservable extends IObservable {
	public void notifierLeftClick(Point p);
	public void notifierRightClick(Point p);
}
