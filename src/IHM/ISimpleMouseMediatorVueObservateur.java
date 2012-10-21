package IHM;

import java.awt.event.MouseEvent;

import Metier.IObservateur;

/**
 * Interface permettant de définir le design pattern d'observation
 * entre le mediator et les vues. Elle permet d'observer.
 * @author RemiPortable
 *
 */
public interface ISimpleMouseMediatorVueObservateur extends IObservateur {
	public void leftClick(IDrawable e);
	public void rightClick(IDrawable e);
}
