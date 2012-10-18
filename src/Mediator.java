import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Mediator {
	protected List<MarsupialDrawable> lMarsupialDrawable = new ArrayList<MarsupialDrawable>();
	protected JCanvas jc;
	protected List<IObservateur> listeObs;
	protected Fenetre fenetre;
	
	public Mediator(){
		listeObs = new ArrayList<IObservateur>();
		
		//on créait la fenetre
		fenetre=new Fenetre(this);
		
		//onrécupere le JCanvas de la fenetre
		jc =fenetre.getCanvas();
	}
	
	public JCanvas getCanvas()
	{
		return jc;
	}
	
	public void leftClickAction(MouseEvent e) {
		// Demande de v�rification si on a cliqu� sur un objet existant ou non
		IDrawable drawable = jc.getDrawableFromPoint(e.getPoint());
		if(drawable == null)
		{
			jc.leftClickAction(e);
		}
		else
		{
			// On change d'�tat
			MarsupialDrawable drawableM = (MarsupialDrawable) drawable;
			Marsupial marsu = drawableM.getMarsupial();
			marsu.changerEtat();
			if(marsu.estReveille)
			{
				jc.changerCouleur(drawableM, Color.RED);
			}
			else
			{
				jc.changerCouleur(drawableM, Color.BLUE);
			}
		}
	}

	public void rightClickAction(MouseEvent e) {
		// On r�cup�re l'�l�ment drawable de la vue
		jc.rightClickAction(e);

		jc.actualiser();
	}
}
