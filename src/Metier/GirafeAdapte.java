package Metier;

/**
 * Design pattern adapter
 * Permet d'adapter une girafe en marsupial
 * @author RemiPortable
 *
 */
public class GirafeAdapte extends MarsupialAdapteur {

	public GirafeAdapte(String nom, ComportementSommeil cSommeil, Girafe girafe) {
		super(nom, cSommeil);
		this.animalAdapte = girafe;
		// TODO Auto-generated constructor stub
	}

	public GirafeAdapte(String nom, Girafe girafe) {
		super(nom);
		this.animalAdapte = girafe;
		// TODO Auto-generated constructor stub
	}

}
