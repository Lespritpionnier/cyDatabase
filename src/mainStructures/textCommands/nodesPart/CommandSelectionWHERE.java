package mainStructures.textCommands.nodesPart;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.ArrayList;

public class CommandSelectionWHERE extends CommandArchetypeNode {
    private ArrayList<String> preConditions =new ArrayList<>();

    public CommandSelectionWHERE(ArrayList<String> predicateConditions) {
        super();
        preConditions = predicateConditions;
    }

    
    
    
    
    
    
    
    
    
    
//    public String toString() {
//        return "\n VOICI WHERE!{Conditions:" + justForPre + '}' + "\n";
//    }
    
    public ArrayList<String> getPreConditions() {
		return preConditions;
	}

    @Override
    public String getFormulaRA() {
        return "Sel("+right.getFormulaRA()+")";
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
