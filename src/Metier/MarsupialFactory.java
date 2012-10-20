package Metier;

import java.util.List;



public class MarsupialFactory implements IMarsupialArboricolFactory {
	// On partage une variable entre les instances de la classe MarsupialFactory
	private static MarsupialFactory instance;
	
	// On met en private le constructeur de la classe pour éviter son appel
	private MarsupialFactory(){
	}
	
	// La création d'une classe MarsupialFactory n'est possible qu'au travers de cette méthode
	// Elle retourne l'actuelle instance si on avait déjà créé l'objet
	public static MarsupialFactory getInstance(){
		if(instance == null)
		{
			instance = new MarsupialFactory();
		}
		return instance;
	}

	@Override
	public MarsupialObservable getKoala(String nom) {
		//on declare le koala observable
		MarsupialObservable koalaObservable = new MarsupialObservable(new Koala(nom));
		return koalaObservable;
	}

	@Override
	public MarsupialObservable getOpossum(String nom) {
		//on declare l'opossum observable
		MarsupialObservable opossumObservable = new MarsupialObservable(new Opossum(nom));
		return opossumObservable;
	}

	@Override
	public MarsupialObservable getMammouth(String nom) {

		//on declare le mamouth adaptÃ© observable
		MarsupialObservable mammouthObservable = new MarsupialObservable(new MammouthAdapte(new Mammouth(nom)));
		return mammouthObservable;
	}
	
	public MarsupialObservable getTroupe(String nom, List<Marsupial> marsupiaux) {
		//on declare la troupe 
		TroupeMarsupial troupe=new TroupeMarsupial("nom");
		
		//on ajoute la troupe dans la liste
		troupe.setMarsupiaux(marsupiaux);
		
		MarsupialObservable troupeObservable = new MarsupialObservable(troupe);
		return troupeObservable ;
	}
	



}
