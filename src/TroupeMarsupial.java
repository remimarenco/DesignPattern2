import java.util.ArrayList;
import java.util.List;


public class TroupeMarsupial extends Marsupial {

	protected List<Marsupial> marsupiaux = new ArrayList<Marsupial>();

	
	public TroupeMarsupial(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public TroupeMarsupial(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
		// TODO Auto-generated constructor stub
	}
	
	public void dormir(){
		for (Marsupial marsu : marsupiaux)
		{
			marsu.dormir();
		}
	}

	public void seReveiller(){
		for (Marsupial marsu : marsupiaux)
		{
			marsu.seReveiller();
		}
	}
	
	public boolean ajouteMarsupial(Marsupial marsu) {
		return marsupiaux.add(marsu);
		}

	
}
