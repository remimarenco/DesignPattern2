import java.awt.event.MouseEvent;


public interface ISimpleMouseMediatorVueObservable extends IObservable {
	public void notifierLeftClick(IDrawable drawable);
	public void notifierRightClick(IDrawable drawable);
}
