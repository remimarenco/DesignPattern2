import java.util.List;


public class MarsupialFactory implements IMarsupialArboricolFactory {



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

		//on declare le mamouth adapté observable
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
