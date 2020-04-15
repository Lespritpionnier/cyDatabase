package mainStructures.toolsModule.makeAnalysis.comdAutomate;

import mainStructures.textCommands.nodesPart.CommandSelectionWHERE;
import mainStructures.textCommands.nodesPart.ExecutionTree;

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
