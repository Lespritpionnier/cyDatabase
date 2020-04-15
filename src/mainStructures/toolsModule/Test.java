package mainStructures.toolsModule;

import java.util.ArrayList;

import mainStructures.dataFramework.TableDatabase;
import mainStructures.saveStockpile.CyDatabase;
import mainStructures.textCommands.nodesPart.CommandJointJOIN;
import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.textCommands.nodesPart.ExecutionTree;
import mainStructures.toolsModule.makeAnalysis.SyntaxHandling;
import mainStructures.toolsModule.treeExcutable.OldTreeBuilder;

public class Test {
	public static void main(String[] args){
		/*SyntaxHandling test = new SyntaxHandling("SELECT aa.you, bb.him cc.her FROM tb1 AS aa JOIN tb2 AS bb ON condition JOIN tb3 AS cc ON condition WHERE you=1;");
		ArrayList<ExecutionTree> abc = test.getNodes();
		
		CommandJointJOIN join1=new CommandJointJOIN();
		CommandJointJOIN join2=new CommandJointJOIN();*/
	
		
//		TableDatabase tab1=new TableDatabase("tab1", null);
//		TableDatabase tab2=new TableDatabase("tab2", null);
//		TableDatabase tab3=new TableDatabase("tab3", null);
//		
//		CyDatabase base=new CyDatabase();
//		base.addTable(tab1);
//		base.addTable(tab2);
//		base.addTable(tab3);
//		 
//		base.serializationSave("fichier.ser");
//		base.serializationRead("fichier.ser");
//		
		
		
		CyDatabase myDB = new CyDatabase();
		
	

System.out.println("NOW CREATE TABLE");
		
		
		
		String creat = "CREATE TABLE adresse(" +
				"id_adresse AUTOINCREMENT, " +
				"id_commande LONG," +
				"numero TEXT, " +
				"nom TEXT, " +
				"prenom TEXT, " +
				"ville TEXT, " +
				"code_postal TEXT, "
				+ "PRIMARY KEY(id_adresse),"
				+ "FOREIGN KEY(id_commande) REFERENCES commande(id_commande);";
		SyntaxHandling creatSQL = new SyntaxHandling(myDB.getMyTables(),creat);
		System.out.println(myDB.toString());

		
		
		String creat2 = "CREATE TABLE commande(" +
				"id_commande AUTOINCREMENT, " +
				"id_voiture LONG, " +
				"numero2 TEXT, " +
				"nom2 TEXT, " +
				"prenom2 TEXT, " +
				"ville2 TEXT, " +
				"code_postal2 TEXT, " +
				"PRIMARY KEY(id_commande)," + 
				"FOREIGN KEY(id_voiture) REFERENCES voiture(id_voiture));";
		SyntaxHandling creatSQL2 = new SyntaxHandling(myDB.getMyTables(),creat2);
		System.out.println(myDB.toString());
		
		
		
		String creat3 = "CREATE TABLE voiture(" +
				"id_voiture AUTOINCREMENT, " +
				"numero3 TEXT, " +
				"nom3 TEXT, " +
				"prenom3 TEXT, " +
				"ville3 TEXT, " +
				"code_postal3 TEXT, " +
				"PRIMARY KEY(id_voiture));";
		SyntaxHandling creatSQL3 = new SyntaxHandling(myDB.getMyTables(),creat3);
		System.out.println(myDB.toString());
		
System.out.println("NOW INSERT INTO adresse");

		String insert1 = "INSERT INTO adresse (id_commande, numero, nom, prenom, ville, code_postal) " +
				"VALUES (3, \"5\", \"Jean\", \"Gean\", \"Paris\", \"75015\") ;";
		SyntaxHandling insertSQL1 = new SyntaxHandling(myDB.getMyTables(),insert1);
//System.out.println(myDB.getTable("adresse"));


		String insert2 = "INSERT INTO adresse (id_commande, numero, nom, prenom, ville, code_postal) " +
				"VALUES (1, \"8\", \"Michel\",\"Qean\", \"Paris\", \"75005\") ;";
		SyntaxHandling insertSQL2 = new SyntaxHandling(myDB.getMyTables(),insert2);
//System.out.println(myDB.getTable("adresse"));

		String insert3 = "INSERT INTO adresse (id_commande, numero, nom, prenom, ville, code_postal)" +
				"VALUES (2, \"2\", \"MACRON\", \"Eean\", \"Cergy\", \"95000\") ;";
		SyntaxHandling insertSQL3 = new SyntaxHandling(myDB.getMyTables(),insert3);
System.out.println(myDB.getTable("adresse"));

System.out.println("NOW INSERT INTO commande");
		
		String insert4 = "INSERT INTO commande (id_voiture, numero2, nom2, prenom2, ville2, code_postal2) " +
				"VALUES (2, \"22\", \"AJean\",\"Rean\", \"ParisA\", \"75115\") ;";
		SyntaxHandling insertSQL4 = new SyntaxHandling(myDB.getMyTables(),insert4);
//System.out.println(myDB.getTable("commande"));


		String insert5 = "INSERT INTO commande (id_voiture, numero2, nom2, prenom2, ville2, code_postal2) " +
				"VALUES (3, \"33\", \"AMichel\",\"Tean\", \"ParisA\", \"75105\") ;";
		SyntaxHandling insertSQL5 = new SyntaxHandling(myDB.getMyTables(),insert5);
//System.out.println(myDB.getTable("commande"));

		String insert6 = "INSERT INTO commande (id_voiture, numero2, nom2, prenom2, ville2, code_postal2)" +
				"VALUES (1, \"88\", \"AMACRON\",\"Bean\", \"CergyA\", \"95100\") ;";
		SyntaxHandling insertSQL6 = new SyntaxHandling(myDB.getMyTables(),insert6);
System.out.println(myDB.getTable("commande"));
		
		
System.out.println("NOW INSERT INTO voiture");
		
		String insert7 = "INSERT INTO voiture (numero3, nom3, prenom3, ville3, code_postal3) " +
				"VALUES (2, \"222\", \"BJean\",\"Aean\", \"ParisB\", \"75915\") ;";
		SyntaxHandling insertSQL7 = new SyntaxHandling(myDB.getMyTables(),insert7);
//System.out.println(myDB.getTable("voiture"));
		
		
		String insert8 = "INSERT INTO voiture (numero3, nom3, prenom3, ville3, code_postal3) " +
				"VALUES (3, \"333\", \"BMichel\",\"Oean\" \"ParisB\", \"75905\") ;";
		SyntaxHandling insertSQL8 = new SyntaxHandling(myDB.getMyTables(),insert8);
//System.out.println(myDB.getTable("voiture"));
		
		String insert9 = "INSERT INTO voiture (numero3, nom3, prenom3, ville3, code_postal3)" +
				"VALUES (1, \"888\", \"BMACRON\",\"Nean\", \"CergyB\", \"95900\") ;";
		SyntaxHandling insertSQL9 = new SyntaxHandling(myDB.getMyTables(),insert9);
System.out.println(myDB.getTable("voiture"));
		
		
		
System.out.println("NOW SELECT TREE");
		
		String select = "SELECT c.nom, c.prenom, c.code_postal " +
				" FROM  (adresse AS c INNER JOIN commande AS co " +
				" ON (c.id_commande = co.id_commande)) " +
				" INNER JOIN voiture AS v " +
				" ON (co.id_voiture = v.id_voiture) " +
				" WHERE c.ville = \"Paris\" AND c.numero >= 4; ";
		SyntaxHandling selectSQL = new SyntaxHandling(myDB.getMyTables(),select);
		
		





		/*
		CommandProjectionSELECT proj=new CommandProjectionSELECT();
		CommandSelectionWHERE sel=new CommandSelectionWHERE();
		
		TreeBuilder tree= new TreeBuilder();
		tree.add(proj);
		tree.add(sel);
		*/
		/*for(ExecutionTree tests : abc) {
		System.out.println(tree.getName(tests));
		}*/
		//tree.buildTree();
}
}
//(tests.getClass().getName()