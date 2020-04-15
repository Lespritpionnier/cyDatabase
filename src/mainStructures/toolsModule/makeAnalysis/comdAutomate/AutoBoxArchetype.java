package mainStructures.toolsModule.makeAnalysis.comdAutomate;

import java.util.ArrayList;
import java.util.StringTokenizer;

import mainStructures.textCommands.nodesPart.ExecutionTree;

public abstract class AutoBoxArchetype {
    private ArrayList<ExecutionTree> nodes;
    StringTokenizer remain;

    public AutoBoxArchetype(ArrayList<ExecutionTree> nodes, StringTokenizer remain) {
        this.nodes = nodes;
        this.remain = remain;
    }

    public void runAutomate() {}

    public void overAutomate() {
        System.out.println(toString());
    }

}
