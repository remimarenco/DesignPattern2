package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Design pattern Template Method
 * Classe étendant le FormDrawable. Permet de créer un rectangle.
 * @author RemiPortable
 *
 */
public class RectangleDrawable extends FormDrawable {

	public RectangleDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

}
