package mainStructures.textCommands.nodesPart;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandProjectionSELECT extends CommandArchetypeNode {
    private ArrayList<String> dataWanted = new ArrayList<>();
    private HashMap<String,String> alias = new HashMap<>();
    private String[] orderBY = new String[2]; //Name of the column + ASC/DSC
    private boolean ifDISTINCT = false;

 



    //  I don't remember why I wrote those things:


	public ArrayList<String> getDataWanted() {
		return dataWanted;
	}


	public CommandProjectionSELECT(ArrayList<String> dataWanted) {
        super();
        this.dataWanted = dataWanted;
    }


	/**
     * Those METHODS below are made before, maybe WRONG or MOUCHE
     * DONT FORGET the situation of "SUM, AVG, MIN, MAX, COUNT"
     *                              (Only one syntax to stock)
     * @param ifDISTINCT
     */

    public void setDistinct(boolean ifDISTINCT) {
        this.ifDISTINCT = ifDISTINCT;
    }










/*
    public int getCOUNT (String columnName, Table_database table){
        int count = 0;
        //TO DO
        return count;
    }
    public double getSUM (String columnName, Table_database table){
        double sum = 0;
        //TO DO
        return sum;
    }
    public double getAVG (String columnName, Table_database table){
        double numerator = getSUM(columnName, table);
        int denominator = getCOUNT(columnName, table);
        //Need to be better in performance
        return numerator/denominator;
    }
    public DataArchetype getMAX (String columnName, Table_database table){
        //Need a confirmation of the returning type
    }
    public DataArchetype getMIN (String columnName, Table_database table){
        //Need a confirmation of the returning type (ALL ABOVE)
    }
*/

    @Override
    public String getFormulaRA() {
        return "Proj("+right.getFormulaRA()+")";
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
