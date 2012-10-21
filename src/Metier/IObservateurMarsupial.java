package Metier;

/**
 * Interface permettant d'observer des Marsupiaux
 * Design pattern observateur
 * @author RemiPortable
 *
 */
public interface IObservateurMarsupial extends IObservateur {
	public void actualiser(Marsupial marsu);
}
