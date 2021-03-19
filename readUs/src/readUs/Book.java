package readUs;

import java.util.Arrays;

public class Book extends Literature{
	private String[] author;
	
	
	// Initializes the class attributes
	public Book() {
		
	}

	
	@//Retorna os atributosOverride
	public String toString() {
		return "Livro [Nome:" + name + "Autor(es):"+ author+ ", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edição:"
				+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Prêmios:" + Arrays.toString(awards)
				+ ", Número de Páginas =" + numberPages + "Número de Páginas Lidas:"+ numberPagesRead+", Gênero =" + genre +"]";
	}

	// Get and Set
	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}
	
	
	
}
