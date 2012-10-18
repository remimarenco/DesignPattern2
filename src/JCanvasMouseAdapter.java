import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


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
