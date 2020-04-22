package mainStructures.dataFramework;

import mainStructures.dataFramework.itemTypes.KeyPrimary;
import mainStructures.nodeCommand.ExecutionTree;
import mainStructures.toolsModule.dealDatagram.ZonedData;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This is the class of Table of this SGBD!
 * It is in fact an ArrayList of RowTable
 * 	and it also can be a part of execution tree
 */

public class TableDatabase extends TableArchetype implements ExecutionTree {
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String,String> infoDatatype;
    private int nextKey; 


    public TableDatabase(String tableName, LinkedHashMap<String,String> infoDatatype) {
       this.tableName=tableName;
       this.infoDatatype = infoDatatype;
       nextKey=1; 
       try{	for(String key: infoDatatype.keySet()){
	           if(infoDatatype.get(key).equals("PRIMARY_KEY")){ primaryKey=key; }
	       }
		}catch (NullPointerException e) {
			System.err.println("Table:\""+ tableName +"\" is " + e.getMessage());
		}
    }
    public TableDatabase() {}


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
        return tableName;
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
    
    public String getColumnsType(String nameCol) { return infoDatatype.get(nameCol); }

    public int getNextKey() { return nextKey; }

}
