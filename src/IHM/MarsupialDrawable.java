package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import Metier.Marsupial;

/**
 * Design Pattern Template Method et Adapter
 * Classe permettant de définir un MarsupialDrawable
 * @author RemiPortable
 *
 */
public abstract class  MarsupialDrawable extends FormDrawable {
	
	protected Marsupial marsupial;
	// TODO: Double-enveloppe
	
	public MarsupialDrawable(Point p,Dimension dim) {
		super(Color.BLUE,p,dim);
	}
	public MarsupialDrawable(IDrawable drawable) {
		
		super(Color.BLUE, drawable.getRectangle().getLocation(), drawable.getRectangle().getSize());
		
	}

	//Fonction qui sera redefinie par les classe fille pour dessinÃ© une forme en fonction de la race 
	@Override
	public  void draw(Graphics g)
	{
		
	}

	public Marsupial getMarsupial() {
		return this.marsupial;
	}
	
	//fonction qui va changer la couleur du dessin du marsu puis changer l'etat du marsu
	public  void changerEtat() {
		
		//on change la couleur 
		if(this.marsupial.getEstReveille())
		{
			this.setColor(Color.RED);
		} else {
			this.setColor(Color.BLUE);
		}
		//on change l'etat
		marsupial.changerEtat();
		
		
	}
}
