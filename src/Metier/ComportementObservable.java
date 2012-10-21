package Metier;
import java.util.ArrayList;
import java.util.List;

/**
 * Design pattern Strategy
 * Classe permettant d'implémenter le comportement observable
 * @author RemiPortable
 *
 */
public class ComportementObservable implements IObservable {
	
	List<IObservateur> listeObs;
	Marsupial marsupial;
	
	public ComportementObservable()
	{
		listeObs = new ArrayList<IObservateur>();
	}
	
	@Override
	public void ajouterObservateur(IObservateur obs) {
		listeObs.add(obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		listeObs.remove(obs);
	}

	@Override
	public void notifierObservateurs() {
		for(IObservateur obs: listeObs)
		{
			obs.actualiser(marsupial);
		}
	}

	public Marsupial getMarsupial() {
		return marsupial;
	}

	public void setMarsupial(Marsupial marsu) {
		this.marsupial = marsu;
	}

}
