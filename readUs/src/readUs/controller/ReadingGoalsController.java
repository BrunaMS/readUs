package readUs.controller;

import java.sql.Timestamp;

import readUs.model.ReadingGoals;
import readUs.model.ReadingGoals.goalType;
/**
 * Adiciona, atualiza, deleta e valida os dados relativos aos objetivos de leitura.
 * @author Beatriz Carolina
 * @version 1.0 (Abril 2021)
 *
 */
public class ReadingGoalsController {

	int maxGoals=100;
	int numbGoals=0;
	ReadingGoals[] userGoals = new ReadingGoals[maxGoals];
	boolean detectError = false;
	String error = "Erros:\n";
 
	
	public float getProgress(int index) {
		return userGoals[index].getProgress();
	}
	
	
	
//Gets and sets
	public boolean isDetectError() {
		return detectError;
	}



	public void setDetectError(boolean detectError) {
		this.detectError = detectError;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}

	public ReadingGoals[] getUserGoals() {
		return userGoals;
	}



	public void setUserGoals(ReadingGoals[] userGoals) {
		this.userGoals = userGoals;
	}



	public int getNumbGoals() {
		
		return numbGoals;
	}
	
	public String getStringGoals(int index) {
		return userGoals[index].toString();
	}

	
	/**
	 * Adiciona um novo objetivo aos ja existentes.
	 * @param typeGoal:parametro do tipo goalType que indica o que se deseja computar com um objetivo pode ser paginas('PAGES'), livros('BOOKS'), capitulos('CHAPTERS') e palavras ('WORDS').
	 * @param desiredNumber: numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber: numero que ja se alcançou do objetivo.
	 * @return falso caso o numero maximo de objetivos ja tenha sido extrapolado e verdadeiro caso nao
	 */

	public boolean addGoal(goalType typeGoal, float desiredNumber, float concludedNumber){
		if (numbGoals>=maxGoals){
			return false;
		}	
		
		ReadingGoals newGoal = new ReadingGoals();
		
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber);
		
		userGoals[numbGoals]=newGoal;
		
	    numbGoals++;
		
