import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JPanel {
	
	
	
	protected JCanvas canvas;
    protected JForm form;//	Jpanel qui contiendra la liste déroulante

	public Fenetre(Mediator mediator,JCanvas xcanvas,JForm xform) {
		super();
		
		
		//on recupere les JPanel canvas et form passez en parametre
		this.form= xform;
		this.canvas=xcanvas;
				
		
		//on ajoute les 2 JPanel a la fenetre
		this.add(this.form);
		this.add(this.canvas);
		
		//on affiche le JPanel fenetre
		this.setPreferredSize(new Dimension(1000, 600));
		GUIHelper.showOnFrame(this, "Conteneur");
	}
	
	public JCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(JCanvas canvas) {
		this.canvas = canvas;
	}

	public JForm getForm() {
		return form;
	}

	public void setForm(JForm form) {
		this.form = form;
	}
	

}
