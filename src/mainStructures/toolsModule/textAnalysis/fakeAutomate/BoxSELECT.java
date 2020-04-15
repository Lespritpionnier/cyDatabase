package mainStructures.toolsModule.textAnalysis.fakeAutomate;

import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.ExecutionTree;

import java.util.ArrayList;

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
