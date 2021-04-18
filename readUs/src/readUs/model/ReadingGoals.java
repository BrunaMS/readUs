package readUs.model;

//Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadingGoals{
	
	public enum goalType {
		PAGES,
		BOOKS,
		CHAPTERS,
		WORDS
	}
	
	// Attributes
	private float desiredNumber;
	private float concludedNumber;
	private float progress;
	private goalType typeGoal;
	private Timestamp startTimestamp;
	private Timestamp endTimestamp;
	
	public void addReadingGoals(goalType typeGoal, float desiredNumber, float concludedNumber) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);	
		
		startTimestamp = null;
		endTimestamp = null;
	}
	
	public void addReadingGoals(goalType typeGoal, float desiredNumber, float concludedNumber, String endDate, String begginingDate) {
		
		
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);
		
		
		
		startTimestamp = dateToTimestamp(begginingDate);
		endTimestamp = dateToTimestamp(endDate);
		
	}


    public float getDesiredNumber() {
		return desiredNumber;
	}

	public void setDesiredNumber(float desiredNumber) {
		this.desiredNumber = desiredNumber;
		updateProgress();
	}

	public float getConcludedNumber() {
		return concludedNumber;
	}
	
	public void setConcludedNumber(float concludedNumber) {
		this.concludedNumber = concludedNumber;
		updateProgress();
	}

	public void setStartTimestamp(Timestamp timestamp) {
		this.startTimestamp = timestamp;
	}

	public Timestamp getStartTimestamp() {
		return this.startTimestamp;
	}

	public void setEndTimestamp(Timestamp timestamp) {
		this.endTimestamp = timestamp;
	}

	public Timestamp getEndTimestamp() {
		return this.endTimestamp;
	}

	public goalType getTypeGoal() {
		return typeGoal;
	}


	public void setTypeGoal(goalType typeGoal) {
		this.typeGoal = typeGoal;
	}
	
	public static Timestamp dateToTimestamp(String date) {
		
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





	
