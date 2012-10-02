
public class MarsupialFactory implements IMarsupialArboricolFactory {

	@Override
	public Koala getKoala(String nom) {
		// TODO Auto-generated method stub
		return new Koala(nom);
	}

	@Override
	public Opossum getOpossum(String nom) {
		// TODO Auto-generated method stub
		return new Opossum(nom);
	}

	@Override
	public MammouthAdapte getMammouth(String nom) {
		// TODO Auto-generated method stub
		return new MammouthAdapte(new Mammouth(nom));
	}

	@Override
	public GirafeAdapte getGirafe(String nom) {
		// TODO Auto-generated method stub
		return new GirafeAdapte(new Girafe(nom));
	}

}
