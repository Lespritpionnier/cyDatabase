package mainStructures.dataFramework;

import mainStructures.dataFramework.exceptions.TableFormatProblemException;
import mainStructures.dataFramework.itemTypes.KeyPrimary;
import mainStructures.textCommands.nodesPart.ExecutionTree;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class TableDatabase extends ArrayList<RowTable> implements ExecutionTree {
		private String[] title;
		public String[] getTitle() {return title;}
		public void setTitle(String[] title) {//System.out.println(title[2]);
			this.title = title;}

	//   private KeyPrimary keyCurrent;
    private String tableName;
    private LinkedHashMap<String,String> infoDatatype;
    private String primaryKey; 
    private HashMap<String,String> foreignKeys;
    private int nextKey; //MAYBE RELATE TO SIZE()
    //private ArrayList<Integer> indexRanked = new ArrayList<>()


    public TableDatabase(String tableName, LinkedHashMap<String,String> infoDatatype) {
       this.tableName=tableName;
       this.infoDatatype = infoDatatype;
       nextKey=1; //MAYBE RELATE TO SIZE()
		//if(infoDatatype!=null) {
       try{	for(String key: infoDatatype.keySet()){
	           if(infoDatatype.get(key).equals("PRIMARY_KEY")){ primaryKey=key; }
	       }
		}catch (NullPointerException e) {
			System.err.println("Table:\""+ tableName +"\" is " + e.getMessage());
		}
    }

    public String[][] toTable (){
    	String[][] jtable= new String[this.size()][title.length];
    	System.out.println(this.size()+" and "+title.length);
    	for(int i=0; i<this.size(); i++) {
    		for(int j = 0; j<title.length; j++) {
    			jtable[i][j]= this.get(i).get(title[j]).getData();
    			System.out.println(this.get(i).get(title[j]).getData());
    		}
    	}
		return jtable;
    }

    //Think about REMOVE()

    public SeriesTable toVirtual () {
    	return new SeriesTable(infoDatatype,tableName);
    }

    @Override
    public boolean add(RowTable row_table) {
        //try {
        //    checkFormat(row_table);
            row_table.put(primaryKey,new KeyPrimary(nextKey));
            super.add(row_table);
        //} catch (TableFormatProblemException e){System.out.println("FORMAT NOT MATCH!!!");return false;}
        nextKey++;
        return true;
    }
    public void checkFormat(RowTable row_table) throws TableFormatProblemException {
        //NEED TO ADD A PART FOR NULL DATA
        if ((infoDatatype.size()-1)==row_table.size()){
            //if (infoDatatype.equals(row_table.getColumnsName)) { return; }
        } throw new TableFormatProblemException();
    }



    public void setForeignKeys(HashMap<String, String> foreignKeys) {
        this.foreignKeys = foreignKeys;
    }


    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
    
    public String getColumnsType(String nameCol) { return infoDatatype.get(nameCol); }
    public String getKeyName() { return primaryKey; }
    public String getName() { return tableName; }
    public int getNextKey() { return nextKey; }
    @Override
    public ExecutionTree getLeft() { return null; }
    @Override
    public ExecutionTree getRight() { return null; }



	@Override
	public void setLeft(ExecutionTree pop) {
		System.out.println("WRONG with "+pop);
	}



	@Override
	public void setRight(ExecutionTree pop) {
		System.out.println("WRONG with "+pop);
	}

    @Override
    public String getFormulaRA() {
        return tableName;
    }
}
