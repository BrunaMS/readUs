package readUs;

import java.util.Arrays;

public class Magazine extends Literature {
	
	private String[] headline;
	private String frequency;
	private String coverDate;
	
	
	// Initializes the class attributes
			public Magazine() {
				
			}
			
			
	//Retorna os atributos
			@Override
			public String toString() {
				return "Revista [Nome:" + name + "Manchete"+ headline + "Frequência da publicação:"+frequency+"Data da publicação"+coverDate
			+", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edição:"
						+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Prêmios:" + Arrays.toString(awards)
						+ ", Número de Páginas =" + numberPages + "Número de Páginas Lidas:"+ numberPagesRead+", Gênero =" + genre +"]";
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
