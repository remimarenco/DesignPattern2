import java.lang.reflect.*;
import java.lang.Class;

public class Inspecteur {
	
	// On évite de pouvoir instancier la classe
	private Inspecteur(){
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
