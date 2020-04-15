package mainStructures.toolsModule.makeAnalysis;

import mainStructures.dataFramework.ItemRow;
import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.dataFramework.itemTypes.DataBit;
import mainStructures.dataFramework.itemTypes.DataNumber;
import mainStructures.dataFramework.itemTypes.DataText;
import mainStructures.dataFramework.itemTypes.KeyForeign;
import mainStructures.textCommands.nodesPart.ExecutionTree;
import mainStructures.toolsModule.makeAnalysis.comdAutomate.*;
import mainStructures.toolsModule.treeExcutable.ExecutiveVisitor;
import mainStructures.toolsModule.treeExcutable.TreeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class SyntaxHandling {


    HashMap<String, TableDatabase> myTables;


    String request;
    ArrayList<ExecutionTree> nodes = new ArrayList<>();

    
    StringTokenizer handling;

    public ArrayList<ExecutionTree> getNodes() {
        return nodes;
    }

    public SyntaxHandling(HashMap<String, TableDatabase> myTables, String request) {
        this.myTables = myTables;
        this.request = request;
        String convertS = convertSyntax(request);
//System.out.println(convertS);
        StringTokenizer handling = new StringTokenizer(convertS);
        this.handling=handling;
    }


    //This method needs to be improved a bit
    public TableDatabase makeNodes() {
        String temp;
        if (handling.hasMoreTokens()){
            temp = handling.nextToken();

            //////////////////////////////////////////////////////////////////////////////////////////////////SELECT
            if(temp.equals("SELECT")){
                ArrayList<String> selectInfo = new ArrayList<>();
                while (handling.hasMoreTokens()){
                    temp = handling.nextToken();
                    if (temp.equals("FROM")){break;}
                	if(temp.contains(".")) {
	                	temp = temp.substring(temp.indexOf(".")+1, temp.length());
                	}
                    selectInfo.add(temp);
                }
                BoxSELECT boxSelect = new BoxSELECT(selectInfo);
                nodes.add(boxSelect.makeNode());
//System.out.println("afsfasfsaf"+selectInfo);
     //       }
            
            
            if (temp.equals("FROM")) {
                temp = handling.nextToken();
                nodes.add(myTables.get(temp));
                temp = handling.nextToken();
                /*BoxFROM boxFrom = new BoxFROM(temp);
                nodes.add(boxFrom.makeNode());
                temp = handling.nextToken();*/
//System.out.println("FROM"+nodes);
            }
            
            
            while (temp.equals("INNER")){
//System.out.println("Hello JOIN");
            	temp = handling.nextToken();
            	BoxJOIN boxJoin = new BoxJOIN();
                String joinTable = handling.nextToken();
                
                //////////////////CONDITION???
                temp = handling.nextToken();
                if(temp.equals("ON")){
                	temp = handling.nextToken();
                	temp = temp.substring(temp.indexOf(".")+1, temp.length());
//System.out.println("VOICI CONDITION ON "+temp);
                    boxJoin.addChoiceON(temp);
                    temp = handling.nextToken();
                    temp = handling.nextToken();
                }
                nodes.add(boxJoin.makeNode());
                nodes.add(myTables.get(joinTable));
                temp = handling.nextToken();
//System.out.println("JOIN BOX" + boxJoin);
            }
            
            
            if (temp.equals("WHERE")){
                ArrayList<String> whereInfo = new ArrayList<>();
                ///////////////////En 3 parties
                while (handling.hasMoreTokens()){
                    temp = handling.nextToken();
                    if (!temp.equals("AND")){
                        whereInfo.add(temp);
                    }
                }
                BoxWHERE boxWhere = new BoxWHERE(whereInfo);
                nodes.add(1,boxWhere.makeNode());
//System.out.println("105!!!!!!!!!!!!!!!!"+nodes);
//System.out.println(nodes.get(nodes.size()-1).getClass().getName());
            }
            
            ExecutionTree root = TreeBuilder.buildTree(nodes);
System.out.println(root.getFormulaRA());
			ExecutiveVisitor sucess = new ExecutiveVisitor();
			TableDatabase resultT = root.accept(sucess);
//System.out.println("WE ARE THE CHAMPI "+resultT);
//	String[][] testT = resultT.toTable();
//System.out.println(testT.toString());
			return resultT;
            }


            //////////////////////////////////////////////////////////////////////////////////////////////////CREAT
            if(temp.equals("CREATE")){
                temp = handling.nextToken();
                String nameNewTable  = handling.nextToken();

                ArrayList<String> keyHT = new ArrayList<>();
                ArrayList<String> valueHT = new ArrayList<>();
                LinkedHashMap<String,String> infoDatatype = new LinkedHashMap<>();


                temp = handling.nextToken();
                int wish = 2;
//System.out.println(temp +"  "+ wish);
                    do { if(wish%2==0){
                        	keyHT.add(temp);
                    } else {
                    	if (temp.equals("AUTOINCREMENT")){
                    		valueHT.add("PRIMARY_KEY");
                            temp = handling.nextToken();
                            wish++;
                        }else if (temp.equals("LONG")){
                        	valueHT.add("FOREIGN_KEY");
                            temp = handling.nextToken();
                            wish++;
                        }
//System.out.println(temp +"  "+ wish);
						if(wish%2!=0) {
                    	  valueHT.add(temp);
						}else {
							keyHT.add(temp);
						}
                    }
                        wish++;
//System.out.println(temp +"  "+ wish);
                        temp = handling.nextToken();
                    }while (!temp.equals("PRIMARY"));

                for (int index=0 ; index<keyHT.size();index++) {
                	
                	
                    infoDatatype.put(keyHT.get(index) , valueHT.get(index));
                }
//System.out.println(keyHT +" " + valueHT+"????????????"+infoDatatype);
                TableDatabase yeahTable = new TableDatabase(nameNewTable,infoDatatype);
                
	                String [] title = new String[keyHT.size()];
	                keyHT.toArray(title);
	                yeahTable.setTitle(title);

                    while (!temp.equals("FOREIGN") && handling.hasMoreTokens()){ temp = handling.nextToken(); }
                        if(temp.equals("FOREIGN")){
                            HashMap<String,String> foreignKeys = new HashMap<>();
                            while (temp.equals("FOREIGN")) {
                                temp = handling.nextToken();
                                String nameFoKey = handling.nextToken();
//System.out.println("FOREIGN "+nameFoKey);
                                temp = handling.nextToken();
                                String nameTableF = handling.nextToken();
                                foreignKeys.put(nameFoKey, nameTableF);
                                temp = handling.nextToken();
                                if (handling.hasMoreTokens()) {
                                    temp = handling.nextToken();
                                }
                            }
                            yeahTable.setForeignKeys(foreignKeys);
//System.out.println(foreignKeys);
                        }
                myTables.put(nameNewTable,yeahTable);
                return yeahTable;
            }



            //////////////////////////////////////////////////////////////////////////////////////////////////INSERT
            if(temp.equals("INSERT")) {
                temp = handling.nextToken();
                String nameToTable = handling.nextToken();
                temp = handling.nextToken();
                ArrayList<String> toNameCol = new ArrayList<String>();
//System.out.println(temp);
                    while (!temp.equals("VALUES")){toNameCol.add(temp); temp = handling.nextToken();}
                ArrayList<String> newDataCol = new ArrayList<>();
                    while (handling.hasMoreTokens()){temp = handling.nextToken(); newDataCol.add(temp); }
                RowTable welcome = new RowTable();
                    for (int index=0 ; index<toNameCol.size() ; index++){
                    	
//System.out.println("begain " + toNameCol.get(index));
//System.out.println(nameToTable);
//System.out.println(newDataCol.get(index)+" end");
//System.out.println(myTables.get(nameToTable));
//System.out.println(myTables);
                    	
                        welcome.put(toNameCol.get(index),
                                makeItem(
                                    myTables.get(nameToTable)
                                            .getColumnsType(toNameCol.get(index)), newDataCol.get(index))
                        );

                    }
                myTables.get(nameToTable).add(welcome);
                return myTables.get(nameToTable);
            }
        }
		return null;
    }

    private ItemRow makeItem(String columnsType, String value) {
//System.out.println(columnsType +"!!!!"+ value);
        switch (columnsType){
            case "BIT": {
                DataBit result = new DataBit(value);
                return result;
            }
            case "TEXT": {
                DataText result = new DataText(value);
                return result;
            }
            case "NUMBER": {
                DataNumber result = new DataNumber(value);
                return result;
            }
            case "FOREIGN_KEY": {
                KeyForeign result = new KeyForeign(value);
                return result;
            }
        }
        DataText result = new DataText(value);
        return result;
    }






    //This method needs to be improved a lot
    public String convertSyntax (String originalCommand){
        String onlyWords = (originalCommand.toString().replaceFirst(";", "")).replaceAll(",", " ");
//System.out.println(onlyWords);
        String withoutAS = onlyWords.replaceAll(" AS ","AS").replaceAll("\\("," ").replaceAll("\\)"," ").replaceAll(","," ").replaceAll(";","").replaceAll("\"","");
        ArrayList<String> offAS = new ArrayList<>();
        StringTokenizer checkAS = new StringTokenizer(withoutAS);
        String temp = checkAS.nextToken();
        while (checkAS.hasMoreTokens()) {
            if(Pattern.matches(".*AS.*", temp)) {
                offAS.add(temp);
            }
            temp = checkAS.nextToken();
        }
        for (String mes : offAS) {
            StringTokenizer rep = new StringTokenizer(mes.replaceFirst("AS", " "));
            String tableName = rep.nextToken();
            String nickName = rep.nextToken();
            String offNickName = tableName + "AS" + nickName;
            withoutAS = (withoutAS.replace(nickName + ".", tableName + ".")).replaceAll(offNickName, tableName);
//            withoutAS =withoutAS.replaceAll("\\("," ").replaceAll("\\)"," ").replaceAll(","," ").replaceAll(";","").replaceAll("\"","");
        }
//System.out.println(withoutAS);
        return withoutAS;
    }

















        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void startAutomate (StringTokenizer handling){
        String head = handling.nextToken();
        switch (head) {
            case "SELECT": {
                BoxSELECT box = new BoxSELECT(nodes, handling);
                break;
            }
            case "CREAT": {
                BoxCREAT box = new BoxCREAT(nodes, handling);
                break;
            }
            case "INSERT": {
                BoxINSERT box = new BoxINSERT(nodes, handling);
                break;
            }
            case "UPDATE": {
                BoxUPDATE box = new BoxUPDATE(nodes, handling);
                break;
            }
        }
    }
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

/*
    private class BoxSELECT extends AutoBoxArchetype {
        public BoxSELECT(ArrayList<ExecutionTree> nodes, StringTokenizer remain) {
            super(nodes, remain);
        }

        public BoxSELECT(ArrayList<String> selectInfo) {
            super();
        }

        @Override
        public void runAutomate() {
        }

    }



 !!!!!!!!!!!!!!!!!!!*/


    /*
    StringTokenizer request;
    public SyntaxHandling(String request) {
        this.request = new StringTokenizer(request);
    }
    */


    /*
    if (now = SELECT)
        new BoxSELECT,
        while(now != FROM),
            BoxSELECT.add(now)
            then new BoxFROM
            while(now != WHERE && now != JOIN && now != ;)
                BoxJOIN.add(now)
                if (now = JOIN)
                    new BoxJOIN
                    ADD while(!= WHERE && != ;)
                if (now = WHERE)
                    new BoxWHERE
                    ADD while(!= ;)
     */


    /**
     * Use keywords to decider which loop to go in.
     * LIKE: if CREAT is in the Syntax / if SELECT is in the Syntax
     *
     * RULES: Only AND allowed space between the word.
     *
     *
     *
     *   1SELECT
     *  2FROM
     * 3JOIN
     *
     * 4WHERE
     *  5ORDERBY (ORDERBY | ORDER then BY)
     *
     *
     */



    // Il va peut-etre utiliser/creer les objet de textExecutable
}
