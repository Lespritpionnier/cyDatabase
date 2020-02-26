package mainStructures.toolsModule.makeAnalysis.textBoxes;

import mainStructures.textExecutable.ExecutionTree;
import mainStructures.textExecutable.commands.CommandProjectionSELECT;

import java.util.ArrayList;

public class BoxSELECT implements BoxArchetype {
    ArrayList<String> textAllocated = new ArrayList<>();
    public BoxSELECT(ArrayList<String> textAllocated) {
        this.textAllocated = textAllocated;
    }

    @Override
    public ExecutionTree makeNode() {
        return new CommandProjectionSELECT(textAllocated);
    }
}
