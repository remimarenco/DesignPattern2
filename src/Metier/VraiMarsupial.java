package Metier;

/**
 * Classe permettant de construire des vrais marsupiaux
 * @author RemiPortable
 *
 */
public abstract class VraiMarsupial extends MarsupialSeul {

	public VraiMarsupial(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
	}

	public VraiMarsupial(String nom) {
		super(nom);
	}
}
