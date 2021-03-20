package readUs;

//Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;
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
	private float desiredNumber;
	private float concludedNumber;
	private goalType typeGoal;
	private float progress;
	private Timestamp startTimestamp;
	private Timestamp endTimestamp;
	
	public ReadingGoals(goalType typeGoal, long desiredNumber, long concludedNumber) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);	
		
		startTimestamp = null;
		endTimestamp = null;
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


    public float getDesiredNumber() {
		return desiredNumber;
	}

	public void setDesiredNumber(long desiredNumber) {
		this.desiredNumber = desiredNumber;
		updateProgress();
	}

	public float getConcludedNumber() {
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
		updateProgress();
	}

	
	public goalType getTypeGoal() {
		return typeGoal;
	}


	public void setTypeGoal(goalType typeGoal) {
		this.typeGoal = typeGoal;
	}
	
	Timestamp dateToTimestamp(String date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
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

	private void updateProgress() {
		this.progress = this.concludedNumber / this.desiredNumber;
	}
	
	public float getProgress() {
		updateProgress();
		return this.progress;
	}	

	public JSONObject toJson() {
		JSONObject readingGoalsJson = new JSONObject();
		readingGoalsJson.put("concludedNumber", concludedNumber);
		readingGoalsJson.put("typeGoal", typeGoal);
		readingGoalsJson.put("desiredNumber", desiredNumber);
		return readingGoalsJson;
	}

	
	public String toString() {
		String output = "** Goals Data **\n";
		
		output += "Tipo de meta: " + getTypeGoal() + '\n';
		output += "Quantidade Concluida: " + getConcludedNumber() + '\n';
		output += "Quantidade Desejada: " + getDesiredNumber() + '\n' ;
		output += "Progresso: " + getProgress()*100 + "%\n" ;
		
		if(endTimestamp != null) {
			output += "Data inicial: "  + getStartTimestamp() + '\n';
			output += "Data Final: "  + getEndTimestamp() + '\n';
		}
		return output;
	}
	
	public static void main(String[] args){
		
	}
	
}





	
