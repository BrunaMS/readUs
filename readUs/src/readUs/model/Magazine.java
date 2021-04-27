package readUs.model;

import org.json.JSONObject;
/**
 * Cria os objetos do tipo revista e gera string que fornece os dados 
 * de uma revista.
 * @author Bruna Medeiros
 * @version 1.0 (Abril 2021)
 *
 */ 
public class Magazine extends Literature {
	
	private String[] headline;
	private String frequency;
	private String coverDate;
	
	/**
	 * Inicializa os atributos da classe
	 */
	public Magazine() {
		
	}
	
	public String toString() {
		int i;
		String output = "\n     ** Dados da Revista **\n";
		output += "Nome: " + getName() + "\n";
		
		output += "Manchete(s)': ";
		for(i = 0; i < headline.length; i++) {
			output += "\n" + getHeadline()[i] + "     ";
		}
		output += "\n";
		output += "Frequência: " + getFrequency() + "\n";
		output += "Data da Capa: " + getCoverDate() + "\n";
		output += "Editora: " + getPublisher() + "\n";
		output += "Nacionalidade: " + getNationality() + "\n";
		output += "Primeira Edicao: " + getFirstEdition() + "\n";
		output += "Linguagem Original: " + getOriginalLanguage() + "\n";
		output += "Genero: " + getGenre() + "\n";

		output += "Premio(s): \n";
		for(i = 0; i < awards.length; i++) {
			output += "\n" + getAwards()[i] + "     ";
		}
		output += "\n";
		output += "Numero de Paginas: " + getNumberPages() + "\n";
		output += "Numero de Paginas Lidas: " + getNumberPagesRead() + "\n";
		output += "Progresso: " + getProgress()* 100 + "%\n";
		
		return output;
	}


	// Gets and Sets
	public String[] getHeadline() {
		return headline;
	}


	public void setHeadline(String[] headline) {
		this.headline = headline;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public String getCoverDate() {
		return coverDate;
	}


	public void setCoverDate(String coverDate) {
		this.coverDate = coverDate;
	}
	
	// TODO
	public JSONObject toJson() {
		JSONObject magazineJson = new JSONObject();
		
		return magazineJson;
	}
}
