package Metier;


public abstract class Marsupial extends Animal {
	protected ComportementSommeil cSommeil;
	
	private Boolean estReveille;

	public Marsupial(String nom) {
		super(nom);
		
		//on donne un comportement par defaut au marsupial
		this.cSommeil = new SommeilNid();
		this.setEstReveille(true);

	}
	
	public Marsupial(String nom, ComportementSommeil cSommeil) {
		super(nom);
		this.cSommeil = cSommeil;
	}

	//change la variable d'etat du marsu
	public void changerEtat()
	{
		if(this.getEstReveille())
		{
			this.setEstReveille(false);
		} else {
			this.setEstReveille(true);
		}
	}
	
	//renvoie le libellé de l'etat du marsu
	public String getLibelleEtat()
	{
		if(this.getEstReveille())
		{
			return this.cSommeil.dormir();

		} else {
			return this.cSommeil.seReveiller();

		}
	}
	
	public Boolean getEstReveille() {
		return estReveille;
	}

	public void setEstReveille(Boolean estReveille) {
		this.estReveille = estReveille;
	}
}
