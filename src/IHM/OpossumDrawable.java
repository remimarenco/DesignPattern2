package IHM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import Metier.Opossum;

/**
 * Design pattern Template Method + Adaptation via le Marsupial
 * Classe permettant de définir le comportement d'un Opossum Drawable
 * @author RemiPortable
 *
 */
public class OpossumDrawable extends MarsupialDrawable {

	public OpossumDrawable(Point p, Dimension d, String nom) {
		
		super(p, d);
		//on creait un koala
	    this.marsupial=new Opossum(nom);
		
	}
	
	@Override
	public  void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.height,rect.width);
		//couleur noir pour le texte
		g.setColor(Color.black);
		//afficher le nom
		g.drawString(this.marsupial.getNom(),rect.x,rect.y);
		//afficher l'etat
		g.drawString(this.marsupial.getLibelleEtat(),rect.x,rect.y+(rect.width/2));
		g.setColor(c);
	}

}
