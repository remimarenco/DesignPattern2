package Metier;


public interface IObservable {
	public void ajouterObservateur(IObservateur obs);
	
	public void supprimerObservateur(IObservateur obs);
	
	public void notifierObservateurs();
}
