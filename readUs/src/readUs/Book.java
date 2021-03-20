package readUs;

import java.util.Arrays;

public class Book extends Literature{
	private String[] author;
	
	
	// Initializes the class attributes
	public Book() {
		
	}

	public String toString() {
		return "Livro [Nome:" + name + "Autor(es):"+ author+ ", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edi��o:"
				+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Pr�mios:" + Arrays.toString(awards)
				+ ", N�mero de P�ginas =" + numberPages + "N�mero de P�ginas Lidas:"+ numberPagesRead+", G�nero =" + genre +"]";
	}

	// Get and Set
	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}
	
	
	
}
