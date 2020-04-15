package mainStructures.nodeCommand;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;

public interface ExecutionTree {

    ExecutionTree getLeft();
    ExecutionTree getRight();
    void setLeft(ExecutionTree node);
    void setRight(ExecutionTree node);

    String getFormulaRA();

    <T> T accept(ParsingVisitor<T> visitor);

}
