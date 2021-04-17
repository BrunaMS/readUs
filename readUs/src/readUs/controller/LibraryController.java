package readUs.controller;

import readUs.model.Collection;
import readUs.model.Collection.sortType;
import readUs.model.Literature;

public class LibraryController {
	Collection myLibrary = new Collection();
	
	public void addBook(){
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
		
	}
	
	public String[] getAllBooksName() {
		String[] booksName = new String[myLibrary.getQntBooks()];
		Literature[] books = myLibrary.getBooks();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			booksName[i] = books[i].getName();
		}
		return booksName;
		
	}
	
	public int getQntBooks() {
		return myLibrary.getQntBooks();
	}
	
	public void setSort(int index) {
		sortType sorting;
		switch(index) {
		case 0:
			System.out.println("NAME_A_Z");
			sorting = sortType.NAME_A_Z;
			break;
		case 1:
			System.out.println("NAME_Z_A");
			sorting = sortType.NAME_Z_A;
			break;
		case 2:
			System.out.println("FIRST_EDITION");
			sorting = sortType.FIRST_EDITION;
			break;
		case 3:
			System.out.println("NUMBER_PAGES");
			sorting = sortType.NUMBER_PAGES;
			break;
		case 4:
			System.out.println("PROGRESS");
			sorting = sortType.PROGRESS;
			break;
		default:
			System.out.println("default");
			sorting = sortType.NAME_A_Z;
		}
		
		myLibrary.sortBooks(sorting);
	}
	
	

}
