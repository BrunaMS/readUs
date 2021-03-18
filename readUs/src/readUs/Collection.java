package readUs;

// Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;

public class Collection {

	private Book[] books;
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
	
	public Book[] getbooks() {
		return books;
	}
	
	public int getqntBooks() {
		return qntBooks;
	}

	public String getTypeSorting() {
		return typeSorting;
	}
	
	public void setbooks(Book[] newbooks) {
		books = newbooks;
	}
	
	public void setqntBooks(int newqntBooks) {
		qntBooks = newqntBooks;
	}

	public void setTypeSorting(String sorting) {
		typeSorting = sorting;
	}
	
	public void addBook(String name, int year, String author, String[] awards, 
			            int numberPages, String genre) {
		Book newBook = new Book();
		if(!name.isEmpty()) { 
			newBook.setName(name);
		}
		if(year != 0) {
			newBook.setFirstEdition(year);
		}
		if(!author.isEmpty()) {
			newBook.setAuthor(author);
		}
		for(int award = 0; award < awards.length; award++) {
			newBook.addAward(awards[award]);
		}
		if(numberPages != -1) {
			newBook.setNumberPages(numberPages);
		}
		if(!genre.isEmpty()) {
			newBook.setGenre(genre);
		}
		books[qntBooks] = newBook; // Book
		qntBooks++;
	}
	
	public void removeBook(String removedBookName) {
		int idx = getBookIndex(books, removedBookName);
		books[idx] = books[qntBooks - 1];
		books[qntBooks - 1] = null;
		qntBooks--;
	}
	
	
	private int getBookIndex(Book[] list, String item){
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
                    Book temp = books[i];						 // == 0: Book[i] == Book[j]
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
                    Book temp = books[i];						 // == 0: Book[i] == Book[j]
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
                    Book temp = books[i];						 
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
                    Book temp = books[i];						 
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
                    Book temp = books[i];						 
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
