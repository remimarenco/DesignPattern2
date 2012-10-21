package IHM;

import java.awt.Point;

import Metier.IObservable;

/**
 * Interface permettant de d�finir le design pattern d'observation
 * entre les listeners et le mediator. Cette interface permet d'�tre observ�.
 * @author RemiPortable
 *
 */
public interface ISimpleMouseMediatorListenerObservable extends IObservable {
	public void notifierLeftClick(Point p);
	public void notifierRightClick(Point p);
}
