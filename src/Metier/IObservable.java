package Metier;

/**
 * Interface permettant d'etre observ� via le Design pattern Observable
 * @author RemiPortable
 *
 */
public interface IObservable {
	public void ajouterObservateur(IObservateur obs);
	
	public void supprimerObservateur(IObservateur obs);
	
	public void notifierObservateurs();
}
