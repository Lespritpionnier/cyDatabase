package mainStructures.dataFramework;

import mainStructures.textCommands.nodesPart.CommandProjectionSELECT;

public interface ItemRow {

	String getData();
	int compareTo(String s);







/*
    public Item_row(String value) {
        SetValue(value);
    }
    protected abstract void SetValue(String value);

 */


    /**
     * ATTENTION: Use AddData() with checkConstraint()!
     */
    //MAYBE NO NEED OF private String name;
    //LATER   private Constraint constraint;


    /*
    public void setConstraint(String constraint) {
        this.constraint.setConstraint(constraint);
    }

    public String getConstraint() { return constraint.toString(); }


    public Item_row(String name) {
        this.name = name;
        constraint = new Constraint("NULL");
    }
    public Item_row(String name, String constraint) {
        this.name = name;
        this.constraint = new Constraint(constraint);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() { return name; }
 */
}
