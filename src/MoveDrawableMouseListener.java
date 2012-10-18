import java.awt.event.MouseEvent;
import java.util.List;


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
