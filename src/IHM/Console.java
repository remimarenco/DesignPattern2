package IHM;
import Metier.IObservateurMarsupial;
import Metier.Marsupial;


public class Console implements IObservateurMarsupial{


	public void actualiser(Marsupial marsu) {
		System.out.println("\n"+marsu.getNom()+" "+marsu.getLibelleEtat());
		
	}

	@Override
	public void actualiser(Object objet) {		
	}	
}
