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
				return "Revista [Nome:" + name + "Manchete"+ headline + "Frequ�ncia da publica��o:"+frequency+"Data da publica��o"+coverDate
			+", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edi��o:"
						+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Pr�mios:" + Arrays.toString(awards)
						+ ", N�mero de P�ginas =" + numberPages + "N�mero de P�ginas Lidas:"+ numberPagesRead+", G�nero =" + genre +"]";
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
