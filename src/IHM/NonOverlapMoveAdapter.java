package IHM;

import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * Implémentation d'un listener MouseMotion ayant la fonctionnalité
 * de gérer l'Overlap
 * @author RemiPortable
 *
 */
public class NonOverlapMoveAdapter extends MoveDrawableMouseListener {
	protected Point initialLocation;

	
	public NonOverlapMoveAdapter(JCanvas canvas) {
		super(canvas);
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}

	
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
	}
}
