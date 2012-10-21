package IHM;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Interface de base de tout dessin graphique
 * Source: http://duj.developpez.com/tutoriels/java/dessin/intro/
 * @author RemiPortable
 *
 */
public interface IDrawable {
	public void draw(Graphics g);
	
	public Rectangle getRectangle();
}
