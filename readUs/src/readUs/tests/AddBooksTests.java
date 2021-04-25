package readUs.tests;

import static org.junit.jupiter.api.Assertions.*;
import readUs.controller.LibraryController;
import readUs.model.Collection.sortType;

import org.junit.jupiter.api.Test;

class AddBooksTests {
	LibraryController libTest = new LibraryController();
	
   
	
	@Test
	void testExistsBooks() {
		String[] author = {""};
		String[] awards = {""};
		libTest.addBook("Pequeno Principe", "Globo", "Franca",0,"Frances",awards, 0,0,"",author);
		assertTrue(libTest.exists("Pequeno Principe"));
		assertFalse(libTest.exists("PequenoPrincipe"));
	}

	@Test 
	void testGetQntBooks() {
		String[] awards = {""};
		// Array vazio para testar
		String[] author = {""};
		libTest.addBook("Pequeno Principe", "Globo", "Franca",0,"Frances",awards, 0,0,"",author);
		libTest.addComic("Batman: o cavaleiro das trevas", "DC", "EUA",0,"Ingles",awards, 0,0,"Detetive",author,author, author, author,author,author);
		assertEquals(2,libTest.getQntBooks());		
	}
	@Test
	void testSetSort() {
		String[] awards = {""};
		// Array vazio para testar
		String[] author = {""};
		libTest.addBook("Pequeno Principe", "Globo", "Franca",1945,"Frances",awards, 77,25,"",author);
		libTest.addComic("Batman: o cavaleiro das trevas", "DC", "EUA",1930,"Ingles",awards, 10,5,"Detetive",author,author, author, author,author,author);
		libTest.addMagazine("Vogue", "Conde Nast", "EUA",1960,"Ingles",awards, 42,7,"Fashion",author,"", "");
		assertEquals(2,libTest.getItemIndex("Vogue"));
		
		libTest.setSort(sortType.NAME_A_Z);
		assertEquals(0,libTest.getItemIndex("Batman: o cavaleiro das trevas"));
		assertEquals(1,libTest.getItemIndex("Pequeno Principe"));
		assertEquals(2,libTest.getItemIndex("Vogue"));
		
		libTest.setSort(sortType.NAME_Z_A);
		assertEquals(2,libTest.getItemIndex("Batman: o cavaleiro das trevas"));
		assertEquals(1,libTest.getItemIndex("Pequeno Principe"));
		assertEquals(0,libTest.getItemIndex("Vogue"));
		
		libTest.setSort(sortType.NUMBER_PAGES);
		assertEquals(2,libTest.getItemIndex("Batman: o cavaleiro das trevas"));
		assertEquals(0,libTest.getItemIndex("Pequeno Principe"));
		assertEquals(1,libTest.getItemIndex("Vogue"));
		
		libTest.setSort(sortType.FIRST_EDITION);
		assertEquals(0,libTest.getItemIndex("Batman: o cavaleiro das trevas"));
		assertEquals(1,libTest.getItemIndex("Pequeno Principe"));
		assertEquals(2,libTest.getItemIndex("Vogue"));
		
		libTest.setSort(sortType.PROGRESS);
		assertEquals(0,libTest.getItemIndex("Batman: o cavaleiro das trevas"));
		assertEquals(1,libTest.getItemIndex("Pequeno Principe"));
		assertEquals(2,libTest.getItemIndex("Vogue"));
	}
	
	@Test
	void testRemoveItem() {
		// Array vazio para testar
		String[] awards = {""};
		String[] author = {""};
		libTest.addBook("Pequeno Principe", "Globo", "Franca",1945,"Frances",awards, 77,25,"",author);
		libTest.addComic("Batman: o cavaleiro das trevas", "DC", "EUA",1930,"Ingles",awards, 10,5,"Detetive",author,author, author, author,author,author);
		libTest.addMagazine("Vogue", "Conde Nast", "EUA",1960,"Ingles",awards, 42,7,"Fashion",author,"", "");
		libTest.removeItem("Vogue");
		assertFalse(libTest.exists("Vogue"));
		assertTrue(libTest.exists("Pequeno Principe"));
		assertTrue(libTest.exists("Batman: o cavaleiro das trevas"));
		
		
		
		
		
		
		
		
	}
	
	
}
