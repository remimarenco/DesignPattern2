package IHM;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JForm extends JPanel {

	
	JTextField champNom;
	Choice listeDeroulante;
	public JForm() {
		//on parametre le JPANEL form
		this.setBackground(Color.YELLOW);
		this.setPreferredSize(new Dimension(1000, 70));
		
		//on créait un panel qui sera contenue dans form
		JPanel centre=new JPanel();
		centre.setPreferredSize(new Dimension(200, 50));
		centre.setBackground(Color.YELLOW);
		centre.setLayout(new GridLayout(2,2));
		
		//on créait les element du formulaire
		JLabel labelRace=new JLabel("Race");
	    listeDeroulante = new Choice(); 
	    listeDeroulante.addItem("Opossum"); 
	    listeDeroulante.addItem("Koala"); 
	    listeDeroulante.setBackground(Color.WHITE);
	    
		//form.add(listeDeroulante);
		champNom=new JTextField();
		champNom.setPreferredSize(new Dimension(100, 25));
		JLabel labelNom=new JLabel("Nom");
		
		
		//on ajoute les elements
		centre.add(labelRace);
		centre.add(listeDeroulante);
		centre.add(labelNom);
		centre.add(champNom);
		this.add(centre);
	}
	
	
	//fonction qui renvoie la race
	public 	String getRace() {
		return this.listeDeroulante.getSelectedItem();
	}
	
	
	//fonction qui renvoie le nom
	public 	String getNom() {
		return this.champNom.getText();
	}
	


}
