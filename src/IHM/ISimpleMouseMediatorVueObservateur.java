package IHM;

import java.awt.event.MouseEvent;

import Metier.IObservateur;


public interface ISimpleMouseMediatorVueObservateur extends IObservateur {
	public void leftClick(IDrawable e);
	public void rightClick(IDrawable e);
}
