package mainStructures.toolsModule.makeAnalysis.comdAutomate;

import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;
import mainStructures.textCommands.nodesPart.ExecutionTree;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class BoxSELECT /*extends AutoBoxArchetype*/ {


    //
    ArrayList<String> textAllocated = new ArrayList<>();

    public BoxSELECT(ArrayList<String> textAllocated) {
        this.textAllocated = textAllocated;
    }
    public ExecutionTree makeNode() {
        return new CommandProjectionSELECT(textAllocated);
    }
    //











    /*
    public BoxSELECT(ArrayList<ExecutionTree> nodes, StringTokenizer remain) {
        super(nodes, remain);

    }
    @Override
    public void runAutomate() {
    }

     */

}
