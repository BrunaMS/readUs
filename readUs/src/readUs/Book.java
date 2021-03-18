package readUs;

import java.util.Arrays;
import java.util.Scanner;

public class Book {
	
	// Atributos

	private String name;
	private String author;
	private String nationality;
	private int firstEdition;
	private String originalLanguage;
	private String[] awards;
	private int numberAwards;
	private int numberPages;
	private int numberPagesRead;
	// int launchYear; - Mesma coisa de firstEdition
	private String genre;
	//EstimatedReadingTime[] estimatedReadingTime;
	private long progress;
	Scanner ler = new Scanner(System.in);
	
	// Initializes the class attributes
	public Book() {
		updateProgress();
		numberAwards = 0;
	}
	// 

	@Override
	public String toString() {
		return "Livro [Nome:" + name + ", Autor:" + author + ", Nacionalidade:" + nationality + ", Primeira Edi��o:"
				+ firstEdition + ", Linguagem Original =" + originalLanguage + ", Pr�mios:" + Arrays.toString(awards)
				+ ", N�mero de P�ginas =" + numberPages + "N�mero de P�ginas Lidas:"+ numberPagesRead+", Gen�ro =" + genre +"]";
	}

	
	//Get() e set() para os atributos da classe
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
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