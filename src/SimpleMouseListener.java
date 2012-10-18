import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;


public abstract class SimpleMouseListener extends JCanvasMouseListener {
	public SimpleMouseListener(JCanvas canvas) {
		super(canvas);
	}

	protected void rightClickAction(MouseEvent e) {
	}

	protected void leftClickAction(MouseEvent e) {
	}	
}
