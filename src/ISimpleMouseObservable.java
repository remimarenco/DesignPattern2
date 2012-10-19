import java.awt.event.MouseEvent;


public interface ISimpleMouseObservable extends IObservable {
	public void notifierLeftClick(IDrawable drawable);
	public void notifierRightClick(IDrawable drawable);
}
