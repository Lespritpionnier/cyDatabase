package mainStructures.nodeCommand;

import mainStructures.toolsModule.treeExcutable.ParsingVisitor;
/**
 * This is the archetype-interface of Execution Tree
 */
public interface ExecutionTree {

    ExecutionTree getLeft();
    ExecutionTree getRight();
    void setLeft(ExecutionTree node);
    void setRight(ExecutionTree node);

    String getFormulaRA();

    <T> T accept(ParsingVisitor<T> visitor);

}
