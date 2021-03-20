package readUs;

import java.util.Arrays;

public class Book extends Literature{
	private String[] author;
	
	
	// Initializes the class attributes
	public Book() {
		
	}

	public String toString() {
		return "Livro [Nome:" + name + "Autor(es):"+ author+ ", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edicao:"
				+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Premios:" + Arrays.toString(awards)
				+ ", Numero de Paginas =" + numberPages + "Numero de Paginas Lidas:"+ numberPagesRead+", Genero =" + genre +"]";
	}

	// Get and Set
	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}
	
	
	
}
