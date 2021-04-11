package readUs.model;
import org.json.JSONObject;

public class Book extends Literature{
	private String[] author;
	
	
	// Initializes the class attributes
	public Book() {
		
	}


	// Get and Set
	public String[] getAuthor() {
		return author;
	}

	
	public void setAuthor(String[] author) {
		this.author = author;
	}


	
	public JSONObject toJson() {
		JSONObject bookJson = new JSONObject();
		bookJson.put("Nome", name);
		bookJson.put("Autor", author);
		bookJson.put("Editora", publisher);
		bookJson.put("Nacionalidade", nationality);
		bookJson.put("Primeira Edicao", firstEdition);
		bookJson.put("Linguagem Original", originalLanguage);
		bookJson.put("Premios", awards);
		bookJson.put("Nro de paginas", numberPages);
		bookJson.put("Nro de paginas lidas", numberPagesRead);
		bookJson.put("Genero", genre);
		return bookJson;
	}
	
	
	public String toString() {
		String output = "\n     ** Dados do Livro **\n";
		output += "Nome: " + getName() + "\n";
		output += "Autor(es): ";
		for(int i = 0; i < author.length; i++) {
			output += getAuthor()[i] + "     ";
		}
		output += "\n";
		output += "Editora: " + getPublisher() + "\n";
		output += "Total de paginas: " + getNumberPages() + "\n";
		output += "Paginas lidas: " + getNumberPagesRead() + "\n";
		output += "Progresso: " + getProgress()* 100 + "%\n";
		output += "Gênero: " + genre + "\n";
		output += "Primeira edicao: " + getFirstEdition() + "\n";
		output += "Premio(s): ";
		for(int i = 0; i < numberAwards; i++) {
			output += getAwards()[i] + "     ";			
		}
		output += "\n";
		return output;	
	}
	
}
