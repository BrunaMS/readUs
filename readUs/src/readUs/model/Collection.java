package readUs.model;

// Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;

import readUs.model.Literature.itemType;

/**
 * @author Bruna Medeiros
 * @version 1.0 (Abr 2021)
 */
public class Collection {

	public enum sortType {
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
	
	
	/**
	 * Define valores padrão para a biblioteca e inicializa array onde os livros serão armazenados
	 */
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
	
	/**
	 * Adiciona um novo livro à biblioteca.
	 * @param name: Nome/Título da obra
	 * @param publisher: Editora
	 * @param nationality: Nacionalidade da obra
	 * @param firstEdition: Ano de lançamento da primeira edição
	 * @param originalLanguage: Linguagem original da obra
	 * @param awards: Lista de prêmios recebidos
	 * @param numberPages: Número total de páginas
	 * @param numberPagesRead: Número de páginas já lidas
	 * @param genre: Gênero da obra
	 * @param author: Lista de autores da obra
	 */
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
			newBook.setType(itemType.BOOK);
	
			books[qntBooks] = newBook;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	/**
	 * Adiciona uma nova revista à biblioteca.
	 * @param name: Nome/Título da obra
	 * @param publisher: Editora
	 * @param nationality: Nacionalidade da obra
	 * @param firstEdition: Ano de lançamento da primeira edição
	 * @param originalLanguage: Linguagem original da obra
	 * @param awards: Lista de prêmios recebidos
	 * @param numberPages: Número total de páginas
	 * @param numberPagesRead: Número de páginas já lidas
	 * @param genre: Gênero da obra
	 * @param headline: Manchete da revista escolhida
	 * @param frequency: Frequência com que a revista é lançada
	 * @param coverDate: Data da capa (mês e ano)
	 */
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
			newMagazine.setType(itemType.MAGAZINE);
	
			books[qntBooks] = newMagazine;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	
	/**
	 * @param name: Nome/Título da obra
	 * @param publisher: Editora
	 * @param nationality: Nacionalidade da obra
	 * @param firstEdition: Ano de lançamento da primeira edição
	 * @param originalLanguage: Linguagem original da obra
	 * @param awards: Lista de prêmios recebidos
	 * @param numberPages: Número total de páginas
	 * @param numberPagesRead: Número de páginas já lidas
	 * @param genre: Gênero da obra
	 * @param writer: Lista de escritores
	 * @param penciller: Lista de quadrinistas
	 * @param inker: Lista de arte-finalistas 
	 * @param letterer: Lista de letristas 
	 * @param colourist: Lista de coloristas
	 * @param mainCharacters: Personagens principais da história
	 */
	public void addLiterature(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] colourist,
			String[] mainCharacters) {
		if(qntBooks < (this.maxBooks)) {
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
			newComic.setColourist(colourist);
			newComic.setMainCharacters(mainCharacters);
			newComic.setType(itemType.COMIC);
	
			books[qntBooks] = newComic;
			qntBooks++;
			sortBooks(typeSorting);
		}
		else {
			System.out.println("Max number exceeded.");
		}
	}
	
	/**
	 * Remove obra da lista, colocando o último item em seu lugar e reduzindo o tamanho do array.
	 * @param removedBookName: Título da obra a ser removida
	 */
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
	
	
	public int getBookIndex(String itemName){
		for(int i = 0; i < this.books.length; i++) {
			if(this.books[i].getName().contentEquals(itemName)) {
				return i;
			}
				
		}
		return -1;
	}

	/**
	 * @param sort: Forma com que deseja-se ordernar os itens dentro da biblioteca
	 */
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

	/**
	 * Ordena lista em ordem alfabética (de A a Z).
	 */
	private void orderLibraryAZ(){
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getName().toLowerCase().compareTo(books[j].getName().toLowerCase()) > 0){ //  > 0: Book[i] > Book[j]
                	Literature temp = books[i];						 // == 0: Book[i] == Book[j]
                    books[i] = books[j];						 //  < 0: Book[i] < Book[j]
                    books[j] = temp;
                }
            }
        }
	}
	
	/**
	 * Ordena lista em ordem alfabética (de Z a A).
	 */
	private void orderLibraryZA() {
        for (int i = 0; i < qntBooks; i++) {
            for (int j = i + 1; j < qntBooks; j++) { 
                if (books[i].getName().toLowerCase().compareTo(books[j].getName().toLowerCase()) < 0){  //  > 0: Book[i]  > Book[j]
                	Literature temp = books[i];						 		// == 0: Book[i] == Book[j]
                    books[i] = books[j];						 			//  < 0: Book[i]  < Book[j]
                    books[j] = temp;
                }
            }
        }
	}
	
	/**
	 * Ordena lista em por ano de lançamento (Mais antigos primeiro).
	 */
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
	
	/**
	 * Ordena lista por quantidade de páginas (maiores primeiro).
	 */
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

	/**
	 * Ordena lista pelo progresso do usuário (maior porcentagem lida primeiro).
	 */
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

	/**
	 * @return json com chaves e valores para todos os itens da lista.
	 */
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
