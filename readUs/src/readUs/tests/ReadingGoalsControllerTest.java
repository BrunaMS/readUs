package readUs.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import readUs.controller.*;
import readUs.model.ReadingGoals.goalType;

import org.junit.jupiter.api.Test;

class ReadingGoalsControllerTest {

	ReadingGoalsController goalsTest =new ReadingGoalsController();
	
	
	@Test
	void testGetNumbGoals() {
		goalsTest.addGoal(goalType.BOOKS, 20, 1);
		goalsTest.addGoal(goalType.PAGES, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1,"20012001","19012001");
		assertEquals(4, goalsTest.getNumbGoals());
		
		
	}
	
	@Test
	void testRemoveGoal() {
		goalsTest.addGoal(goalType.BOOKS, 20, 1);
		goalsTest.addGoal(goalType.PAGES, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1,"20012001","19012001");
		assertEquals(4, goalsTest.getNumbGoals());
		goalsTest.removeGoal(3);
		assertEquals(3, goalsTest.getNumbGoals());
		goalsTest.removeGoal(1);
		assertEquals(2, goalsTest.getNumbGoals());
		
		
	}

}
