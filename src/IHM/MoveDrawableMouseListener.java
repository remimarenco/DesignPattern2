package IHM;

import java.awt.event.MouseEvent;
import java.util.List;


/**
 * Classe abstraite d'un listener sur MouseMotion
 * @author RemiPortable
 *
 */
public abstract class MoveDrawableMouseListener extends JCanvasMouseListener {
	protected IMovableDrawable drawable;
	
	public MoveDrawableMouseListener(JCanvas canvas) {
		super(canvas);
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		drawable = null;
	}
}
