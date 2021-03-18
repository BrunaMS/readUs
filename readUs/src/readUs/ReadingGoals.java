package readUs;

public class ReadingGoals {
	
	// Atributos

	long desiredNumber;
	long concludedNumber;
	String typeGoal;


    public long getDesiredNumber() {
		return desiredNumber;
	}

	public void setDesiredNumber(long desiredNumber) {
		this.desiredNumber = desiredNumber;
	}

	public long getConcludedNumber() {
		return concludedNumber;
	}


	public void setConcludedNumber(long concludedNumber) {
		this.concludedNumber = concludedNumber;
	}

	
	public String getTypeGoal() {
		return typeGoal;
	}


	public void setTypeGoal(String typeGoal) {
		this.typeGoal = typeGoal;
	}


	public String toString() {
		return "Meta de Leitura \n Foram lidos"+concludedNumber+" de" + typeGoal + "de"+ concludedNumber +" desejados.";
	}
	
}





	
