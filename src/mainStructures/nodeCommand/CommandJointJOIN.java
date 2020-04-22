package mainStructures.nodeCommand;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

/**
 * A node of execution tree, JOIN
 *	who is a part of the visitor pattern 
 */
public class CommandJointJOIN extends CommandArchetypeNode {
    String condition;

    public CommandJointJOIN() {
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
		return condition;
	}

    @Override
    public String getFormulaRA() {
        return "Join("+left.getFormulaRA()+","+right.getFormulaRA()+")";
    }

    @Override
	public <T> T accept(ParsingVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
