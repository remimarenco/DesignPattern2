
public interface Observable {
	public void ajouterObservateur(Observateur obs);
	
	public void supprimerObservateur(Observateur obs);
	
	public void notifierObservateurs();
}
