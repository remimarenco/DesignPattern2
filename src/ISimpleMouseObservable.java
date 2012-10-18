import java.awt.event.MouseEvent;


public interface ISimpleMouseObservable extends IObservable {
	public void notifierLeftClick(MouseEvent e);
	public void notifierRightClick(MouseEvent e);
}
