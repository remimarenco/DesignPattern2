import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class SimpleMouseListenerObservable extends SimpleMouseListener implements ISimpleMouseObservable {
	private List<ISimpleMouseObservateur> observateurs = new ArrayList<ISimpleMouseObservateur>();
	
	public SimpleMouseListenerObservable(JCanvas canvas) {
		super(canvas);
	}
	
	protected void rightClickAction(MouseEvent e) {
		super.rightClickAction(e);
		notifierRightClick(e);
	}

	protected void leftClickAction(MouseEvent e) {
		super.leftClickAction(e);
		notifierLeftClick(e);
	}

	@Override
	public void ajouterObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.add((ISimpleMouseObservateur)obs);
	}

	@Override
	public void supprimerObservateur(IObservateur obs) {
		// TODO Auto-generated method stub
		observateurs.remove((ISimpleMouseObservateur)obs);
	}

	@Override
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifierLeftClick(MouseEvent e) {
		for(ISimpleMouseObservateur obs : observateurs)
		{
			obs.leftClick(e);
		}
	}

	@Override
	public void notifierRightClick(MouseEvent e) {
		// TODO Auto-generated method stub
		for(ISimpleMouseObservateur obs : observateurs)
		{
			obs.rightClick(e);
		}
	}

}
