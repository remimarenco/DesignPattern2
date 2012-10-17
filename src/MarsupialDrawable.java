import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class MarsupialDrawable extends FormDrawable {
	protected Marsupial marsupial = new Koala("Hedi le malade");
	// TODO: Double-enveloppe
	
	public MarsupialDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

	public Marsupial getMarsupial() {
		return this.marsupial;
	}
}
