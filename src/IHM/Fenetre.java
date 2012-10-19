package IHM;
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

import Controleur.Mediator;


public class Fenetre extends JPanel {
	
	
	
	protected JCanvas canvas;
    protected JPanel form;//	Jpanel qui contiendra la liste déroulante

	public Fenetre(Mediator mediator) {
		super();
		
		//on creait le canvas avec le médiator passé en parametre
		canvas=new JCanvas(mediator);
		
		//on creait le JPanel form
		form= new JPanel();
		form.setBackground(Color.YELLOW);
		form.setPreferredSize(new Dimension(1000, 70));
		
		//on créait un panel qui sera contenue dans form
		JPanel centre=new JPanel();
		centre.setPreferredSize(new Dimension(200, 50));
		centre.setBackground(Color.YELLOW);
		centre.setLayout(new GridLayout(2,2));
		
		//on créait les element du formulaire
		JLabel labelRace=new JLabel("Race");
	    Choice listeDeroulante = new Choice(); 
	    listeDeroulante.addItem("Opossum"); 
	    listeDeroulante.addItem("Koala"); 
	    listeDeroulante.setBackground(Color.WHITE);
		//form.add(listeDeroulante);
		JTextField champNom=new JTextField();
		champNom.setPreferredSize(new Dimension(100, 25));
		JLabel labelNom=new JLabel("Nom");
		
		
		//on ajoute les elements
		centre.add(labelRace);
		centre.add(listeDeroulante);
		centre.add(labelNom);
		centre.add(champNom);
		form.add(centre);

		
		
		
		//on ajoute les 2 JPanel a la fenetre
		this.add(form);
		this.add(canvas);
		
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

	public JPanel getForm() {
		return form;
	}

	public void setForm(JPanel form) {
		this.form = form;
	}
	

}
