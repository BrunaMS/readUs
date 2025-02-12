package readUs.model;
import org.json.JSONObject;
/**
 * Cria os objetos do tipo quadrinho e gera string que fornece os dados 
 * de um quadrinho.
 * @author Bruna Medeiros
 * @version 1.0 (Abril 2021)
 *
 */ 
public class Comic extends Literature{

	private String[] writer;
	private String[] penciller;
	private String[] inker;
	private String[] letterer;
	private String[] colourist;
	private String[] mainCharacters;
	
	/**
	 * Inicializa os atributos da classe
	 */
	public Comic() {
		
	}
	
	// Gets and Sets
	public String[] getWriter() {
		return writer;
	}

	public void setWriter(String[] writer) {
		this.writer = writer;
	}

	public String[] getPenciller() {
		return penciller;
	}

	public void setPenciller(String[] penciller) {
		this.penciller = penciller;
	}

	public String[] getInker() {
		return inker;
	}

	public void setInker(String[] inker) {
		this.inker = inker;
	}

	public String[] getLetterer() {
		return letterer;
	}

	public void setLetterer(String[] letterer) {
		this.letterer = letterer;
	}

	public String[] getColourist() {
		return colourist;
	}

	public void setColourist(String[] colourist) {
		this.colourist = colourist;
	}

	public String[] getMainCharacters() {
		return mainCharacters;
	}

	public void setMainCharacters(String[] mainCharacters) {
		this.mainCharacters = mainCharacters;
	}

	
	
	public String toString() {	
		int i = 0;
		String output = "\n     ** Dados da Comic **\n";
		output += "Nome: " + getName() + "\n";
		
		output += "Roteirista(s): ";
		for(i = 0; i < writer.length; i++) {
			output += "\n" + getWriter()[i];
		}
		output += "\n";
		output += "Ilustrador(es): ";
		for(i = 0; i < penciller.length; i++) {	
			output += "\n" + getPenciller()[i];
		}
		output += "\n";
        output += "Finalista(s): ";
		for(i = 0; i < inker.length; i++) {
			output += "\n" + getInker()[i];				
		}
		output += "\n";
		output += "Letrista(s): ";
		for(i = 0; i < letterer.length; i++) {
			output += "\n" + getLetterer()[i];				
		}
		output += "\n";
		output += "Colorista(s): ";
		for(i = 0; i < colourist.length; i++) {
			output += "\n" + getColourist()[i];				
		}
		output += "\n";
		output += "Personagens Principais: ";
		for(i = 0; i < mainCharacters.length; i++) {
			output += "\n" + getMainCharacters()[i];				
		}
		output += "\n";
		output += "Editora: " + getPublisher() + "\n";
		output += "Nacionalidade: " + getNationality() + "\n";
		output += "Primeira Edicao: " + getFirstEdition() + "\n";
		output += "Linguagem Original: " + getOriginalLanguage() + "\n";
		output += "Genero: " + getGenre() + "\n";

		output += "Premio(s): ";
		for(i = 0; i < awards.length; i++) {
			output += "\n" + getAwards()[i];
		}
		output += "\n";
		output += "Numero de Paginas: " + getNumberPages() + "\n";
		output += "Numero de Paginas Lidas: " + getNumberPagesRead() + "\n";
		output += "Progresso: " + getProgress() * 100 + "%\n";

		return output;
	}
	
	// TODO
	public JSONObject toJson() {
		JSONObject comicJson = new JSONObject();
		
		return comicJson;
		
	}
	
}
