package Metier;


public class MammouthAdapte extends MarsupialAdapteur {
	public MammouthAdapte(ComportementSommeil cSommeil, Mammouth mammouth) {
		super(mammouth.getNom(), cSommeil);
		this.animalAdapte = mammouth;
	}

	public MammouthAdapte( Mammouth mammouth) {
		super(mammouth.getNom());
		this.animalAdapte = mammouth;
	}	
}
