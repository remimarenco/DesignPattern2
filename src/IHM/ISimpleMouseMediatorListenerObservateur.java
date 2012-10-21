package IHM;

import java.awt.Point;

import Metier.IObservateur;

/**
 * Interface permettant de définir le design pattern d'observation
 * entre les listeners et le mediator. Cette interface permet d'observer.
 * @author RemiPortable
 *
 */
public interface ISimpleMouseMediatorListenerObservateur extends IObservateur {
	public void leftClick(Point p);
	public void rightClick(Point p);
}
