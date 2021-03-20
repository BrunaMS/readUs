package readUs;

import java.util.Arrays;

public class Comic extends Literature{

	private String[] writer;
	private String[] penciller;
	private String[] inker;
	private String[] letterer;
	private String[] collorist;
	private String[] mainCharacters;
	
	// Initializes the class attributes
		public Comic() {
			
		}
		
		// Retorna os atributos
		@Override
		public String toString() {
			return "HQ [Nome:" + name + "Roteirista(s):"+ writer + "Ilustrador(es):" + penciller + "Finalista(s)"
					+ inker + "Letrista(s)" + letterer + "Colorista(s)" + collorist + "Personagens Principais:"
					+ mainCharacters +", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edicao:"
					+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Premios:" + Arrays.toString(awards)
					+ ", Numero de Paginas =" + numberPages + "Numero de Paginas Lidas:"+ numberPagesRead +", Genero =" + genre + "]";
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

		public String[] getCollorist() {
			return collorist;
		}

		public void setCollorist(String[] collorist) {
			this.collorist = collorist;
		}

		public String[] getMainCharacters() {
			return mainCharacters;
		}

		public void setMainCharacters(String[] mainCharacters) {
			this.mainCharacters = mainCharacters;
		}
	
	
}
