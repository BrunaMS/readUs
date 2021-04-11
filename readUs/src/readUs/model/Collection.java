package readUs.model;

// Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;

public class Collection {

	protected enum sortType {
		NAME_A_Z,
		NAME_Z_A,
		FIRST_EDITION,
		NUMBER_PAGES,
		PROGRESS
	}

	private int qntBooks;
	private int maxBooks;
	private int maxAwards;
	private Literature[] books;
	private sortType typeSorting;
	
	
	public Collection(){
		qntBooks = 0;
		// Can not be changed
		maxBooks = 100;
		// Can not be changed
		maxAwards = 20;
		typeSorting = sortType.NAME_A_Z;
		books = new Literature[maxBooks];
	}
	
		
	public int getMaxAwards() {
		return maxAwards;
	}

	public int getMaxBooks() {
		return maxBooks;
	}

	public Literature[] getBooks() {
		return books;
	}
	
	public int getQntBooks() {
		return qntBooks;
	}

	public sortType getTypeSorting() {
		return typeSorting;
	}
	
	public void setBooks(Literature[] newBooks) {
		books = newBooks;
	}
	
	public void setQntBooks(int newQntBooks) {
		qntBooks = newQntBooks;
	}

	public void setTypeSorting(sortType sorting) {
		typeSorting = sorting;
	}
	
	// Book
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
			String[] author) {
		if(qntBooks < (this.maxBooks - 1)) {
			Book newBook = new Book();

			newBook.setName(name);
			newBook.setPublisher(publisher);
			newBook.setNationality(nationality);
			newBook.setFirstEdition(firstEdition);
			newBook.setOriginalLanguage(originalLanguage);
			newBook.setAwards(awards);
			newBook.setNumberPages(numberPages);
			newBook.setNumberPagesRead(numberPagesRead);
			newBook.setGenre(genre);
			newBook.setAuthor(author);
	
			books[qntBooks] = newBook;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	// Magazine
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] headline, String frequency, String coverDate) {
		if(qntBooks < (this.maxBooks - 1)) {
			Magazine newMagazine = new Magazine();

			newMagazine.setName(name);
			newMagazine.setPublisher(publisher);
			newMagazine.setNationality(nationality);
			newMagazine.setFirstEdition(firstEdition);
			newMagazine.setOriginalLanguage(originalLanguage);
			newMagazine.setAwards(awards);
			newMagazine.setNumberPages(numberPages);
			newMagazine.setNumberPagesRead(numberPagesRead);
			newMagazine.setGenre(genre);
			newMagazine.setHeadline(headline);
			newMagazine.setFrequency(frequency);
			newMagazine.setCoverDate(coverDate);
	
			books[qntBooks] = newMagazine;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	// Comic
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] collorist,
			String[] mainCharacters) {
		if(qntBooks < (this.maxBooks - 1)) {
			Comic newComic = new Comic();
			
			newComic.setName(name);
			newComic.setPublisher(publisher);
			newComic.setNationality(nationality);
			newComic.setFirstEdition(firstEdition);
			newComic.setOriginalLanguage(originalLanguage);
			newComic.setAwards(awards);
			newComic.setNumberPages(numberPages);
			newComic.setNumberPagesRead(numberPagesRead);
			newComic.setGenre(genre);
			newComic.setWriter(writer);
			newComic.setPenciller(penciller);
			newComic.setInker(inker);
			newComic.setLetterer(letterer);
			newComic.setPenciller(penciller);
			newComic.setCollorist(collorist);
			newComic.setMainCharacters(mainCharacters);
	
			books[qntBooks] = newComic;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	public void removeBook(String removedBookName) {
		int idx = getBookIndex(removedBookName);
		if(qntBooks > 0) {
			books[idx] = books[qntBooks - 1];
			books[qntBooks - 1] = null;
			qntBooks--;			
		}
		else {
			System.out.println("There are no books to remove here");
		}
	}
	
	
	private int getBookIndex(String itemName){
		for(int i = 0; i < this.books.length; i++) {
			if(this.books[i].getName().contentEquals(itemName)) {
				return i;
			}
				
		}
		return -1;
	}

	public void sortBooks(sortType sort){
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
                if (books[i].getName().compareTo(books[j].getName()) > 0){  //  > 0: Book[i]  > Book[j]
                	Literature temp = books[i];						 		// == 0: Book[i] == Book[j]
                    books[i] = books[j];						 			//  < 0: Book[i]  < Book[j]
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

	public JSONObject toJson() {
		JSONObject libraryJson = new JSONObject();
		for(int i = 0; i < this.qntBooks; i++) {
			libraryJson.put("books", books[i].toString());
		}
		libraryJson.put("qntBooks", qntBooks);
		libraryJson.put("typeSorting", typeSorting);
		
		return libraryJson;
	}

	public String toString() {
		String output = "** Biblioteca **\n";
		for(int i = 0; i < this.qntBooks; i++) {
			output += books[i].toString() + "\n";
		}
		output += "Quantidade de Livros: " + qntBooks + "\n";
		output += "Ordenação: " + typeSorting + "\n";
		
		return output;
	}

	public static void main(String[] args){
		
	}
}
