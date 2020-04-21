package mainStructures.toolsModule.textAnalysis;

import mainStructures.dataFramework.ItemRow;
import mainStructures.dataFramework.RowTable;
import mainStructures.dataFramework.TableArchetype;
import mainStructures.dataFramework.TableDatabase;
import mainStructures.dataFramework.itemTypes.*;
import mainStructures.nodeCommand.ExecutionTree;
import mainStructures.toolsModule.dealDatagram.WhereDropper;
import mainStructures.toolsModule.dealDatagram.WhereSetter;
import mainStructures.toolsModule.textAnalysis.fakeAutomate.*;
import mainStructures.toolsModule.treeExcutable.ExecutiveVisitor;
import mainStructures.toolsModule.treeExcutable.TreeBuilder;

import java.util.*;
import java.util.regex.Pattern;
/**
 * The main part of analyze the request SQL
 * 	It can also mark some information of command
 * 		like relational algebra formal of SELECT
 */
public class SyntaxHandling {
    //For text label in GUI
    String message;
    public String getMessage() { return message; }

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
        StringTokenizer handling = new StringTokenizer(convertS);
        this.handling=handling;
    }


    public TableArchetype makeNodes() {
        String temp;
        if (handling.hasMoreTokens()){
            temp = handling.nextToken();
            
            if(temp.equals("SELECT")){
                return doSELECT(temp);
            }
            if(temp.equals("CREATE")){
                return doCREATE();
            }
            if(temp.equals("INSERT")) {
                return doINSERT();
            }
            if(temp.equals("DELETE")) {
                return doDELETE();
            }
            if(temp.equals("UPDATE")) {
                return doUPDATE();
            }
        }
		return null;
    }

    private TableArchetype doUPDATE() {
        String temp;
        String but = handling.nextToken();
        message = "UPDATE: "+but;
        temp = handling.nextToken();
        ArrayList<String> setInfo = new ArrayList<>();
        if (temp.equals("SET")){
        	temp = handling.nextToken();
            while (!temp.equals("WHERE")){
                    setInfo.add(temp);
                    temp = handling.nextToken();
            }
        }
        ArrayList<String> whereInfo = new ArrayList<>();
        if (temp.equals("WHERE")){
            while (handling.hasMoreTokens()){
                temp = handling.nextToken();
                if (!temp.equals("AND")){
                    whereInfo.add(temp);
                }
            }
        }
        System.out.println("BUT "+ but);
        return WhereSetter.doWork(myTables.get(but),setInfo,whereInfo);
    }

    private TableArchetype doDELETE() {
        String temp;
        temp = handling.nextToken();
        temp = handling.nextToken();
        TableDatabase aim = myTables.get(temp);
        message = "DELETE: "+aim;
        ArrayList<String> whereInfo = new ArrayList<>();        
        temp = handling.nextToken();
        if (temp.equals("WHERE")){
            while (handling.hasMoreTokens()){
                temp = handling.nextToken();
                if (!temp.equals("AND")){
                    whereInfo.add(temp);
                }
 System.out.println(whereInfo);
            }
        }
        return WhereDropper.goWork(whereInfo,aim);
    }

    private TableArchetype doINSERT() {
        String temp;
        temp = handling.nextToken();
        String nameToTable = handling.nextToken();
        message = "INSERT INTO: "+nameToTable;
        temp = handling.nextToken();
        ArrayList<String> toNameCol = new ArrayList<String>();
        while (!temp.equals("VALUES")){toNameCol.add(temp); temp = handling.nextToken();}
        ArrayList<String> newDataCol = new ArrayList<>();
        while (handling.hasMoreTokens()){temp = handling.nextToken(); newDataCol.add(temp); }
        RowTable welcome = new RowTable();
        for (int index=0 ; index<toNameCol.size() ; index++){

            welcome.put(toNameCol.get(index),
                    makeItem(
                        myTables.get(nameToTable)
                                .getColumnsType(toNameCol.get(index)), newDataCol.get(index))
            );

        }
        myTables.get(nameToTable).add(welcome);
        return myTables.get(nameToTable);
    }

    private TableArchetype doCREATE() {
        String temp;
        temp = handling.nextToken();
        String nameNewTable  = handling.nextToken();
        message = "CREAT: "+nameNewTable;
        ArrayList<String> keyHT = new ArrayList<>();
        ArrayList<String> valueHT = new ArrayList<>();
        LinkedHashMap<String,String> infoDatatype = new LinkedHashMap<>();

        temp = handling.nextToken();
        int wish = 2;
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
            if(wish%2!=0) {
              valueHT.add(temp);
            }else {
                keyHT.add(temp);
            }
        }
            wish++;
            temp = handling.nextToken();
        }while (!temp.equals("PRIMARY"));

        for (int index=0 ; index<keyHT.size();index++) {


            infoDatatype.put(keyHT.get(index) , valueHT.get(index));
        }
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
                temp = handling.nextToken();
                String nameTableF = handling.nextToken();
                foreignKeys.put(nameFoKey, nameTableF);
                temp = handling.nextToken();
                if (handling.hasMoreTokens()) {
                    temp = handling.nextToken();
                }
            }
            yeahTable.setForeignKeys(foreignKeys);
        }
        myTables.put(nameNewTable,yeahTable);
        return yeahTable;
    }



    private TableArchetype doSELECT(String temp) {
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


        if (temp.equals("FROM")) {
            temp = handling.nextToken();
            nodes.add(myTables.get(temp));
        }

        if(handling.hasMoreElements()) {
        temp = handling.nextToken();
        while (temp.equals("INNER")){
            temp = handling.nextToken();
            BoxJOIN boxJoin = new BoxJOIN();
            String joinTable = handling.nextToken();

            temp = handling.nextToken();
            if(temp.equals("ON")){
                temp = handling.nextToken();
                temp = temp.substring(temp.indexOf(".")+1, temp.length());
                boxJoin.addChoiceON(temp);
                temp = handling.nextToken();
                temp = handling.nextToken();
            }
            nodes.add(boxJoin.makeNode());
            nodes.add(myTables.get(joinTable));
        }
        }
       
		if(handling.hasMoreTokens()) {
			temp = handling.nextToken();
	        if (temp.equals("WHERE")){
	            ArrayList<String> whereInfo = new ArrayList<>();
	            while (handling.hasMoreTokens()){
	                temp = handling.nextToken();
	                if (!temp.equals("AND")){
	                    whereInfo.add(temp);
	                }
	            }
	            BoxWHERE boxWhere = new BoxWHERE(whereInfo);
	            nodes.add(1,boxWhere.makeNode());
	        }
		}
        ExecutionTree root = TreeBuilder.buildTree(nodes);
        message = root.getFormulaRA();
        ExecutiveVisitor sucess = new ExecutiveVisitor();
        TableArchetype resultT = root.accept(sucess);
        return resultT;
    }

    private ItemRow makeItem(String columnsType, String value) {
        switch (columnsType){
            case "BIT": {
                return new DataBit(value);
            }
            case "TEXT": {
                return new DataText(value);
            }
            case "NUMBER": {
                return new DataNumber(value);
            }
            case "DATE": {
                return new DataDate(value);
            }
            case "FOREIGN_KEY": {
                return new KeyForeign(value);
            }
        }
        return new DataText(value);
    }


    public String convertSyntax (String originalCommand){
        String onlyWords = (originalCommand.toString().replaceFirst(";", "")).replaceAll(",", " ");
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
        	}
        return withoutAS;
    }
}
