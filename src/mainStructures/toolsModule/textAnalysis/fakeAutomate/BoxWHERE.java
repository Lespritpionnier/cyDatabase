package mainStructures.toolsModule.textAnalysis.fakeAutomate;

import mainStructures.nodeCommand.CommandSelectionWHERE;
import mainStructures.nodeCommand.ExecutionTree;

import java.util.ArrayList;

public class BoxWHERE {
    ArrayList<String> conditions = new ArrayList<>();

    public BoxWHERE(ArrayList<String> conditions) {
        this.conditions = conditions;
    }

    public ExecutionTree makeNode() {
        return new CommandSelectionWHERE(conditions);
    }
}
