package readUs.controller;

import java.sql.Timestamp;

import readUs.model.ReadingGoals;
import readUs.model.ReadingGoals.goalType;

public class ReadingGoalsController {

	int maxGoals=100;
	int numbGoals=0;
	ReadingGoals[] userGoals = new ReadingGoals[maxGoals];
	boolean detectError = false;
	String error = "Erros:\n";

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

	
	//Add goals

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

	//Updates goals 

	public boolean updateGoal(goalType typeGoal, float desiredNumber, float concludedNumber, int index){
	
			
		
		ReadingGoals newGoal = new ReadingGoals();
		
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber);
		
		userGoals[index]=newGoal;
		
	   		
		return true;
		
	}
	
	public boolean updateGoal(goalType typeGoal, float desiredNumber, float concludedNumber, String endDate, String begginingDate,  int index) {
		
		
	     ReadingGoals newGoal = new ReadingGoals();
		
	    
	     
		newGoal.addReadingGoals(typeGoal, desiredNumber, concludedNumber,endDate, begginingDate);
		
		userGoals[index]=newGoal;
		
	    
		return true;
		
	}


	
	//Save values updated by the user
	
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
	
	
	
	//Save values inserted by the user
	
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

	// Inserted Date Validation

	public void validateDate(int day, int month, int year) {

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day == 31) {
				error = error + "Data inv�lida. Cheque a data e tente novamente.\n";
				detectError = true;
			}
		}

		else if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				if (day > 29) {
					error = error + "Data inv�lida. Cheque a data e tente novamente.\n";
					detectError = true;
				} else {
					if (day > 28) {
						error = error + "Data inv�lida. Cheque a data e tente novamente.\n";
						detectError = true;
					}
				}
			}
		}
	}

	// Validates if there are no empty fields

	public boolean checkEmptyFields(String field, String typefield) {

		if (field.isEmpty() || field == "0" || field == "") {
			switch (typefield) {
			case "DesiredNumber":
				error = error + "O campo numero desejado n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "ConcludedNumber":
				error = error + "O campo numero concluido n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "DayBeggining":
				error = error + "O campo dia do inicio n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "MonthBeggining":
				error = error + "O campo mes do inicio n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "YearBeggining":
				error = error + "O campo mes do inicio n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "DayEnd":
				error = error + "O campo dia do fim n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "MonthEnd":
				error = error + "O campo mes do fim n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			case "YearEnd":
				error = error + "O campo mes do fim n�o pode ser deixado vazio. Por favor insira um n�mero.\n";
				detectError = true;
				break;
			}
			return true;
		} else {
			return false;
		}

	}

	// Checks if desired number is smaller than concluded number

	public void validateDesiredConcluded(float desired, float concluded) {
		if (desired <= concluded) {
			
			error = error
					+ "O n�mero concluido n�o pode ser maior ou igual ao desejado. Por favor confira seus valores.\n";
			detectError = true;
		}
	}

	// Checks if the inserted end date is happens after the inserted beggining date

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
					+ "A data de inicio n�o pode acontecer apos a data de fim. Por favor confira suas datas e tente novamente.\n";
			detectError = true;
		}
	}

}




