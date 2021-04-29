package readUs.controller;

import readUs.model.Book;
import readUs.model.Collection;
import readUs.model.Collection.sortType;
import readUs.model.Literature;

/**
 * Gerencia a biblioteca e todos os seus itens, além de conectar métodos disponíveis
 * no model com suas respectivas vies, conforme for necessário.
 *
 *	@author Bruna Medeiros
 *  @version 1.0 (Apr 2021) 
 */
public class LibraryController {
	Collection myLibrary = new Collection();
	
	/**
	 * @return Nome de todos os livros, revistas e/ou comics disponíveis na 
	 * biblioteca, na ordem em que estão colocadas.
	 */
	public String[] getAllBooksName() {
		String[] booksName = new String[myLibrary.getQntBooks()];
		Literature[] books = myLibrary.getBooks();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			booksName[i] = books[i].getName();
		}
		return booksName;
		
	}
	
	/**
	 * @return Todos os objetos criados e instanciados na biblioteca derivados do 
	 * tipo Literature em formato de lista
	 */
	public Literature[] getAllItems() {
		Literature[] books = myLibrary.getBooks();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			books[i] = books[i];
		}
		return books;
	}
	
	/**
	 * @return Número de livros, revistas e comics na biblioteca.
	 */
	public int getQntBooks() {
		return myLibrary.getQntBooks();
	}
	
	/**
	 * Define a ordem dos livros dentro da biblioteca de acordo com o número representado
	 * @param index: 0 ou default (Título de A a Z),
	 * 				 1 (Título de Z a A),
	 * 				 2 (Ano da primeira edição - Decrescente),
	 * 				 3 (Número de páginas - Decrescente),
	 * 				 4 (Progresso - Decrescente),
	 */
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
	
	/**
	 * @param sorting: Define ordem dos livros dentro da biblioteca (e do array utilizado)
	 */
	public void setSort(sortType sorting) {
		myLibrary.sortBooks(sorting);
	}
	
	/**
	 * @param data: String a ser "cortada"/dividida
	 * @param regex: Separador entre as strings
	 * @return Array de Strings divididas de acordo com o separador escolhido ou nulo, caso a String seja nula.
	 */
	public String[] splitStringArray(String data, String regex) {
		if(data == null) return null;
		else return data.split(regex);
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
	public void addBook(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre, 
			String[] author) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, author);
		
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
	public void addMagazine(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] headline, String frequency, String coverDate) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, headline, frequency, coverDate);
	}
	
	/**
	 * Adiciona nova comic/hq na biblioteca (classe Collection()).
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
	public void addComic(String name, String publisher, String nationality, int firstEdition,
			String originalLanguage, String[] awards, int numberPages, int numberPagesRead, String genre,
			String[] writer, String[] penciller, String[] inker, String[] letterer, String[] colourist,
			String[] mainCharacters) {
		myLibrary.addLiterature(name, publisher, nationality, firstEdition, originalLanguage, awards, 
								numberPages, numberPagesRead, genre, writer, penciller, inker, letterer, 
								colourist, mainCharacters);
		
	}
	
	/**
	 * Verifica a existência de uma obra na biblioteca.
	 * @param name: Título da obra
	 * @return True, caso o livro exista na biblioteca ou 
	 * 		   False, caso não exista 
	 */
	public boolean exists(String name) {
		String[] booksName = getAllBooksName();
		for(int idx = 0; idx < booksName.length; idx++) {
			if(booksName[idx].contentEquals(name))
				return true;
		}
		return false;
	}
	
	/**
	 * Busca o índice da obra com o título escolhido.
	 * @param title: Título da obra
	 * @return Indice do livro ou 
	 * 		  -1 caso não seja encontrado 
	 */
	public int getItemIndex(String title) {
		return myLibrary.getBookIndex(title);
		
	}
	
	/**
	 * Busca o item com o nome da obra com o título definido
	 * @param title: Título da obra
	 * @return Objeto da obra que contém o título informado
	 */
	public Literature getItem(String title) {
		Literature[] books = getAllItems();
		for(int i = 0; i < myLibrary.getQntBooks(); i++) {
			if(title.contentEquals(books[i].getName())) {
				return books[i];
			}
		}
		return null;
	}

	/**
	 * Retorna o tipo da obra escolhida.
	 * @param title: Título da obra
	 * @return 0, caso seja um livro,
	 * 		   1, caso seja uma revista,
	 * 		   2, caso seja uma comic,
	 * 		  -1, caso o tipo não seja definido
	 */
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
			return -1;
		}
		
	}

	/**
	 * Remove um livro, uma revista ou uma hq da biblioteca
	 * @param title: Título da obra
	 */
	public void removeItem(String title) {
		myLibrary.removeBook(title);
	}
}
