package mainStructures.dataFramework;

import mainStructures.dataFramework.itemTypes.KeyPrimary;
import mainStructures.nodeCommand.ExecutionTree;
import mainStructures.toolsModule.dealDatagram.ZonedData;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class TableDatabase extends TableArchetype implements ExecutionTree {
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

    //Think about REMOVE()

    public ZonedData toVirtual () {
    	ZonedData virtual = new ZonedData(title,tableName);
    	virtual.addAll(this);
    	return virtual;
    }

    @Override
    public boolean add(RowTable rowTable) {
        //try {
        //    checkFormat(row_table);
            rowTable.put(primaryKey,new KeyPrimary(nextKey++));
            super.add(rowTable);
        //} catch (TableFormatProblemException e){System.out.println("FORMAT NOT MATCH!!!");return false;}
        return true;
    }
/*
    public void checkFormat(RowTable row_table) throws TableFormatProblemException {
        //NEED TO ADD A PART FOR NULL DATA
        if ((infoDatatype.size()-1)==row_table.size()){
            //if (infoDatatype.equals(row_table.getColumnsName)) { return; }
        } throw new TableFormatProblemException();
    }
*/


    public void setForeignKeys(HashMap<String, String> foreignKeys) {
        this.foreignKeys = foreignKeys;
    }


    @Override
    public ExecutionTree getLeft() {
        return null;
    }

    @Override
    public ExecutionTree getRight() {
        return null;
    }

    @Override
    public void setLeft(ExecutionTree node) {

    }

    @Override
    public void setRight(ExecutionTree node) {

    }

    @Override
    public String getFormulaRA() {
        return null;
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
    
    public String getColumnsType(String nameCol) { return infoDatatype.get(nameCol); }
    public String getKeyName() { return primaryKey; }

    public int getNextKey() { return nextKey; }

}
