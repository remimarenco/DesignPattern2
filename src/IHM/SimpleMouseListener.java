package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;


/**
 * Design pattern Template Method
 * Listener permettant de gérer l'observation d'un SimpleMouse
 * @author RemiPortable
 *
 */
public abstract class SimpleMouseListener extends JCanvasMouseListener {
	public SimpleMouseListener(JCanvas canvas) {
		super(canvas);
	}

	protected void rightClickAction(MouseEvent e) {
	}

	protected void leftClickAction(MouseEvent e) {
	}	
}
