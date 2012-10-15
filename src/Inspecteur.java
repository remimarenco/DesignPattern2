import java.lang.reflect.*;
import java.lang.Class;

public class Inspecteur {

	
	public Object getAnimal(String className, String name)
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
	
}
