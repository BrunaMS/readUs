package readUs;

// Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;

public class Collection {

	private Literature[] books;
	private int qntBooks;
	private String typeSorting;
	private ReadingGoals[] goals;
	
	public Collection(){
		qntBooks = 0;
	}
	
	enum sortType {
		  NAME_A_Z,
		  NAME_Z_A,
		  FIRST_EDITION,
		  NUMBER_PAGES,
		  PROGRESS
	}
	
	public Literature[] getbooks() {
		return books;
	}
	
	public int getQntBooks() {
		return qntBooks;
	}

	public String getTypeSorting() {
		return typeSorting;
	}
	
	public void setBooks(Literature[] newbooks) {
		books = newbooks;
	}
	
	public void setQntBooks(int newqntBooks) {
		qntBooks = newqntBooks;
	}

	public void setTypeSorting(String sorting) {
		typeSorting = sorting;
	}

	// Book
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
			String author) {
		Literature newBook = new Book();
		books[qntBooks] = newBook;
		qntBooks++;
	}
	
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre) {
		Literature newBook = new Magazine();
		books[qntBooks] = newBook;
		qntBooks++;
	}
	
	// Comic
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] colorist,
			String[] mainCharacters) {
		Literature newBook = new Comic();
		books[qntBooks] = newBook;
		qntBooks++;
	}
	
	// TODO (articles)
//	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
//			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
//			int numberPages, String genre) {
//		Literature newBook = new Article();
//		books[qntBooks] = newBook;
//		qntBooks++;
//	}
	
	public void removeBook(String removedBookName) {
		int idx = getBookIndex(books, removedBookName);
		books[idx] = books[qntBooks - 1];
		books[qntBooks - 1] = null;
		qntBooks--;
	}
	
	
	private int getBookIndex(Literature[] list, String item){
		for(int i = 0; i < list.length; i++) {
			if(list[i].getName().contentEquals(item)) {
				return i;
			}
				
		}
		return -1;
	}

	public void sortbooks(sortType sort){
		switch(sort) {
			case NAME_A_Z:
				orderLibraryAZ();
				break;
			case NAME_Z_A:
				orderLibraryZA();
				break;
			case FIRST_EDITION:
				orderLibraryYear();
				break;
			case NUMBER_PAGES:
				orderLibraryPages();
				break;
			case PROGRESS:
				orderLibraryProgress();
				break;
		}
	}

	private void orderLibraryAZ(){
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getName().compareTo(books[j].getName()) > 0){ //  > 0: Book[i] > Book[j]
                	Literature temp = books[i];						 // == 0: Book[i] == Book[j]
                    books[i] = books[j];						 //  < 0: Book[i] < Book[j]
                    books[j] = temp;
                }
            }
        }
	}
	
	
	private void orderLibraryZA() {
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getName().compareTo(books[j].getName()) > 0){ //  > 0: Book[i]  > Book[j]
                	Literature temp = books[i];						 // == 0: Book[i] == Book[j]
                    books[i] = books[j];						 //  < 0: Book[i]  < Book[j]
                    books[j] = temp;
                }
            }
        }
	}
	private void orderLibraryYear() {
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getFirstEdition() > books[j].getFirstEdition()){
                	Literature temp = books[i];						 
                    books[i] = books[j];						 
                    books[j] = temp;
                }
            }
        }
	}
	
	private void orderLibraryPages() {
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getNumberPages() < books[j].getNumberPages()){
                	Literature temp = books[i];						 
                    books[i] = books[j];						 
                    books[j] = temp;
                }
            }
        }
	}
	
	private void orderLibraryProgress() {
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getProgress() < books[j].getProgress()){
                	Literature temp = books[i];						 
                    books[i] = books[j];						 
                    books[j] = temp;
                }
            }
        }
	}

	public String toString() {
		JSONObject libraryJson = new JSONObject();
		libraryJson.put("books", books.toString());
		libraryJson.put("qntBooks", qntBooks);
		libraryJson.put("typeSorting", typeSorting);
		
		return libraryJson.toString();
		
	}
	
	public static void main(String[] args){
		
	}
}
