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
	}
	
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre) {
		Literature newMagazine = new Magazine();
		books[qntBooks] = newMagazine;
		qntBooks++;
		
		newMagazine.setName(name);
		newMagazine.setPublisher(publisher);
		newMagazine.setNationality(nationality);
		newMagazine.setFirstEdition(firstEdition);
		newMagazine.setOriginalLanguage(originalLanguage);
		newMagazine.setAwards(awards);
		newMagazine.setNumberPages(numberPages);
		newMagazine.setNumberPagesRead(numberPagesRead);
		newMagazine.setGenre(genre);
	}
	
	// Comic
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] colorist,
			String[] mainCharacters) {
		Literature newComic = new Comic();
		books[qntBooks] = newComic;
		qntBooks++;
		
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
		newComic.setColorist(colorist);
		newComic.setMainCharacters(mainCharacters);
	}
	
	//	(articles)
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
			String[] headline, String frequency, String coverDate) {
		Literature newArticle = new Article();
		books[qntBooks] = newArticle;
		qntBooks++;
		
		newArticle.setName(name);
		newArticle.setPublisher(publisher);
		newArticle.setNationality(nationality);
		newArticle.setFirstEdition(firstEdition);
		newArticle.setOriginalLanguage(originalLanguage);
		newArticle.setAwards(awards);
		newArticle.setNumberPages(numberPages);
		newArticle.setNumberPagesRead(numberPagesRead);
		newArticle.setGenre(genre);
		newArticle.setHeadline(headline);
		newArticle.setFrequency(frequency);
		newArticle.setCoverDate(coverDate);
	}
	
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

	public String toString() {
		JSONObject libraryJson = new JSONObject();
		libraryJson.put("books", books.toString());
		libraryJson.put("qntBooks", qntBooks);
		libraryJson.put("typeSorting", typeSorting);
		
		return libraryJson.toString();
		
	}
	//String name, String publisher, String nationality, int firstEdition,
	//String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
	//String author
	public static void main(String[] args){
		Collection	myLibrary = new Collection();
		myLibrary.addLiterature("I am four number", "HarperTorch", "English", 2010, "English", [""], 440, 0, "Science fiction", "Pittacus Lore"); 
		System.out.println(myLibrary.toString());
	}
}
