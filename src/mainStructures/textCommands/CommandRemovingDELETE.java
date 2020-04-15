package mainStructures.textCommands;

import mainStructures.textCommands.nodesPart.ExecutionTree;
import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

public class CommandRemovingDELETE implements ExecutionTree {
    @Override
    public ExecutionTree getLeft() {
        return null;
    }

    @Override
    public ExecutionTree getRight() {
        return null;
    }

    @Override
    public <T> T accept(ParsingVisitor<T> visitor) {
        return null;
    }

	@Override
	public void setLeft(ExecutionTree node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRight(ExecutionTree node) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public String getFormulaRA() {
        return null;
    }
}
