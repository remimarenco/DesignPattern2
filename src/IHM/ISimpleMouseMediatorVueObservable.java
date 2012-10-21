package IHM;

import java.awt.event.MouseEvent;

import Metier.IObservable;

/**
 * Interface permettant de d�finir le design pattern d'observation
 * entre le mediator et les vues. Elle permet d'etre observ�.
 * @author RemiPortable
 *
 */
public interface ISimpleMouseMediatorVueObservable extends IObservable {
	public void notifierLeftClick(IDrawable drawable);
	public void notifierRightClick(IDrawable drawable);
}
