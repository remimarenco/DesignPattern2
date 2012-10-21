package IHM;
import Metier.IObservateurMarsupial;
import Metier.Marsupial;

/**
 * Classe permettant d'afficher les notifications dans la console
 * @author Hedi Tarchouni
 *
 */
public class Console implements IObservateurMarsupial{


	public void actualiser(Marsupial marsu) {
		System.out.println("\n"+marsu.getNom()+" "+marsu.getLibelleEtat());
		
	}

	@Override
	public void actualiser(Object objet) {		
	}	
}
