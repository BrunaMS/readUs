package readUs.model;

public abstract class Literature {
	public enum itemType{
		BOOK,
		MAGAZINE,
		COMIC
	}
	
	
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
	protected String genre;
	protected float progress;
	protected itemType type;
	// EstimatedReadingTime[] estimatedReadingTime; // TODO
	
	// Initializes the class attributes
	public Literature() {
		numberAwards = 0;
	}
	
	//Get() e set() para os atributos da classe
	public String getName() {
		return name;
	}

	public void setType(itemType type) {
		this.type = type;
	}
	
	public itemType getType() {
		return this.type;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
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
	
	/**
	 * Atualiza progresso de acordo com o número de páginas lidas e o número total de páginas da obra.
	 */
	private void updateProgress() {
		this.progress = (float)this.numberPagesRead / (float)this.numberPages;
	}
	
	public float getProgress() {
		updateProgress();
		return this.progress;
	}
	
	public static void main(String[] args){
	}
}