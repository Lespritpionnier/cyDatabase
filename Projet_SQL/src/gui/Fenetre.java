package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


public class Fenetre extends JFrame {
private JTable tableau;
private JButton valid = new JButton("Valid");
private JButton save = new JButton("save");
private JButton importer = new JButton("importer");

JTextArea textArea = new JTextArea();


public Fenetre(){
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("JTable");
  this.setSize(800, 500);
  
  Object[][] data = {
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."},  
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."},  
		  {"...", "...", "...","...", "...","...", "..."},  
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."}, 
		  {"...", "...", "...","...", "...","...", "..."},  
		  {"...", "...", "...","...", "...","...", "..."}
		  
  };

	  String  title[] = {"nom", "Nom", "nom", "nom","nom", "Nom", "nom"};
	  ZModel model = new ZModel(data, title);
	  
	  this.tableau = new JTable(model);
	  JPanel pan = new JPanel();
	
	  
	  pan.add(save);
	  pan.add(importer);
	  pan.add(valid);
	  pan.add(new JScrollPane(textArea));
	  textArea.setColumns(30);
	  textArea.setPreferredSize( new Dimension( 500, 100 ) );
	  
	  System.out.println("Nombre de colonne : " + model.getColumnCount());
	  System.out.println("Nombre de ligne : " + model.getRowCount());
	  
	  this.tableau.setDefaultRenderer(JButton.class, new TableComponent());
	  this.getContentPane().add(pan, BorderLayout.SOUTH);
	  
	  JButton ajouter = new JButton("Ajouter une ligne");
	  this.getContentPane().add(ajouter, BorderLayout.NORTH);
	  
	  ///affiche le tableau au centre
	  this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	  //affiche le scroll horizontal
	  tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  this.setVisible(true);

	}
}





