import java.awt.event.MouseEvent;


public interface ISimpleMouseObservateur extends IObservateur {
	public void leftClick(IDrawable e);
	public void rightClick(IDrawable e);
}
