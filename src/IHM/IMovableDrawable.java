package IHM;

import java.awt.Point;

/**
 * Interface permettant de d�finir tout Drawable que l'on peut bouger.
 * Design pattern Template Method
 * @author RemiPortable
 *
 */
public interface IMovableDrawable extends IDrawable {
	void setPosition(Point p);
	
	Point getPosition();
}
