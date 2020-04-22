package mainStructures.nodeCommand;
/**
 * This is the archetype of Node Command
 * 	It implements ExecutionTree to free the children classes
 */
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


