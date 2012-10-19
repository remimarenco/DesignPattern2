import java.awt.Point;


public interface ISimpleMouseMediatorListenerObservable extends IObservable {
	public void notifierLeftClick(Point p);
	public void notifierRightClick(Point p);
}
