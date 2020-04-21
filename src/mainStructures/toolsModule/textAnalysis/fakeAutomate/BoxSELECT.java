package mainStructures.toolsModule.textAnalysis.fakeAutomate;

import mainStructures.nodeCommand.CommandProjectionSELECT;
import mainStructures.nodeCommand.ExecutionTree;

import java.util.ArrayList;
/**
 * It arrange the information for CommandProjectionSELECT
 */
public class BoxSELECT {


    ArrayList<String> textAllocated = new ArrayList<>();

    public BoxSELECT(ArrayList<String> textAllocated) {
        this.textAllocated = textAllocated;
    }
    public ExecutionTree makeNode() {
        return new CommandProjectionSELECT(textAllocated);
    }
    
}
