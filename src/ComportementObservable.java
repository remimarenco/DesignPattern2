import java.util.ArrayList;
import java.util.List;


public class ComportementObservable implements IComportementObservable {
	List<Observateur> listeObs;
	
	public ComportementObservable()
	{
		listeObs = new ArrayList<Observateur>();
	}
	
	@Override
	public void ajouterObservateur(Observateur obs) {
		// TODO Auto-generated method stub
		listeObs.add(obs);
	}

	@Override
	public void supprimerObservateur(Observateur obs) {
		// TODO Auto-generated method stub
		listeObs.remove(obs);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		for(Observateur obs: listeObs)
		{
			obs.actualiser(this);
		}
	}

}