		return true;
		
	}
	/**
	 * Adiciona um novo objetivo aos ja existentes.
	 * @param typeGoal: parametro do tipo goalType que indica o que se deseja computar com um objetivo pode ser paginas('PAGES'), livros('BOOKS'), capitulos('CHAPTERS') e palavras ('WORDS').
	 * @param desiredNumber: numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber: numero que ja se alcançou do objetivo.
	 * @param endDate:string que representa a data na qual deseja-se concluir o  objetivo no formato DDMMYYYY.
	 * @param begginingDate:string que representa data na qual deseja-se começar/começou o objetivo no formato DDMMYYYY.
	 * @return falso caso o numero maximo de objetivos ja tenha sido extrapolado e verdadeiro caso nao
	 */
	public boolean addGoal(goalType typeGoal, float desiredNumber, float concludedNumber, String endDate, String begginingDate) {
		if (numbGoals>=maxGoals){
			return false;
		}
		
		
	     ReadingGoals newGoal = new ReadingGoals();
		
	    
	     
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber,endDate, begginingDate);
		
		userGoals[numbGoals]=newGoal;
		
	    numbGoals++;
		return true;
		
	}
	

	/**
	 * Deleta um objetivo ja existente
	 * @param index: indice inteiro que representa o objetivo que se deseja apagar.
	 */

	
	public void removeGoal(int index) {
		
		if(numbGoals > 0) {
			userGoals[index] = userGoals[numbGoals-1];
			userGoals[numbGoals-1] = null;
			numbGoals--;			
		}
		
	}
	
	/**
	 * Atualiza um objetivo ja existente
	 * @param typeGoal :parametro do tipo goalType que indica o que se deseja computar com um objetivo pode ser paginas('PAGES'), livros('BOOKS'), capitulos('CHAPTERS') e palavras ('WORDS').
	 * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
	 * @param endDate:string que representa a data na qual deseja-se concluir o  objetivo no formato DDMMYYYY.
	 * @param begginingDate:string que representa data na qual deseja-se começar/começou o objetivo no formato DDMMYYYY.
	 * @param index: indice inteiro que representa o objetivo que se deseja atualizar.
	 * @return verdadeiro se objetivos foram atualizados com sucesso.
	 */

	

	public boolean updateGoal(goalType typeGoal, float desiredNumber, float concludedNumber, int index){
	
			
		
		ReadingGoals newGoal = new ReadingGoals();
		
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber);
		
		userGoals[index]=newGoal;
		
	   		
		return true;
		
	}
	
	/**
	 * Atualiza um objetivo ja existente
	 * @param typeGoal :parametro do tipo goalType que indica o que se deseja computar com um objetivo pode ser paginas('PAGES'), livros('BOOKS'), capitulos('CHAPTERS') e palavras ('WORDS').
	 * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
	 * @param index: indice inteiro que representa o objetivo que se deseja atualizar.
	 * @return verdadeiro se objetivos foram atualizados com sucesso.
	 */
	
	public boolean updateGoal(goalType typeGoal, float desiredNumber, float concludedNumber, String endDate, String begginingDate,  int index) {
		
		
	     ReadingGoals newGoal = new ReadingGoals();
		
	    
	     
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber,endDate, begginingDate);
		
		userGoals[index]=newGoal;
		
	    
		return true;
		
	}

    /**
     * Salva os valores atualizados pelo usuario
     * @param typeGoalField: string que indica o que se deseja computar com um objetivo pode ser "Paginas", "Livros", "Capitulos" e "Palavras".
     * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
	 * @param index: indice inteiro que representa o objetivo que se deseja atualizar.
     */
	
	
	public void updateValues(String typeGoalField, float DesiredNumber, float ConcludedNumber,int index) {
	
	switch (typeGoalField) {
	case "Paginas":
		updateGoal(goalType.PAGES,DesiredNumber,ConcludedNumber,index);
		break;
	case "Livros":
		updateGoal(goalType.BOOKS,DesiredNumber,ConcludedNumber,index);
		break;
	case "Capitulos":
		updateGoal(goalType.CHAPTERS,DesiredNumber,ConcludedNumber,index);
		break;
	case "Palavras":
		updateGoal(goalType.WORDS,DesiredNumber,ConcludedNumber,index);
		break;
	}
	
	}
	
	/**
     * Salva os valores atualizados pelo usuario
     * @param typeGoalField: string que indica o que se deseja computar com um objetivo pode ser "Paginas", "Livros", "Capitulos" e "Palavras".
     * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
	 * @param index: indice inteiro que representa o objetivo que se deseja atualizar.
	 * @param endDate:string que representa a data na qual deseja-se concluir o  objetivo no formato DDMMYYYY.
	 * @param begginingDate:string que representa data na qual deseja-se começar/começou o objetivo no formato DDMMYYYY.
     */
	
	
	public void updateValues(String typeGoalField, float DesiredNumber, float ConcludedNumber, String endDate, String begginingDate, int index) {
		
		switch (typeGoalField) {
		case "Paginas":
			updateGoal(goalType.PAGES,DesiredNumber,ConcludedNumber,endDate,begginingDate, index);
			break;
		case "Livros":
			updateGoal(goalType.BOOKS,DesiredNumber,ConcludedNumber,endDate,begginingDate, index);
			break;
		case "Capitulos":
			updateGoal(goalType.CHAPTERS,DesiredNumber,ConcludedNumber,endDate,begginingDate,index);
			break;
		case "Palavras":
			updateGoal(goalType.WORDS,DesiredNumber,ConcludedNumber,endDate,begginingDate,index);
			break;
		}
		
		}
	
	/**
     * Salva os valores inseridos na interface pelo usuario
     * @param typeGoalField: string que indica o que se deseja computar com um objetivo pode ser "Paginas", "Livros", "Capitulos" e "Palavras".
     * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
     */
	

	public void saveValues(String typeGoalField, float DesiredNumber, float ConcludedNumber) {
	
	switch (typeGoalField) {
	case "Paginas":
		addGoal(goalType.PAGES,DesiredNumber,ConcludedNumber);
		break;
	case "Livros":
		addGoal(goalType.BOOKS,DesiredNumber,ConcludedNumber);
		break;
	case "Capitulos":
		addGoal(goalType.CHAPTERS,DesiredNumber,ConcludedNumber);
		break;
	case "Palavras":
		addGoal(goalType.WORDS,DesiredNumber,ConcludedNumber);
		break;
	}
	
	}
	
	/**
     * Salva os valores inseridos na interface pelo usuario
     * @param typeGoalField: string que indica o que se deseja computar com um objetivo pode ser "Paginas", "Livros", "Capitulos" e "Palavras".
     * @param desiredNumber:  numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
	 * @param concludedNumber:  numero que ja se alcançou do objetivo.
	 * @param endDate:string que representa a data na qual deseja-se concluir o  objetivo no formato DDMMYYYY.
	 * @param begginingDate:string que representa data na qual deseja-se começar/começou o objetivo no formato DDMMYYYY.
     */
	
	
	public void saveValues(String typeGoalField, float DesiredNumber, float ConcludedNumber, String endDate, String begginingDate) {
		
		switch (typeGoalField) {
		case "Paginas":
			addGoal(goalType.PAGES,DesiredNumber,ConcludedNumber,endDate,begginingDate);
			break;
		case "Livros":
			addGoal(goalType.BOOKS,DesiredNumber,ConcludedNumber,endDate,begginingDate);
			break;
		case "Capitulos":
			addGoal(goalType.CHAPTERS,DesiredNumber,ConcludedNumber,endDate,begginingDate);
			break;
		case "Palavras":
			addGoal(goalType.WORDS,DesiredNumber,ConcludedNumber,endDate,begginingDate);
			break;
		}
		
		}
	
	// Validation functions
	
	/**
	 * Valida se uma certa data existe
	 * @param day: numero inteiro que representa o dia da data que se deseja validar.
	 * @param month: numero inteiro que representa o mes da data que se deseja validar.
	 * @param year: numero inteiro que representa o ano da data que se deseja validar.
	 */


	public void validateDate(int day, int month, int year) {

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day == 31) {
				error = error + "Data invalida. Cheque a data e tente novamente.\n";
				detectError = true;
			}
		}

		else if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				if (day > 29) {
					error = error + "Data invalida. Cheque a data e tente novamente.\n";
					detectError = true;
				} else {
					if (day > 28) {
						error = error + "Data invalida. Cheque a data e tente novamente.\n";
						detectError = true;
					}
				}
			}
		}
	}


