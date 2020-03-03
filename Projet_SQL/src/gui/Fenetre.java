package gui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable; 
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class Fenetre extends JFrame {
private DefaultMutableTreeNode racine; 
private JTree arbre;
private JTable tableau;
private JButton validation = new JButton("Validation");
JTextField textField = new JTextField();

public Fenetre(){
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("JTable");
  this.setSize(500, 400);

  Object[][] data = {
		  {"1", "Jean", new Double(45411.80),"1", "Jean","1", "Jean"}, 
		  {"2", "Jean", new Double(45411.80),"1", "Jean","1", "Jean"}, 
		  {"3", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"},
		  {"4", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"},
		  {"5", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"},
		  {"6", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}, 
		  {"7", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}, 
		  {"8", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}, 
		  {"9", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}, 
		  {"10", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"},
		  {"11", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}, 
		  {"12", "Jean", new Double(45411.80),"1", "Jean", "1", "Jean"}
		  
  };

  String  title[] = {"identifiant", "Nom", "Numero", "valide","identifiant", "Nom", "Numero"};
  ZModel model = new ZModel(data, title);
  
  this.tableau = new JTable(model);
  JPanel pan = new JPanel();

  pan.add(validation);
  pan.add(textField);
  textField.setColumns(10);
  
  System.out.println("Nombre de colonne : " + model.getColumnCount());
  System.out.println("Nombre de ligne : " + model.getRowCount());
  
  this.tableau.setDefaultRenderer(JButton.class, new TableComponent());
  
  this.getContentPane().add(pan, BorderLayout.SOUTH);
  
  JButton ajouter = new JButton("Ajouter une ligne");
  this.getContentPane().add(ajouter, BorderLayout.NORTH);
  
  JTree arbre = new JTree();
  ///affiche le tableau au centre
  this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
  //affiche le scroll horizontal
  tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   
  //On invoque la méthode de construction de l'arbre
  listRoot();
    
  this.setVisible(true);
}


private void listRoot(){      
    this.racine = new DefaultMutableTreeNode();       
    int count = 0;
    for(File file : File.listRoots()){
      DefaultMutableTreeNode lecteur = 
      new DefaultMutableTreeNode(file.getAbsolutePath());
      try {
        for(File nom : file.listFiles()){
          DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName()+"\\");               
          lecteur.add(this.listFile(nom, node));               
        }
      } catch (NullPointerException e) {}

      this.racine.add(lecteur);                 
    }
    //Nous créons, avec notre hiérarchie, un arbre
    arbre = new JTree(this.racine);      
    //Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll 
    this.getContentPane().add(new JScrollPane(arbre), BorderLayout.EAST);
  }

  private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node){
    int count = 0;
      
    if(file.isFile())
      return new DefaultMutableTreeNode(file.getName());
    else{
      File[] list = file.listFiles();
      if(list == null)
        return new DefaultMutableTreeNode(file.getName());

      for(File nom : list){
        count++;
        //Pas plus de 5 enfants par noeud
        if(count < 5){
          DefaultMutableTreeNode subNode;
          if(nom.isDirectory()){
            subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
            node.add(this.listFile(nom, subNode));
          }else{
            subNode = new DefaultMutableTreeNode(nom.getName());
          }
          node.add(subNode);
        }
      }
      return node;
    }
  }
}
