import java.lang.reflect.*;
import java.lang.Class;

public class Inspecteur {
	// On évite de pouvoir instancier la classe
	private Inspecteur(){
	}
	
	public static Object getAnimal(String className, String name)
	{
		
		Class animal;
		Constructor constructeur = null;
		Object result=null;
		
		try {
			
			//on rÃ©cupere la classe
			animal=Class.forName(className);
			
			//on rÃ©cupere le constructeur
			constructeur=animal.getConstructor(String.class);
			//on rÃ©cupere l'objet
			result=constructeur.newInstance(name);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// erreur securiÃ©
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
	
	
	
	public static Object Invoquer(Object obj, String nomMethode, Object[] tabParams){
		try {
			Class maClassObj = obj.getClass();
			Method maMethod = maClassObj.getMethod(nomMethode);
			return maMethod.invoke(obj, tabParams);
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
	
	public static Object getInstanceFromFabrique(String nomFabrique, String nomObjetAFabriquer, Object[] args)
	{
		Object instance = null;
		try {
			Class<?> facto = Class.forName(nomFabrique);
			Method[] methods = facto.getMethods();
			for(Method method : methods)
			{
				if(method.getName().contains(nomObjetAFabriquer)){
					try {
						Object objFactory = null;
						// Vérification si on passe par un Singleton
						if(facto.getConstructors().length == 0){
							objFactory = facto.getMethod("getInstance", null).invoke(null, null);
						}
						// Sinon on prends le constructeur par défaut
						else
						{
							try {
								objFactory = facto.getConstructor().newInstance();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						instance = method.invoke(objFactory, args);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instance;
	}
	
	public static Object getInstanceFromFabrique(Object fabrique, String nomObjetAFabriquer, Object[] args)
	{
		Object instance = null;
		try {
			Class<?> facto = fabrique.getClass();
			Method[] methods = facto.getMethods();
			for(Method method : methods)
			{
				if(method.getName().contains(nomObjetAFabriquer)){
					try {
						instance = method.invoke(fabrique, args);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
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
}
