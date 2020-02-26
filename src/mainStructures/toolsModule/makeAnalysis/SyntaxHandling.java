package mainStructures.toolsModule.makeAnalysis;

import mainStructures.textExecutable.ExecutionTree;
import mainStructures.toolsModule.makeAnalysis.textBoxes.*;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class SyntaxHandling {

    String request;
    ArrayList<ExecutionTree> nodes;

    public SyntaxHandling(String request) {
        this.request = request;
        StringTokenizer handling = new StringTokenizer(convertSyntax(request));
        makeNodes(handling);
    }

    //This method needs to be improved a bit
    private void makeNodes(StringTokenizer handling) {
        String temp;
        while(handling.hasMoreTokens()){
            temp = handling.nextToken();
            if(temp.equals("SELECT")){
                ArrayList<String> selectInfo = new ArrayList<>();
                while (handling.hasMoreTokens()){
                    temp = handling.nextToken();
                    if (temp.equals("FROM")){break;}
                    selectInfo.add(temp);
                }
                BoxSELECT boxSelect = new BoxSELECT(selectInfo);
                nodes.add(boxSelect.makeNode());
            }
            if (temp.equals("FROM")) {
                temp = handling.nextToken();
                BoxFROM boxFrom = new BoxFROM(temp);
                nodes.add(boxFrom.makeNode());
                temp = handling.nextToken();
            }
            while (temp.equals("JOIN")){
                BoxJOIN boxJoin = new BoxJOIN(handling.nextToken());
                nodes.add(boxJoin.makeNode());
                temp = handling.nextToken();
                if(temp.equals("ON")){
                    boxJoin.setChoiceON(handling.nextToken());
                }
                nodes.add(boxJoin.makeNode());
                temp = handling.nextToken();
            }
            if (temp.equals("WHERE")){
                ArrayList<String> whereInfo = new ArrayList<>();
                while (handling.hasMoreTokens()){
                    temp = handling.nextToken();
                    whereInfo.add(temp);
                }
                BoxWHERE boxWhere = new BoxWHERE(whereInfo);
                nodes.add(boxWhere.makeNode());
            }
        }
    }


    //This method needs to be improved a lot
    public String convertSyntax (String originalCommand){
        String onlyWords = (originalCommand.toString().replaceFirst(";", "")).replaceAll(",", "");
        String withoutAS = onlyWords.replaceAll(" AS ","AS");
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
            withoutAS = (withoutAS.replace(nickName + ".", tableName + ".")
                        ).replaceAll(offNickName, tableName);
        }
        return withoutAS;
    }


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
