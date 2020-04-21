package mainStructures.nodeCommand;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A node of execution tree, SELECT
 *	who is a part of the visitor pattern 
 */
public class CommandProjectionSELECT extends CommandArchetypeNode {
    private ArrayList<String> dataWanted = new ArrayList<>();
    
    public ArrayList<String> getDataWanted() {
		return dataWanted;
	}

	public CommandProjectionSELECT(ArrayList<String> dataWanted) {
        super();
        this.dataWanted = dataWanted;
    }

    @Override
    public String getFormulaRA() {
        return "Proj("+right.getFormulaRA()+")";
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
