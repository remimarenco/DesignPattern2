import java.util.ArrayList;
import java.util.List;


public class ComportementObservable implements IObservable {
	
	List<IObservateur> listeObs;
	Marsupial marsupial;
	
	public ComportementObservable()
	{
		listeObs = new ArrayList<IObservateur>();
	}
	
	@Override
	public void ajouterObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		listeObs.add(obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		listeObs.remove(obs);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
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
