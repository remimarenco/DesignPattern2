import java.awt.Point;
import java.awt.event.MouseEvent;


public class NonOverlapMoveAdapter extends MoveDrawableMouseListener {
	private Point initialLocation;

	
	public NonOverlapMoveAdapter(JCanvas canvas, Mediator mediator) {
		super(canvas, mediator);
		
	}

	
	public void mouseReleased(MouseEvent e) {
		if(drawable== null) return ;
		if( !canvas.isAlone(drawable)){
			drawable.setPosition(initialLocation);
		}
		initialLocation = null;
		drawable = null;
		canvas.repaint();
	}

	
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if(drawable!=null) {
			initialLocation=drawable.getPosition();
		}
	}
}
