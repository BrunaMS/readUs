package readUs;

import java.util.Arrays;

public class Magazine extends Literature {
	
	private String[] headline;
	private String frequency;
	private String coverDate;
	
	
	// Initializes the class attributes
			public Magazine() {
				
			}
			
			
	// Retorna os atributos
			@Override
			public String toString() {
				return "Revista [Nome:" + name + "Manchete"+ headline + "Frequencia da publicacao:"+frequency+"Data da publicacao"+coverDate
			+", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edicao:"
						+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Premios:" + Arrays.toString(awards)
						+ ", Numero de Paginas =" + numberPages + "Numero de Paginas Lidas:"+ numberPagesRead+", Genero =" + genre +"]";
			}


//Gets and Sets
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

			
			
}
