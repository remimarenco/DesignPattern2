package Metier;

/**
 * Design pattern Strategy et Template Method
 * Classe permettant de simuler le sommeil pendu par la queue
 * @author RemiPortable
 *
 */
public class SommeilQueue implements ComportementSommeil {

	@Override
	public String dormir() {
		// TODO Auto-generated method stub
		return "dort pendu par la queue";
	}

	@Override
	public String seReveiller() {
		// TODO Auto-generated method stub
		return "se réveille et descend de l'arbre";
	}

}
