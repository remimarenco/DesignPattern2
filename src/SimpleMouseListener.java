import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;


public class SimpleMouseListener extends JCanvasMouseListener {
	public SimpleMouseListener(JCanvas canvas, Mediator mediator) {
		super(canvas, mediator);
	}

	protected void rightClickAction(MouseEvent e) {
		mediator.rightClickAction(e);
	}

	protected void leftClickAction(MouseEvent e) {
		
		mediator.leftClickAction(e);
	
	}

	
}
