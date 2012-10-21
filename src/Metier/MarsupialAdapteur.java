package Metier;

/**
 * Design pattern adapter
 * Classe abstraite permettant de définir le fonctionnement d'un marsupial adapteur
 * @author RemiPortable
 *
 */
public abstract class MarsupialAdapteur extends MarsupialSeul {
	
	protected Animal animalAdapte;
	
	public MarsupialAdapteur(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}
	
	public MarsupialAdapteur(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
		// TODO Auto-generated constructor stub
	}

	public Animal getAnimalAdapte() {
		return animalAdapte;
	}

	public void setAnimalAdapte(Animal animalAdapte) {
		this.animalAdapte = animalAdapte;
	}
	
	
}
