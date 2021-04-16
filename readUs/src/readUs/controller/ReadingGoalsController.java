package readUs.controller;

import readUs.model.ReadingGoals;
import readUs.model.ReadingGoals.goalType;

public class ReadingGoalsController {
	ReadingGoals userGoals[];
	int maxGoals=100;
	int numbGoals=0;
	
	public boolean addGoal(goalType typeGoal, float desiredNumber, float concludedNumber){
		if (numbGoals>=maxGoals){
			return false;
		}
		userGoals[numbGoals]=new ReadingGoals(typeGoal,desiredNumber,concludedNumber);
		numbGoals=numbGoals+1;	
		return true;
		
	}
	//userGoals.setTypeGoal();

}
