package mainStructures.textCommands.nodesPart;

public abstract class CommandArchetypeNode implements ExecutionTree{
    protected ExecutionTree left;
    protected ExecutionTree right;

    public CommandArchetypeNode() {
        left = null;
        right = null;
    }

    public void setLeft(ExecutionTree left) {
        this.left = left;
    }
    public void setRight(ExecutionTree right) {
        this.right = right;
    }
    public ExecutionTree getLeft() {
        return left;
    }
    public ExecutionTree getRight() {
        return right;
    }

}


