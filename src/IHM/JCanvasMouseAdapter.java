package IHM;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Controleur.Mediator;

/**
 * Design pattern Template Method
 * Class permettant de créer un Canvas implémentant le SimpleMouse et le MouseMotion
 * @author RemiPortable
 *
 */
public class JCanvasMouseAdapter extends JCanvasMouseListener implements MouseMotionListener {
	public JCanvasMouseAdapter(JCanvas canvas, Mediator mediator) {
		super(canvas);
		canvas.addMouseMotionListener(this);
		
	}

	public void mouseDragged(MouseEvent e) {
			
	}

	
	public void mouseMoved(MouseEvent e) {
			
	}
}
