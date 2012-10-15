import java.lang.reflect.*;
import java.lang.Class;

public class Inspecteur {
	// On �vite de pouvoir instancier la classe
	private Inspecteur(){
	}
	
	public static Object getAnimal(String className, String name)
	{
		
		Class animal;
		Constructor constructeur = null;
		Object result=null;
		
		try {
			
			//on récupere la classe
			animal=Class.forName(className);
			
			//on récupere le constructeur
			constructeur=animal.getConstructor(String.class);
			//on récupere l'objet
			result=constructeur.newInstance(name);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// erreur securié
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// le constructeur n'existe pas
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
