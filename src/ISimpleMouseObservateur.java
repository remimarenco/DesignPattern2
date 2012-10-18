import java.awt.event.MouseEvent;


public interface ISimpleMouseObservateur extends IObservateur {
	public void leftClick(MouseEvent e);
	public void rightClick(MouseEvent e);
}
