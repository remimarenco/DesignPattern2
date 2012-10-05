
public class Console implements IObservateur{


	public void actualiser(Marsupial marsu) {
		System.out.println("\n"+marsu.getNom()+" "+marsu.getLibelleEtat());
		
	}

	
}
