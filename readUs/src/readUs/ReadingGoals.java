package readUs;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class ReadingGoals{
	
	enum goalType {
		PAGES,
		BOOKS,
		CHAPTERS,
		WORDS
	}
	
	// Atributos
	private long desiredNumber;
	private long concludedNumber;
	private goalType typeGoal;
	private Timestamp startTimestamp;
	private Timestamp endTimestamp;
	
	
	public ReadingGoals(goalType typeGoal, long desiredNumber, long concludedNumber) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);	
	}
	
	public ReadingGoals(goalType typeGoal, long desiredNumber, long concludedNumber, String deadline_ddmmyyyy) {
		Date date = new Date();
		
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);
		dateToTimestamp(deadline_ddmmyyyy);
		
		startTimestamp = new Timestamp(date.getTime());
		endTimestamp = dateToTimestamp(deadline_ddmmyyyy);
		
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

	public void set(Timestamp timestamp) {
		this.startTimestamp = timestamp;
	}

	public void setEndTimestamp(Timestamp timestamp) {
		this.endTimestamp = timestamp;
	}

	public Timestamp getEndTimestamp() {
		return this.endTimestamp;
	}

	public Timestamp getStartTimestamp() {
		return this.startTimestamp;
	}

	public void setConcludedNumber(long concludedNumber) {
		this.concludedNumber = concludedNumber;
	}

	
	public goalType getTypeGoal() {
		return typeGoal;
	}


	public void setTypeGoal(goalType typeGoal) {
		this.typeGoal = typeGoal;
	}
	
	Timestamp dateToTimestamp(String date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyy");
	    Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    return timestamp;
	}


//	public String toString() {
//		return "Meta de Leitura \n Foram lidos" + concludedNumber+" de" + typeGoal + "de"+ desiredNumber +" desejados.";
//	}
	public String toString() {
		JSONObject readingGoalsJson = new JSONObject();
		readingGoalsJson.put("concludedNumber", concludedNumber);
		readingGoalsJson.put("typeGoal", typeGoal);
		readingGoalsJson.put("desiredNumber", desiredNumber);
		
		return readingGoalsJson.toString();
		
	}
	
	public static void main(String[] args){
		// goalType typeGoal, long desiredNumber, long concludedNumber
		ReadingGoals myGoals = new ReadingGoals(goalType.PAGES, 1000, 100);
		ReadingGoals myLimitedGoals = new ReadingGoals(goalType.PAGES, 1000, 100, "31122021");
		
	}
	
}





	
