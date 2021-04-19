package readUs.controller;

import readUs.model.Book;
import readUs.model.Collection;
import readUs.model.Collection.sortType;
import readUs.model.Literature;

public class LibraryController {
	Collection myLibrary = new Collection();
	
	public String[] getAllBooksName() {
		String[] booksName = new String[myLibrary.getQntBooks()];
		Literature[] books = myLibrary.getBooks();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			booksName[i] = books[i].getName();
		}
		return booksName;
		
	}
	
	public Literature[] getAllItems() {
		Literature[] books = myLibrary.getBooks();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			books[i] = books[i];
		}
		return books;
	}
	
	public int getQntBooks() {
		return myLibrary.getQntBooks();
	}
	
	public void setSort(int index) {
		sortType sorting;
		switch(index) {
		case 0:
			sorting = sortType.NAME_A_Z;
			break;
		case 1:
			sorting = sortType.NAME_Z_A;
			break;
		case 2:
			sorting = sortType.FIRST_EDITION;
			break;
		case 3:
			sorting = sortType.NUMBER_PAGES;
			break;
		case 4:
			sorting = sortType.PROGRESS;
			break;
		default:
			sorting = sortType.NAME_A_Z;
		}
		
		myLibrary.sortBooks(sorting);
	}
	
	public void setSort(sortType sorting) {
		myLibrary.sortBooks(sorting);
	}
	
	public String[] splitStringArray(String data, String regex) {
		if(data == null) return null;
		else return data.split(regex);
	}
	
	public void addBook(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
			String[] author) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, author);
		
	}
	
	public void addMagazine(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] headline, String frequency, String coverDate) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, headline, frequency, coverDate);
		
		
	}
	
	public void addComic(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] colourist,
			String[] mainCharacters) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, writer, penciller, inker, letterer, 
								colourist, mainCharacters);
		
	}
	
	public boolean exists(String name) {
		String[] booksName = getAllBooksName();
		for(int idx = 0; idx < booksName.length; idx++) {
			if(booksName[idx].contentEquals(name))
				return true;
		}
		return false;
	}
	
	public int getItemIndex(String title) {
		return myLibrary.getBookIndex(title);
		
	}
	
	public Literature getItem(String title) {
		Literature[] books = getAllItems();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			if(title.contentEquals(books[i].getName())) {
				return books[i];
			}
		}
		return null;
	}

	public int getItemType(String title) {
		Literature book = getItem(title);
		switch(book.getType()) {
		case BOOK:
			return 0;
		case MAGAZINE:
			return 1;
		case COMIC:
			return 2;
		default:
			return 0;
		}
		
	}

	public void removeItem(String title) {
		myLibrary.removeBook(title);
	}
}
