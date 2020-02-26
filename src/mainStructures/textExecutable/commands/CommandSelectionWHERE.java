package mainStructures.textExecutable.commands;

import mainStructures.textExecutable.ExecutionTree;
import mainStructures.toolsModule.pairVisitor.TreeVisitor;

import java.util.ArrayList;

public class CommandSelectionWHERE extends CommandArchetype implements ExecutionTree {
    private ArrayList<Integer> markedRows_Indexes;
    private ArrayList<PredicateCondition> predicateConditions = new ArrayList<>();
    private ArrayList<String> justForPre =new ArrayList<>();

    public CommandSelectionWHERE(ArrayList<String> predicateConditions) {
        super();
        //loop to add predicateConditions
        justForPre = predicateConditions;
    }

    public void addCondition (String condition){
        PredicateCondition pC = new PredicateCondition(condition);
        predicateConditions.add(pC);
    }

    @Override
    public <T> T accept(TreeVisitor<T> visitor) {
        return null;
    }
}
