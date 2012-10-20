package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Metier.IObservateur;

public interface INonOverlapMouseAdapterObservateur extends IObservateur {
	public void mouseReleased(MouseEvent e, IMovableDrawable d, Point p);
	public void mousePressed(MouseEvent e, IMovableDrawable d, Point p);
	public void mouseDragged(MouseEvent e, IMovableDrawable d); 
}
