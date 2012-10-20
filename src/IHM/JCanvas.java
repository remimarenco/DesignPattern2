package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.Mediator;


public class JCanvas extends JPanel implements ISimpleMouseMediatorVueObservateur,INonOverlapMouseAdapterObservateur{
	protected Mediator mediator;
	protected IMovableDrawable drawable;
	protected Point initialLocation;
	
	public JCanvas(Mediator mediator)
	{
		//on parametre le Jpanel
		JPanel conteneur= new JPanel();
		this.mediator = mediator;
		this.setBackground(Color.WHITE);
		
		this.setPreferredSize(new Dimension(1000, 500));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Iterator iter = mediator.marsuDrawIterator(); iter.hasNext();) {
			IDrawable d = (IDrawable) iter.next();
			d.draw(g);	
		}
	}

	public void addDrawable(IDrawable d) {
		MarsupialDrawable dm = (MarsupialDrawable) d;
		mediator.addMarsu(dm);
		repaint();
	}

	public void removeDrawable(IDrawable d) {
		MarsupialDrawable dm = (MarsupialDrawable) d;
		mediator.removeMarsu(dm);
		repaint();
	}
	
	public List findDrawables(Point p) {
		List l = new ArrayList();
		for (Iterator iter = mediator.marsuDrawIterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(element.getRectangle().contains(p)){
				l.add(element);
			}
		}
		return l;
	}
	
	public boolean isFree(Rectangle rect) {
		for (Iterator iter = mediator.marsuDrawIterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(element.getRectangle().intersects(rect)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isAlone(IDrawable drawable) {
		Rectangle rect = drawable.getRectangle();
		for (Iterator iter = mediator.marsuDrawIterator(); iter.hasNext();) {
			IDrawable element = (IDrawable) iter.next();
			if(!element.equals(drawable) &&  element.getRectangle().intersects(rect)) {
				return false;
			}
		}
		return true;
	}
	//TODO: enlever le commentaire
	protected void leftClickAction(MouseEvent e) {
		Point p = e.getPoint();
		/*IDrawable rect = createDrawable(e);
=======
		IDrawable rect = createDrawable(p);
>>>>>>> cff80ee74faa82b1bdf2e848352587846fb4a4e7
		if (this.isFree(rect.getRectangle())) {
			this.addDrawable(rect);
		}*/
	}
	
	//TODO: Remettre en private
	public IDrawable createDrawable(Point p) {
		Dimension dim = new Dimension(40, 40);

		return new MovableDrawable();
	}
	
	public IDrawable getDrawableFromPoint(Point p)
	{
		List selectedDrawables = findDrawables(p);
		if (selectedDrawables.size() == 0) return null;
		IDrawable drawable = (IDrawable) selectedDrawables.get(0);
		return drawable;
	}

	public void clear() {
		mediator.clearMarsu();
		repaint();
	}

	public void actualiser() {
		repaint();
	}

	public void rightClickAction(MouseEvent e) {		
		
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
	public void mouseDragged(MouseEvent e, IMovableDrawable d){
		if(drawable != null)
		{
			drawable.setPosition(e.getPoint());
			this.repaint();
		}
	}

	@Override
	public void leftClick(IDrawable e) {
		// TODO Auto-generated method stub
		if(this.isFree(drawable.getRectangle()))
		{
			this.addDrawable(drawable);
		}
	}

	@Override
	public void rightClick(IDrawable e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	
}
