package IHM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;



public class CircleDrawable extends FormDrawable {

	public CircleDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

}
