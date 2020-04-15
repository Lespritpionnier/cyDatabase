package mainStructures.dataFramework.itemTypes;

public class Constraint {
    private String constraint;

    public Constraint(String constraint) {
        this.constraint = constraint;
    }


    public boolean checkConstraint() {
        return false;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

}
