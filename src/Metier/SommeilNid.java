package Metier;


public class SommeilNid implements ComportementSommeil {

	@Override
	public String dormir() {
		return "dort dans le nid";
	}

	@Override
	public String seReveiller() {
		return "se réveille dans le nid";
	}

}