/**
 * Valida se o usuario nao deixou nenhum campo vazio
 * @param field: string com os dados do campo a ser verificado
 * @param typefield: string que representa qual campo ira ser verificado
 * @return verdadeiro se algum dos campos esteja vazio e falso caso nao
 */
	public boolean checkEmptyFields(String field, String typefield) {

		if (field.isEmpty() || field == "0" || field == "") {
			switch (typefield) {
			case "DesiredNumber":
				error = error + "O campo numero desejado nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "ConcludedNumber":
				error = error + "O campo numero concluido nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "DayBeggining":
				error = error + "O campo dia do inicio nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "MonthBeggining":
				error = error + "O campo mes do inicio nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "YearBeggining":
				error = error + "O campo mes do inicio nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "DayEnd":
				error = error + "O campo dia do fim nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "MonthEnd":
				error = error + "O campo mes do fim nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			case "YearEnd":
				error = error + "O campo mes do fim nao pode ser deixado vazio. Por favor insira um numero.\n";
				detectError = true;
				break;
			}
			return true;
		} else {
			return false;
		}

	}

/**
 * Verifica se o numero desejado pelo usuario e menor que o numero concluido.
 * @param desired: numero que se deseja alcancar com um certo objetivo (ex. ler 50 páginas).
 * @param concluded: numero que ja se alcançou do objetivo.
 */


	public void validateDesiredConcluded(float desired, float concluded) {
		if (desired <= concluded) {
			
			error = error
					+ "O numero concluido nao pode ser maior ou igual ao desejado. Por favor confira seus valores.\n";
			detectError = true;
		}
	}
/**
 * Verifica se a data final do objetivo acontece apos a data inicial.
 * @param dayBeggining: numero inteiro que representa o dia da data inicial.
 * @param monthBeggining: numero inteiro que representa o mes da data inicial.
 * @param yearBeggining: numero inteiro que representa o ano da data inicial.
 * @param dayEnd: numero inteiro que representa o dia da data final.
 * @param monthEnd: numero inteiro que representa o mes da data final.
 * @param yearEnd: numero inteiro que representa o ano da data final.
 */


	public void validateDateInterval(int dayBeggining, int monthBeggining, int yearBeggining, int dayEnd, int monthEnd,
			int yearEnd) {

		// Changes the string to the appropriate format
		
		
		String stringValidDayBeggining = String.valueOf(dayBeggining);
		String stringValidMonthBeggining = String.valueOf(monthBeggining);
		String stringValidYearBeggining = String.valueOf(yearBeggining);
		
		while (stringValidDayBeggining.length() < 2) {
			stringValidDayBeggining= "0" + stringValidDayBeggining;
		}
		while (stringValidMonthBeggining.length() < 2) {
			stringValidMonthBeggining= "0" + stringValidMonthBeggining;
		}
		
		String begginingDate = stringValidDayBeggining+stringValidMonthBeggining+stringValidYearBeggining;
		
		String stringValidDayEnd = String.valueOf(dayEnd);
		String stringValidMonthEnd = String.valueOf(monthEnd);
		String stringValidYearEnd = String.valueOf(yearEnd);
		
		while (stringValidDayEnd.length() < 2) {
			stringValidDayEnd= "0" + stringValidDayEnd;
		}
		while (stringValidMonthEnd.length() < 2) {
			stringValidMonthEnd= "0" + stringValidMonthEnd;
		}
		
		String endDate = stringValidDayEnd+stringValidMonthEnd+stringValidYearEnd;
		
		

	
		
		
		// Convert string to time stamp
		
		
		Timestamp timeStampBeggining = ReadingGoals.dateToTimestamp(begginingDate);
		Timestamp timeStampEnd = ReadingGoals.dateToTimestamp(endDate);

		if (timeStampBeggining.after(timeStampEnd)) {
			error = error
					+ "A data de inicio nao pode acontecer apos a data de fim. Por favor confira suas datas e tente novamente.\n";
			detectError = true;
		}
	}

}




