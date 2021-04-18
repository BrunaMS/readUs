package readUs.controller;

import readUs.model.ReadingGoals;
import readUs.model.ReadingGoals.goalType;

public class ReadingGoalsController {
	private int maxGoals;
	private int numbGoals;
	private ReadingGoals userGoals[];
	
	public ReadingGoalsController() {
		maxGoals = 100;
		numbGoals = 0;
	}
	
	public boolean addGoal(goalType typeGoal, float desiredNumber, float concludedNumber){
		ReadingGoals newGoal;
		if (numbGoals>=maxGoals){
			return false;
		}
		newGoal = new ReadingGoals(typeGoal,desiredNumber,concludedNumber);
		userGoals[numbGoals] = newGoal;
		numbGoals = numbGoals + 1;	
		return true;
		
	}
	//userGoals.setTypeGoal();

}
