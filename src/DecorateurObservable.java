
public abstract class DecorateurObservable extends Marsupial implements Observable{
	public IComportementObservable cObservable;
	public Marsupial marsupial;
	
	public DecorateurObservable(Marsupial marsupial) {
		super(marsupial.getNom());
		this.marsupial = marsupial;
		this.cObservable = new ComportementObservable();
	}
	
	public void ajouterObservateur(Observateur obs)
	{
		cObservable.ajouterObservateur(obs);
	}
	
	public void supprimerObservateur(Observateur obs)
	{
		cObservable.supprimerObservateur(obs);
	}
	
	public void notifierObservateurs()
	{
		cObservable.notifierObservateurs();
	}
}
