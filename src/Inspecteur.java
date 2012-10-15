import java.lang.reflect.*;
import java.lang.Class;

public class Inspecteur {
	// On �vite de pouvoir instancier la classe
	private Inspecteur(){
	}
	
	
	
	public static Object getObject(String className, Object[] args)
	{
		
		Class obj;
		Constructor[] constructeurs;//tableau de constructeur
		Object result=null;
		int nbrArg= args.length;
		int indice=0;
		try {
			
			//on récupere la classe
			obj=Class.forName(className);
			
			
			//on récupere les constructeurs
			constructeurs=obj.getConstructors();	

			
			//on parcout tous les constructeurs
			for(Constructor constructeur : constructeurs)	
			{	
				//si le constructeur a le meme nombre de parametres que ceux passer a la fonction
				if(constructeur.getParameterTypes().length==nbrArg)
				{
					//on récupere les arguments de ce constructeur
					Class[] argsConstructeur=constructeur.getParameterTypes();
					
					//on initialse un booléen qui servira pour verifier que tous les parametres sont correctes
					boolean estCorrect=true;
					
					//on parcout tous les arguments pour les comparer 
					for(indice=0;indice<nbrArg;indice++)
					{
								
						//si un des arguments ne correcpond pas on mais le booléen a faux
						if(args[indice].getClass() != argsConstructeur[indice])
						{
							estCorrect=false;
						}
					}
					
					//si le constructeur correcpond on appelle le constructeur
					if(estCorrect)
					{
						//on récupere l'objet
						result=constructeur.newInstance(args);
						break;
					}
				}
			}	

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// erreur securié
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
		
	}
	
	
	
	public static Object Invoquer(Object obj, String nomMethode, Object paramObj, Object[] tabParams){
		try {
			Class maClassObj = obj.getClass();
			Method maMethod = maClassObj.getMethod(nomMethode);
			return maMethod.invoke(paramObj, tabParams);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
