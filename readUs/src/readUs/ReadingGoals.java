package readUs;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadingGoals {
	
	// Atributos

	private long desiredNumber;
	private long concludedNumber;
	private String typeGoal;
	private String timestamp;
	
	
	public ReadingGoals(String typeGoal, long desiredNumber, long concludedNumber) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);	
	}
	
	public ReadingGoals(String typeGoal, long desiredNumber, long concludedNumber, String date_ddmmyyyy) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);
		setTimestamp(date_ddmmyyyy);
		
	}


    public long getDesiredNumber() {
		return desiredNumber;
	}

	public void setDesiredNumber(long desiredNumber) {
		this.desiredNumber = desiredNumber;
	}

	public long getConcludedNumber() {
		return concludedNumber;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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





	
