
public abstract class Marsupial extends Animal {
	protected ComportementSommeil cSommeil;
	
	protected Boolean estReveille;

	public Marsupial(String nom) {
		super(nom);
		
		//on donne un comportement par defaut au marsupial
		this.cSommeil = new SommeilNid();
		this.estReveille=true;

	}
	
	public Marsupial(String nom, ComportementSommeil cSommeil) {
		super(nom);
		this.cSommeil = cSommeil;
	}

	//change la variable d'etat du marsu
	public void changerEtat()
	{
		if(this.estReveille)
		{
			this.estReveille=false;
		} else {
			this.estReveille=true;
		}
	}
	
	//renvoie le libellé de l'etat du marsu
	public String getLibelleEtat()
	{
		if(this.estReveille)
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
