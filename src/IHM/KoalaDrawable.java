package IHM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import Metier.Koala;


/**
 * Design pattern Template Method + Adaptation via le Marsupial
 * Classe permettant de définir le comportement d'un Koala Drawable
 * @author RemiPortable
 *
 */
public class KoalaDrawable extends MarsupialDrawable {

	public KoalaDrawable(Point p, Dimension d, String nom) {
		super(p, d);
		
		//on creait un koala
	    this.marsupial=new Koala(nom);
	}
	
	
	@Override
	public  void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(rect.x,rect.y,rect.height,rect.width);
		//couleur noir pour le texte
		g.setColor(Color.black);
		//afficher le nom
		g.drawString(this.marsupial.getNom(),rect.x,rect.y);
		//afficher l'etat
		g.drawString(this.marsupial.getLibelleEtat(),rect.x,rect.y+(rect.width/2));
		g.setColor(c);
	}

}
