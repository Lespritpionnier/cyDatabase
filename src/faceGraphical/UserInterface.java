package faceGraphical;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.toolsModule.textAnalysis.SyntaxHandling;
import mainStructures.unitStockpile.CyDatabase;
import mainStructures.unitStockpile.StatusAltering;

import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;



public class UserInterface extends JFrame {

	protected JLabel lblNewLabel = new JLabel("Here is for important message :)");
	protected JTextField checkField = new JTextField(30);
	
	private JTable tableau;
	private JButton btnValid = new JButton("V\r\nA\r\nL\r\nI\r\nD");
	private JButton btnSave = new JButton("Save");
	private JButton btnImport = new JButton("Import");
	private  JButton btnUndo = new JButton("Undo");
	private  JButton btnRedo = new JButton("Redo");
	private  JButton btnPath = new JButton("Path");
	
	private  JPanel pan = new JPanel();
	JTextArea textArea = new JTextArea();
	private   JScrollPane scrollPane_1 = new JScrollPane(textArea);

public UserInterface(){
	  this.setLocationRelativeTo(null);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setTitle("CyDatabase");
	  this.setSize(600, 500);
  
	  CyDatabase myDB = new CyDatabase();
	  StatusAltering stock = new StatusAltering();
	  
	  
	  
	  
  	
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
	  scrollPane_1.setBounds(271, 0, 240, 133);
	  scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  pan.add(scrollPane_1);
	  //textArea.setColumns(30);
	  //textArea.setPreferredSize( new Dimension(200, 100) );
	  
	  tableau = new JTable();
	  tableau.setDefaultRenderer(JButton.class, new TableComponent());
	  tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	  getContentPane().setLayout(null);
//	  System.out.println("Nombre de colonne : " + model.getColumnCount());
//	  System.out.println("Nombre de ligne : " + model.getRowCount());
	  
	  this.getContentPane().add(pan);
	  
	  btnUndo.setBounds(137, 52, 125, 40);
	  pan.add(btnUndo);
	  
	  btnRedo.setBounds(10, 52, 125, 40);
	  pan.add(btnRedo);
	  
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
			  JTModel model = new JTModel(data, title);
			  tableau.setModel(model);
			  textArea.setText("");
			  stock.markStatus(myDB);
		  }
		  
	  }
	  btnValid.addActionListener(new ValidAction());
	  
	 class OutCheckAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chose = new JFileChooser();
				chose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int retour = chose.showOpenDialog(getParent());

				if (retour == JFileChooser.APPROVE_OPTION) {
					File[] fs = chose.getSelectedFiles();
					for (int i = 1; i < fs.length; ++i) {
						// nom du fichier
						fs[i].getName();
						// chemin absolu du fichier
						fs[i].getAbsolutePath();
					}
				}
				checkField.setText(chose.getSelectedFile().getAbsolutePath()+"/");
			}
		}
	 btnPath.addActionListener(new OutCheckAction());
	 
	 
	 
	 
	 class SaveAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//checkField;
			}
		}
	 	btnSave.addActionListener(new SaveAction());
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}





