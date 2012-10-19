import java.awt.Point;
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
		Point p = e.getPoint();
		IDrawable drawable = canvas.getDrawableFromPoint(p);
		notifierRightClick(drawable);
	}

	protected void leftClickAction(MouseEvent e) {
		super.leftClickAction(e);
		Point p = e.getPoint();
		IDrawable drawable = canvas.getDrawableFromPoint(p);
		if(drawable == null)
		{
			drawable = canvas.createDrawable(p);
		}
		notifierLeftClick(drawable);
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
	public void notifierLeftClick(IDrawable drawable) {
		for(ISimpleMouseObservateur obs : observateurs)
		{
			obs.leftClick(drawable);
		}
	}

	@Override
	public void notifierRightClick(IDrawable drawable) {
		for(ISimpleMouseObservateur obs : observateurs)
		{
			obs.rightClick(drawable);
		}
	}

}
