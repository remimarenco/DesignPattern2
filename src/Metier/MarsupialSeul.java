package Metier;

/**
 * Design pattern composite
 * Classe abstraite permettant de cr�er une marsupial seul
 * @author RemiPortable
 *
 */
public abstract class MarsupialSeul extends Marsupial {

	public MarsupialSeul(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public MarsupialSeul(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
		// TODO Auto-generated constructor stub
	}
	
	public void dormir()
	{
		System.out.println(this.nom + " " + this.cSommeil.dormir());
	}
	
	public void seReveiller()
	{
		System.out.println(this.nom + " " + this.cSommeil.seReveiller());
	}

}
