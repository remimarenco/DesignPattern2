import java.awt.Point;

public interface ISimpleMouseMediatorListenerObservateur extends IObservateur {
	public void leftClick(Point p);
	public void rightClick(Point p);
}
