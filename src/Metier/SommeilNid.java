package Metier;

/**
 * Design pattern Strategy et Template Method
 * Comportement d'un sommeil dans le nid
 * @author RemiPortable
 *
 */
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
