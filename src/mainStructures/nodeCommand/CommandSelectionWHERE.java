package mainStructures.nodeCommand;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.ArrayList;
/**
 * A node of execution tree, WHERE
 *	who is a part of the visitor pattern 
 */
public class CommandSelectionWHERE extends CommandArchetypeNode {
    private ArrayList<String> preConditions =new ArrayList<>();

    public CommandSelectionWHERE(ArrayList<String> predicateConditions) {
        super();
        preConditions = predicateConditions;
    }
    
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
