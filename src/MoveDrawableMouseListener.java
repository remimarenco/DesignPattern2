import java.awt.event.MouseEvent;
import java.util.List;


public class MoveDrawableMouseListener extends JCanvasMouseListener {
	protected IMovableDrawable drawable;

	
	public MoveDrawableMouseListener(JCanvas canvas, Mediator mediator) {
		super(canvas, mediator);
	}

	
	public void mouseDragged(MouseEvent e) {
		if (drawable != null) {
			drawable.setPosition(e.getPoint());
			canvas.repaint();
		}
	}

	
	public void mousePressed(MouseEvent e) {
		List selectedDrawables = canvas.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		drawable = (IMovableDrawable) selectedDrawables.get(0);
	}

	public void mouseReleased(MouseEvent e) {
		drawable = null;
	}

}
