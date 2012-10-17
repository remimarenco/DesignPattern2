import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TestZoo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("\n******************************Test Marsupial application******************************");

		//on declare la factory
		MarsupialFactory factory = MarsupialFactory.getInstance();
		
		Object[] obj = {"Hedi le petit Koala"};
		
		MarsupialObservable titi = (MarsupialObservable) Inspecteur.getInstanceFromFabrique("MarsupialFactory", "Koala", obj);
		
		titi.ajouterObservateur(new Console());
		titi.changerEtat();
		
		Object[] obj2 = {"Morgan le grand Koala"};
		
		MarsupialObservable tata = (MarsupialObservable) Inspecteur.getInstanceFromFabrique(factory, "Koala", obj2);
		
		tata.ajouterObservateur(new Console());
		tata.changerEtat();
		
		//on recupere des marsupial depuis la factory
		MarsupialObservable bernard = factory.getKoala("Bernard le koala");
		MarsupialObservable jean = factory.getMammouth("Jean le mammouth");
		MarsupialObservable remi = factory.getOpossum("Remi l'oppossum");
		
		
		//pas d'obervateur donc aucun affichage
		bernard.changerEtat();
		
		//on ajoute un obervateur "Console"
		bernard.ajouterObservateur(new Console());
		bernard.changerEtat();
		
		
		//on declare une liste de marupiaux et on les ajoute
		List<Marsupial> marsupiaux=new ArrayList<Marsupial>();
		marsupiaux.add(bernard);
		marsupiaux.add(jean);
		marsupiaux.add(remi);
		
		//on creait une troupe grace à la factory en lui passant la liste en parametre
		MarsupialObservable troupe = factory.getTroupe("Troupe",marsupiaux);
		
		//on change l'etat de toute la troupe
		troupe.changerEtat();
		
		Inspecteur.Invoquer(bernard, "changerEtat", null);
		troupe.changerEtat();
		
		Object[] args2 = {"Inspecteur Opossum"};
		
		Opossum marsuB = (Opossum) Inspecteur.getObject("Opossum", args2);
		
		System.out.println(marsuB.getNom());
		
		System.out.println(bernard.getNom());
		
		Mediator mediator = new Mediator();
	}

}
