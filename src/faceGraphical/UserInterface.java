package faceGraphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mainStructures.dataFramework.TableArchetype;
import mainStructures.toolsModule.textAnalysis.SyntaxHandling;
import mainStructures.unitStockpile.CyDatabase;
import mainStructures.unitStockpile.StatusAltering;

import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

/**
 * This is the main body of IHM
 */

public class UserInterface extends JFrame {

	protected JLabel mess = new JLabel("GOOD LUCK MY FRIENDS :)");
	protected JTextField checkField = new JTextField(30);

	private JTable tableau;
	private JButton btnValid = new JButton("VALID");
	private JButton btnSave = new JButton("Save");
	private JButton btnImport = new JButton("Import");
	private  JButton btnUndo = new JButton("Undo");
	private  JButton btnRedo = new JButton("Redo");
	private  JButton btnPath = new JButton("Path");

	private  JPanel pan = new JPanel();
	JTextArea textArea = new JTextArea();
	private   JScrollPane scrollPane_1 = new JScrollPane(textArea);
	private final JButton btnHarryP = new JButton("Harry P.");
	int rank =1;
	protected CyDatabase myDB = new CyDatabase();

	public UserInterface() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CyDatabase");
		this.setSize(600, 500);

		StatusAltering stock = new StatusAltering(myDB);

		pan.setBounds(0, 320, 582, 133);
		pan.setLayout(null);
		mess.setBounds(10, 100, 260, 30);

		pan.add(mess);
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

		tableau = new JTable();
		tableau.setDefaultRenderer(JButton.class, new TableComponent());
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().setLayout(null);
		this.getContentPane().add(pan);

		btnUndo.setBounds(137, 40, 125, 40);
		pan.add(btnUndo);

		btnRedo.setBounds(10, 40, 125, 40);
		pan.add(btnRedo);

		btnPath.setBounds(0, 0, 90, 40);
		pan.add(btnPath);
		btnHarryP.setBounds(78, 79, 113, 27);

		pan.add(btnHarryP);

		///affiche le tableau au centre
		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 582, 320);
		this.getContentPane().add(scrollPane);

		this.setVisible(true);


		class ValidAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				String requis = textArea.getText();
				SyntaxHandling synSQL = new SyntaxHandling(myDB.getMyTables(), requis);
				TableArchetype pre = synSQL.makeNodes();
				String[][] data = pre.toJTable();
				String[] title = pre.getTitle();
				JTModel model = new JTModel(data, title);
				tableau.setModel(model);
				textArea.setText("");
				stock.markStatus();
				mess.setText(synSQL.getMessage());
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
				checkField.setText(chose.getSelectedFile().getAbsolutePath());
			}
		}
		btnPath.addActionListener(new OutCheckAction());


		class SaveAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				stock.saveStatus(checkField.getText());
			}
		}
		btnSave.addActionListener(new SaveAction());

		class ImportAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				stock.readStatus(checkField.getText());
			}
		}
		btnImport.addActionListener(new ImportAction());

		class RedoAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDB = stock.redoStatus();
			}
		}
		btnRedo.addActionListener(new RedoAction());

		class UndoAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDB = stock.undoStatus();
			}
		}
		btnUndo.addActionListener(new UndoAction());


		class HarryAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				TableArchetype hp = null;
				
				if (rank == 1) {
					hp = HarryPotter.magic1(myDB);
					rank++;
				} else if (rank == 2) {
					for (int i = 0; i < 10000; i++) {
						hp = HarryPotter.magic2(myDB);
					}
					rank++;
				} else if (rank == 3) {
					hp = HarryPotter.magic3(myDB);
					rank++;
				} else if (rank == 4) {
					for (int i = 0; i < 10000; i++) {
						hp = HarryPotter.magic4(myDB);
					}
					rank++;
				} else if (rank == 5) {
					hp = HarryPotter.magic5(myDB);
					rank++;
				} else if (rank == 6) {
					for (int i = 0; i < 10000; i++) {
						hp = HarryPotter.magic6(myDB);
					}
					rank++;
				}

				assert hp != null;
				String[][] data = hp.toJTable();
				String[] title = hp.getTitle();
				JTModel model = new JTModel(data, title);
				tableau.setModel(model);
				textArea.setText("");
				stock.markStatus();
			}
		}
		btnHarryP.addActionListener(new HarryAction());
	}

		public static void main(String[] args) {
			new UserInterface();
		}
	}





