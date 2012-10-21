package Metier;

/**
 * Design Pattern template method
 * Classe permettant de cr�er un Koala
 * @author RemiPortable
 *
 */
public class Koala extends VraiMarsupial {

	public Koala(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
	}

	public Koala(String nom) {
		super(nom);
	}

}
