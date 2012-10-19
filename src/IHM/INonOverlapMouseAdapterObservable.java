package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Metier.IObservable;

public interface INonOverlapMouseAdapterObservable extends IObservable {
	public void notifierMouseReleased(MouseEvent e, IMovableDrawable d, Point p);
	public void notifierMousePressed(MouseEvent e, IMovableDrawable d, Point p);
	public void notifierMouseDragged(MouseEvent e, IMovableDrawable d);
}
