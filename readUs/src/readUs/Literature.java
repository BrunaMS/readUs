package readUs;

import java.util.Arrays;
import java.util.Scanner;

public abstract class Literature {
	
	// Atributos

	protected String name;
	protected String publisher;
	protected String nationality;
	protected int firstEdition;
	protected String originalLanguage;
	protected String[] awards;
	protected int numberAwards;
	protected int numberPages;
	protected int numberPagesRead;
	// int launchYear; - Mesma coisa de firstEdition
	protected String genre;
	//EstimatedReadingTime[] estimatedReadingTime;
	protected long progress;
	Scanner ler = new Scanner(System.in);
	
	// Initializes the class attributes
	public Literature() {
		updateProgress();
		numberAwards = 0;
	}
	// 
	//Retorna os atributos
	@Override
	public String toString() {
		return "Obra [Nome:" + name + ", Editora:" + publisher + ", Nacionalidade:" + nationality + ", Primeira Edição:"
				+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Prêmios:" + Arrays.toString(awards)
				+ ", Número de Páginas =" + numberPages + "Número de Páginas Lidas:"+ numberPagesRead+", Gênero =" + genre +"]";
	}

	
	//Get() e set() para os atributos da classe
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setAuthor(String publisher) {
		this.publisher = publisher;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public int getFirstEdition() {
		return firstEdition;
	}


	public void setFirstEdition(int firstEdition) {
		this.firstEdition = firstEdition;
	}


	public String getOriginalLanguage() {
		return originalLanguage;
	}


	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}


	public String[] getAwards() {
		return awards;
	}


	public void setAwards(String[] awards) {
		this.awards = awards;
	}


	public int getNumberAwards() {
		return numberAwards;
	}


	public void setNumberAwards(int numberAwards) {
		this.numberAwards = numberAwards;
	}


	public int getNumberPages() {
		return numberPages;
	}


	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}


	public int getNumberPagesRead() {
		return numberPagesRead;
	}


	public void setNumberPagesRead(int numberPagesRead) {
		this.numberPagesRead = numberPagesRead;
		updateProgress();
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void addAward(String award){
		this.awards[this.numberAwards++] = award;
	}
	
	private void updateProgress() {
		this.progress = this.numberPagesRead / this.numberPages;
	}
	
	public long getProgress() {
		return this.progress;
	}
}