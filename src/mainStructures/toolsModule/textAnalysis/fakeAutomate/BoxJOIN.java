package mainStructures.toolsModule.textAnalysis.fakeAutomate;

import mainStructures.nodeCommand.CommandJointJOIN;
/**
 * It arrange the information for CommandJointJOIN
 */
public class BoxJOIN{
    private String choiceON ;

    public BoxJOIN() {}

	public void addChoiceON(String choice) {
        choiceON=choice;
    }

    public CommandJointJOIN makeNode() {
        CommandJointJOIN join = new CommandJointJOIN();
        join.setCondition(choiceON);
        return join;
    }

	@Override
	public String toString() {
		return choiceON.toString();
	}
}
