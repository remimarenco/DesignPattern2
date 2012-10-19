import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class OpossumDrawable extends MarsupialDrawable {

	public OpossumDrawable(IDrawable drawable, String nom) {
		
		super(drawable);
		
		//on creait un koala
	    this.marsupial=new Opossum(nom);
		
	}
	
	@Override
	public  void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

}
