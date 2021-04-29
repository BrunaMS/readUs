package readUs.tests;

import static org.junit.jupiter.api.Assertions.*;
import readUs.controller.*;
import readUs.model.ReadingGoals.goalType;

import org.junit.jupiter.api.Test;

/**
 * @author Bruna Medeiros e Beatriz Carolina
 * @version 1.0 (Abr 2021)
 * Verifica a funcionalidade de métodos da classe ReadingGoalsController, o que
 * resulta no uso e teste da classe ReadingGoals, do pacote controller.
 */
class ReadingGoalsControllerTest {
	ReadingGoalsController goalsTest = new ReadingGoalsController();
	
	/**
	 * Verifica se o número de metas retornado pelo método
	 * equivale ao número real de metas.
	 */
	@Test
	void testGetNumbGoals() {
		goalsTest.addGoal(goalType.BOOKS, 20, 1);
		goalsTest.addGoal(goalType.PAGES, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1);
		goalsTest.addGoal(goalType.CHAPTERS, 20, 1,"20012001","19012001");
		assertEquals(4, goalsTest.getNumbGoals());
	}
	
	/**
	 * Verifica método de remoção de metas.
	 * Para isso, adiciona-se 4 metas e remove-se 2 delas e verificando se o item 
	 * foi excluído com sucesso sem afetar os demais.
	 */
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
