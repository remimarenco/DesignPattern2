package Metier;

/**
 * Design pattern Strategy, Decorator, Observateur
 * Classe permettant de cr�er des marsupiaux pouvant �tre observ�
 * @author RemiPortable
 *
 */
public class MarsupialObservable extends Marsupial implements IObservable{
	protected ComportementObservable cObservable;
	protected Marsupial marsupial;
	
	public MarsupialObservable(Marsupial marsupial) {
		super(marsupial.getNom());
		this.marsupial = marsupial;
		this.cObservable = new ComportementObservable();
	}
	
	public void ajouterObservateur(IObservateur obs)
	{
		cObservable.ajouterObservateur(obs);
	}
	
	public void supprimerObservateur(IObservateur obs)
	{
		cObservable.supprimerObservateur(obs);
	}
	
	public void notifierObservateurs()
	{
		//on met le marsu dans le comportement observable pour recupere le libellé
		cObservable.setMarsupial(this.marsupial);
		
		cObservable.notifierObservateurs();
	}
	public void changerEtat()
	{
		//on applle une fonction du comportement différente (dormir ou reveille) en fonction de l'etat du marsu
		if(this.getEstReveille())
		{
			this.setEstReveille(false);
		} else {
			this.setEstReveille(true);
		}
		//on notifie l'observateur du chamgement d'etat
		this.notifierObservateurs();
	}
}
