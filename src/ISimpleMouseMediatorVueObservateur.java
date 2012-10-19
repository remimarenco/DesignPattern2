import java.awt.event.MouseEvent;


public interface ISimpleMouseMediatorVueObservateur extends IObservateur {
	public void leftClick(IDrawable e);
	public void rightClick(IDrawable e);
}
