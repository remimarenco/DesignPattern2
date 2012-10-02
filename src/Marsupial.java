
public abstract class Marsupial extends Animal {
	protected ComportementSommeil cSommeil;
	
	private Boolean estReveille;

	public Marsupial(String nom) {
		super(nom);
		this.cSommeil = new SommeilNid();
		// TODO Auto-generated constructor stub
	}
	
	public Marsupial(String nom, ComportementSommeil cSommeil) {
		super(nom);
		this.cSommeil = cSommeil;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void dormir();
	
	public abstract void seReveiller();
	
	public Boolean getEstReveille() {
		return estReveille;
	}

	public void setEstReveille(Boolean estReveille) {
		this.estReveille = estReveille;
	}
}
