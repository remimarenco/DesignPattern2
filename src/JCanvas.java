import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;


public class JCanvas extends JPanel implements INonOverlapMouseAdapterObservateur{
	protected Mediator mediator;
	protected IMovableDrawable drawable;
	protected Point initialLocation;
	
	public JCanvas(Mediator mediator)
	{
		this.mediator = mediator;
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(400, 200));
		Dimension dim = new Dimension(40, 40);
		GUIHelper.showOnFrame(this, "JCanvas");
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Iterator iter = mediator.lMarsupialDrawable.iterator(); iter.hasNext();) {
			IDrawable d = (IDrawable) iter.next();
			d.draw(g);	
		}
	}

	public void addDrawable(IDrawable d) {
		MarsupialDrawable dm = (MarsupialDrawable) d;
		mediator.lMarsupialDrawable.add(dm);
		repaint();
	}

	public void removeDrawable(IDrawable d) {
		MarsupialDrawable dm = (MarsupialDrawable) d;
		mediator.lMarsupialDrawable.remove(d);
		repaint();
	}
	
	public List findDrawables(Point p) {
		List l = new ArrayList();
		for (Iterator iter = mediator.lMarsupialDrawable.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(element.getRectangle().contains(p)){
				l.add(element);
			}
		}
		return l;
	}
	
	public boolean isFree(Rectangle rect) {
		for (Iterator iter = mediator.lMarsupialDrawable.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(element.getRectangle().intersects(rect)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isAlone(IDrawable drawable) {
		Rectangle rect = drawable.getRectangle();
		for (Iterator iter = mediator.lMarsupialDrawable.iterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(!element.equals(drawable) &&  element.getRectangle().intersects(rect)) {
				return false;
			}
		}
		return true;
	}
	
	protected void leftClickAction(MouseEvent e) {
		Point p = e.getPoint();
		IDrawable rect = createDrawable(e);
		if (this.isFree(rect.getRectangle())) {
			this.addDrawable(rect);
		}
	}
	
	private IDrawable createDrawable(MouseEvent e) {
		Point p = e.getPoint();
		Dimension dim = new Dimension(40, 40);
		return new MarsupialDrawable(Color.RED, p, dim);
	}
	
	public IDrawable getDrawableFromPoint(Point p)
	{
		List selectedDrawables = findDrawables(p);
		if (selectedDrawables.size() == 0) return null;
		IDrawable drawable = (IDrawable) selectedDrawables.get(0);
		return drawable;
	}

	public void clear() {
		mediator.lMarsupialDrawable.clear();
		repaint();
	}

	public void actualiser() {
		repaint();
	}

	public void rightClickAction(MouseEvent e) {		
		mediator.lMarsupialDrawable.remove(getDrawableFromPoint(e.getPoint()));
	}

	public void changerCouleur(FormDrawable drawableM, Color color) {
		drawableM.color = color;
	}
	
	// ---------- Evenements de souris ----------- //

	@Override
	public void actualiser(Object objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		if(drawable == null) return ;
		if( !this.isAlone(drawable)){
			drawable.setPosition(initialLocation);
		}
		initialLocation = null;
		drawable = null;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e, IMovableDrawable d, Point p) {
		// TODO Auto-generated method stub
		List selectedDrawables = this.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		drawable = (IMovableDrawable) selectedDrawables.get(0);
		if(drawable!=null) {
			initialLocation=drawable.getPosition();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e, IMovableDrawable d) {
		// TODO Auto-generated method stub
		if (drawable != null) {
			drawable.setPosition(e.getPoint());
			this.repaint();
		}
	}
}
