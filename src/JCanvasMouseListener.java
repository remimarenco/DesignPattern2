import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;


public abstract class JCanvasMouseListener extends MouseAdapter {
	protected JCanvas canvas;

	public JCanvasMouseListener(JCanvas canvas) {
		super();
		this.canvas = canvas;
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
	}
		
	public JCanvas getCanvas() {
		return canvas;
	}

	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			leftClickAction(e);
		} else {
			rightClickAction(e);
		}
	}

	
	protected void rightClickAction(MouseEvent e) {
	}

	protected void leftClickAction(MouseEvent e) {
	}
}
