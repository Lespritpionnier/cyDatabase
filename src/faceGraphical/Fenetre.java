package faceGraphical;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.toolsModule.textAnalysis.SyntaxHandling;
import mainStructures.unitStockpile.CyDatabase;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;


public class Fenetre extends JFrame {
private JTable tableau;
private JButton btnValid = new JButton("V\r\nA\r\nL\r\nI\r\nD");



private JButton btnSave = new JButton("Save");
private JButton btnImport = new JButton("Import");

JTextArea textArea = new JTextArea();
private final JLabel lblNewLabel = new JLabel("Formule d\u2018Algebre Relationelle");


public Fenetre(){
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("JTable");
  this.setSize(600, 500);
  
  CyDatabase myDB = new CyDatabase();
  	

	  JPanel pan = new JPanel();
	  pan.setBounds(0, 320, 582, 133);
	  pan.setLayout(null);
	  lblNewLabel.setBounds(10, 100, 260, 30);
	  
	  pan.add(lblNewLabel);
	  btnSave.setBounds(90, 0, 90, 40);
	
	  
	  pan.add(btnSave);
	  btnImport.setBounds(180, 0, 90, 40);
	  pan.add(btnImport);
	  btnValid.setBounds(510, 0, 73, 133);
	  pan.add(btnValid);
	  JScrollPane scrollPane_1 = new JScrollPane(textArea);
	  scrollPane_1.setBounds(271, 0, 240, 133);
	  scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  pan.add(scrollPane_1);
	  textArea.setColumns(30);
	  textArea.setPreferredSize( new Dimension(200, 100) );
	  
	  tableau = new JTable();
	  tableau.setDefaultRenderer(JButton.class, new TableComponent());
	  tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  getContentPane().setLayout(null);
//	  System.out.println("Nombre de colonne : " + model.getColumnCount());
//	  System.out.println("Nombre de ligne : " + model.getRowCount());
	  
	  this.getContentPane().add(pan);
	  
	  JButton btnUndo = new JButton("Undo");
	  btnUndo.setBounds(137, 52, 125, 40);
	  pan.add(btnUndo);
	  
	  JButton btnRedo = new JButton("Redo");
	  btnRedo.setBounds(10, 52, 125, 40);
	  pan.add(btnRedo);
	  
	  JButton btnPath = new JButton("Path");
	  btnPath.setBounds(0, 0, 90, 40);
	  pan.add(btnPath);
	  
	  ///affiche le tableau au centre
	  JScrollPane scrollPane = new JScrollPane(tableau);
	  scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  scrollPane.setBounds(0, 0, 582, 320);
	  this.getContentPane().add(scrollPane);
	  //affiche le scroll horizontal

	  this.setVisible(true);

	  
	  class ValidAction implements ActionListener {
		  @Override
		  public void actionPerformed(ActionEvent e) {
			  String requis = textArea.getText();
			  SyntaxHandling synSQL = new SyntaxHandling(myDB.getMyTables(),requis);
			  TableArchetype pre = synSQL.makeNodes();
			  
		  	  String[][] data = pre.toJTable();
			  String title[] = pre.getTitle();
			  ZModel model = new ZModel(data, title);
			  tableau.setModel(model);
			  
		  }
		  
	  }
	  btnValid.addActionListener(new ValidAction());
	  
	}
}





