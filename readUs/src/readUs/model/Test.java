package readUs.model;

import readUs.model.Collection.sortType;
import readUs.model.ReadingGoals.goalType;

public final class Test {
	public static void main(String[] args) {
		// Create a new instance of type Collection
		Collection	myLibrary = new Collection();
		
		// Create an empty array to storage the book awards
		String[] authorBook1 = {"Pittacus Lore"};
		String[] awardsBook1 = {""};

		String[] awardsMagazine = {""};
		String[] awardsComic = {""};
		
		String[] authorBook2 = {"Gabriel Garcia Marques"};
		String[] awardsBook2 = {"Nobel da Literatura 1982"};
		
		String[] writers = {"Kohei Horikoshi", "test"};
		String[] mainCharacters = {"Deku", "AllMight", "Todoroki", "Bakugou", "All4One"};
		String[] headline = {"Capitolo Primo"};
		
		// Add a new Book to the library
		myLibrary.addLiterature("Eu sou o número Quatro", "HarperTorch", "EUA", 2010,
				"Ingles", awardsBook1, 440, 0, "Ficcao Cientifica", authorBook1); 

		// Add a new magazine to the library
		myLibrary.addLiterature("Vogue", "Conde Nast", "Italia", 1965,
				"Italiano", awardsMagazine, 220, 50, "Moda", headline, "mensal", "01032017");
		
		// Add a new Comic
		myLibrary.addLiterature("Boku no Hero", "Viz", "Japao", 2014, "Japones", awardsComic, 20, 20, "Shounen", 
				writers, writers, writers, writers, writers, mainCharacters);
		
		// Add a new Book to the library
		myLibrary.addLiterature("Cem anos de solidao", "Record", "Colombia", 1967,
				"Espanhol", awardsBook2, 352, 100, "Romance", authorBook2); 
		System.out.println(myLibrary.toString());
		System.out.println("\n");
		
		// Changes library sorting 
		myLibrary.sortBooks(sortType.NUMBER_PAGES);
		System.out.printf(myLibrary.toString());
		System.out.println("\n");
		
		// Test Class readingGoals
		ReadingGoals myGoal = new ReadingGoals(goalType.PAGES, 80, 7);
		ReadingGoals myBoundedGoal = new ReadingGoals(goalType.BOOKS, 10, 1, "25052021");
		
		System.out.println(myGoal.toString());
		System.out.println(myBoundedGoal.toString());
	}

}