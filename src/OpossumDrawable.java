import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class OpossumDrawable extends MarsupialDrawable {

	public OpossumDrawable(Color color, Point pos, Dimension dim, String nom) {
		super(color, pos, dim);
		
		//on creait un oppossum
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
