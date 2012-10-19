import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class KoalaDrawable extends MarsupialDrawable {

	public KoalaDrawable(Color color, Point pos, Dimension dim, String nom) {
		super(color, pos, dim);
		
		//on creait un koala
		this.marsupial=new Koala(nom);
		
	}
	
	
	
	@Override
	public  void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(rect.x,rect.y,rect.height,rect.width);
		g.drawString("Testtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt",0,0);
		g.setColor(c);
	}

}
