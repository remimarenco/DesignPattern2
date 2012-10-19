package Metier;
import java.util.ArrayList;
import java.util.List;


public class TroupeMarsupial extends Marsupial {

	protected List<Marsupial> marsupiaux = new ArrayList<Marsupial>();

	
	public TroupeMarsupial(String nom) {
		super(nom);
	}

	public TroupeMarsupial(String nom, ComportementSommeil cSommeil) {
		super(nom, cSommeil);
	}
	

	public void changerEtat(){
		for (Marsupial marsu : marsupiaux)
		{
			marsu.changerEtat();
		}
	}
	
	public boolean ajouteMarsupial(Marsupial marsu) {
		return marsupiaux.add(marsu);
	}
	
	public void setMarsupiaux(List<Marsupial> listMarsupiaux)
	{
		this.marsupiaux=listMarsupiaux;
	}
	
}
