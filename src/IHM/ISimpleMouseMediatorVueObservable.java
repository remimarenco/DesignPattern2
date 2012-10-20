package IHM;

import java.awt.event.MouseEvent;

import Metier.IObservable;


public interface ISimpleMouseMediatorVueObservable extends IObservable {
	public void notifierLeftClick(IDrawable drawable);
	public void notifierRightClick(IDrawable drawable);
}
