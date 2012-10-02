
public class TestZoo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//on déclare les animaux
		Koala bernard= new Koala("Bernard");
		Koala jean= new Koala("Jean");
		Opossum remi= new Opossum("Remi");
		Opossum hedi= new Opossum("Hedi");
		Mammouth patrick=new Mammouth("Patrick le mamouth");
		
		//on adapte le mamouth
		MammouthAdapte patrickAdapte=new MammouthAdapte(patrick);
		//on créer la troupe de marsupial
		TroupeMarsupial troupe=new TroupeMarsupial("troupe");
		
		//on ajoute les masupiaux a la troupe
		troupe.ajouteMarsupial(bernard);
		troupe.ajouteMarsupial(jean);
		troupe.ajouteMarsupial(remi);
		troupe.ajouteMarsupial(patrickAdapte);
		troupe.ajouteMarsupial(hedi);
		
		
		System.out.println("\n\n********Test Marsupial seul********");
		//on change l'etat du marsupial jean
		jean.changerEtat();
		jean.changerEtat();
		jean.changerEtat();
		jean.changerEtat();
		jean.changerEtat();
		
		System.out.println("\n\n********Test Marsupial troupe********");
		//on change l'etat de toute la troupe de marsupiaux
		troupe.changerEtat();
		System.out.println("\n");
		troupe.changerEtat();

		
	}

}
