package Metier;

/**
 * Classe de base d'Animal
 * @author RemiPortable
 *
 */
public abstract class Animal {
	protected String nom;
	
	public Animal(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
