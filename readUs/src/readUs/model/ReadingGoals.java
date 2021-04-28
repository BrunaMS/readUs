package readUs.model;

// Source: https://jar-download.com/artifacts/org.json
import org.json.JSONObject;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bruna Medeiros
 * @version 1.0 (Abr 2021)
 *
 */
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
	
	/**
	 * Adiciona metas sem marcação de tempo.
	 * @param typeGoal: Tipo de meta que deseja-se criar (por nro de páginas, livros, capítulos ou palavras)
	 * @param desiredNumber: Valor ao qual deseja-se chegar (alvo)
	 * @param concludedNumber: Valor atual (presente)
	 */
	public void addReadingGoals(goalType typeGoal, float desiredNumber, float concludedNumber) {
		setTypeGoal(typeGoal);
		setDesiredNumber(desiredNumber);
		setConcludedNumber(concludedNumber);	
		
		startTimestamp = null;
		endTimestamp = null;
	}
	
	/**
	 * Adiciona metas com marcação de tempo.
	 * @param typeGoal: Tipo de meta que deseja-se criar (por nro de páginas, livros, capítulos ou palavras)
	 * @param desiredNumber: Valor ao qual deseja-se chegar (alvo)
	 * @param concludedNumber: Valor atual (presente)
	 * @param endDate: Data em que deseja-se concluir a meta
	 * @param begginingDate: Data em que o desafio será iniciado.
	 */
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
	
	/**
	 * @param date: Data atual no formato(ddMMyyyy) - dia e mês com 2 dígitos e ano com 4 dígitos
	 * @return timestamp
	 */
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

	/**
	 * Obtem progresso pela porcentagem concluída da meta.
	 */
	private void updateProgress() {
		this.progress = this.concludedNumber / this.desiredNumber;
	}
	
	public float getProgress() {
		updateProgress();
		return this.progress;
	}	

	/**
	 * @return json com chaves e valores para todos os dados da meta.
	 */
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





	
