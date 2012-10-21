package Metier;
import java.util.List;

/**
 * Design pattern abstract factory
 * Interface permettant de créer des marsupiaux 
 * @author RemiPortable
 *
 */
public interface IMarsupialArboricolFactory {
	
	//on declare une methode pour charque type de marsu
	public MarsupialObservable getKoala(String nom);
	public MarsupialObservable getOpossum(String nom);
	public MarsupialObservable getMammouth(String nom);
	public MarsupialObservable getTroupe(String nom, List<Marsupial> marsupiaux);
}
