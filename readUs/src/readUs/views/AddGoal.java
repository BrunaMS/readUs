package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals;
import readUs.model.ReadingGoals.goalType;

import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;

public class AddGoal extends JPanel {

	ReadingGoalsController GoalsControl;

	/**
	 * Creation of panel for new goals
	**/

	public AddGoal(ReadingGoalsController GoalsControl) {

		this.GoalsControl = GoalsControl;
		boolean result = false;

		JLabel lblTitle = new JLabel("Nova Meta");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 31));

		JComboBox goalSelection = new JComboBox();
		goalSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));

		goalSelection.addItem("Paginas");
		goalSelection.addItem("Livros");
		goalSelection.addItem("Capitulos");
		goalSelection.addItem("Palavras");

		JLabel lblGoalType = new JLabel("Tipo de objetivo");
		lblGoalType.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDesiredNumber = new JLabel("N\u00FAmero Desejado");
		lblDesiredNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblConcludedNumber = new JLabel("N\u00FAmero Concluido");
		lblConcludedNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Add combobox for the selection of the beggining and end of the goals

		JComboBox dayBeggining = new JComboBox();

		JComboBox monthBeggining = new JComboBox();

		JComboBox yearBeggining = new JComboBox();

		JLabel lblBeggining = new JLabel("In\u00EDcio");
		lblBeggining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBeggining.setVisible(false);

		JLabel lblEnd = new JLabel("Fim");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnd.setVisible(false);

		JComboBox dayEnd = new JComboBox();

		JComboBox monthEnd = new JComboBox();

		JComboBox yearEnd = new JComboBox();

		for (int days = 1; days <= 31; days++) {

			String stringDays = String.valueOf(days);

			while (stringDays.length() < 2) {
				stringDays = "0" + stringDays;
			}
			dayBeggining.addItem(stringDays);
			dayEnd.addItem(String.valueOf(stringDays));

		}

		for (int month = 01; month <= 12; month++) {

			String stringMonth = String.valueOf(month);
			while (stringMonth.length() < 2) {
				stringMonth = "0" + stringMonth;
			}
			monthBeggining.addItem(stringMonth);
			monthEnd.addItem(stringMonth);
		}

		for (int year = 2000; year <= 2030; year++) {

			yearBeggining.addItem(String.valueOf(year));
			yearEnd.addItem(String.valueOf(year));
		}

		/*
		 * Allows user to insert date for a goal if checkbox is selected
		 */
		dayBeggining.setVisible(false);
		monthBeggining.setVisible(false);
		yearBeggining.setVisible(false);
		dayEnd.setVisible(false);
		monthEnd.setVisible(false);
		yearEnd.setVisible(false);

		JCheckBox chckbxDefDates = new JCheckBox("Definir datas");
		chckbxDefDates.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxDefDates.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxDefDates.isSelected()) {

					dayBeggining.setVisible(true);
					monthBeggining.setVisible(true);
					yearBeggining.setVisible(true);
					dayEnd.setVisible(true);
					monthEnd.setVisible(true);
					yearEnd.setVisible(true);
					lblEnd.setVisible(true);
					lblBeggining.setVisible(true);
				} else {
					dayBeggining.setVisible(false);
					monthBeggining.setVisible(false);
					yearBeggining.setVisible(false);
					dayEnd.setVisible(false);
					monthEnd.setVisible(false);
					yearEnd.setVisible(false);
					lblEnd.setVisible(true);
					lblBeggining.setVisible(true);

				}
			}
		});

		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);

		JFormattedTextField formattedDesiredNumber = new JFormattedTextField(formatter);
		formattedDesiredNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));

		formattedDesiredNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						&& formattedDesiredNumber.getText().length() == 1) {

					formattedDesiredNumber.setText("0");
				}
			}
		});

		JFormattedTextField formattedConcludedNumber = new JFormattedTextField(formatter);
		formattedConcludedNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						&& formattedConcludedNumber.getText().length() == 1) {

					formattedConcludedNumber.setText("0");
				}
			}
		});
		formattedConcludedNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblBlankField = new JLabel("0");
		lblBlankField.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBlankField.setForeground(new Color(255, 0, 0));

		lblBlankField.setVisible(false);

		JButton saveButton = new JButton("Salvar");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblSucess = new JLabel("Nova meta salva :)");
		lblSucess.setForeground(new Color(0, 128, 128));
		lblSucess.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSucess.setVisible(false);
		
		
		// Validate user data when the save button is clicked

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String typeGoalField = (String) goalSelection.getSelectedItem();
				lblBlankField.setVisible(false);
				GoalsControl.setDetectError(false);
				GoalsControl.setError("Erros:\n");

				if (chckbxDefDates.isSelected()) {

					// Checks if all fields are filled

					boolean test1 = GoalsControl.checkEmptyFields(formattedDesiredNumber.getText(), "DesiredNumber");
					boolean test2 = GoalsControl.checkEmptyFields(formattedConcludedNumber.getText(),
							"ConcludedNumber");

					// Checks if desired number is smaller than concluded number

					if (test1 == false && test2 == false) {
						GoalsControl.validateDesiredConcluded(
								Float.valueOf(formattedDesiredNumber.getText().replace(".", "")),
								Float.valueOf(formattedConcludedNumber.getText().replace(".", "")));
					}

					// Continues checking if fields are filled

					GoalsControl.checkEmptyFields(String.valueOf(dayBeggining.getItemCount()), "DayBeggining");
					GoalsControl.checkEmptyFields(String.valueOf(monthBeggining.getItemCount()), "MonthBeggining");
					GoalsControl.checkEmptyFields(String.valueOf(yearBeggining.getItemCount()), "YearBeggining");

					GoalsControl.checkEmptyFields(String.valueOf(dayEnd.getItemCount()), "DayEnd");
					GoalsControl.checkEmptyFields(String.valueOf(monthEnd.getItemCount()), "MonthEnd");
					GoalsControl.checkEmptyFields(String.valueOf(yearEnd.getItemCount()), " YearEnd");
					// Validates user inserted date

					// Begging of goal date validation

					
					int validDayBeggining = Integer.valueOf((String) dayBeggining.getSelectedItem());
					int validMonthBeggining = Integer.valueOf((String) monthBeggining.getSelectedItem());
					int validYearBeggining = Integer.valueOf((String) yearBeggining.getSelectedItem());

					GoalsControl.validateDate(validDayBeggining, validMonthBeggining, validYearBeggining);

					// End of goal date validation

					int validDayEnd = Integer.valueOf((String) dayEnd.getSelectedItem());
					int validMonthEnd = Integer.valueOf((String) monthEnd.getSelectedItem());
					int validYearEnd = Integer.valueOf((String) yearEnd.getSelectedItem());

					GoalsControl.validateDate(validDayEnd, validMonthEnd, validYearEnd);

					GoalsControl.validateDateInterval(validDayBeggining, validMonthBeggining, validYearBeggining,
							validDayEnd, validMonthEnd, validYearEnd);

					// Checks if an error is detected

					boolean detectError = GoalsControl.isDetectError();
					String error = GoalsControl.getError();
					if (detectError == true) {
						lblBlankField.setVisible(true);
						lblBlankField.setText("<html>"
								+ error.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
								+ "</html>");
					}
					else {
					    
						String stringValidDayBeggining = String.valueOf(validDayBeggining);
						String stringValidMonthBeggining = String.valueOf(validMonthBeggining);
						String stringValidYearBeggining = String.valueOf(validYearBeggining);
						
						while (stringValidDayBeggining.length() < 2) {
							stringValidDayBeggining= "0" + stringValidDayBeggining;
						}
						while (stringValidMonthBeggining.length() < 2) {
							stringValidMonthBeggining= "0" + stringValidMonthBeggining;
						}
						
						String BegginingDate = stringValidDayBeggining+stringValidMonthBeggining+stringValidYearBeggining;
						
						String stringValidDayEnd = String.valueOf(validDayEnd);
						String stringValidMonthEnd = String.valueOf(validMonthEnd);
						String stringValidYearEnd = String.valueOf(validYearEnd);
						
						while (stringValidDayEnd.length() < 2) {
							stringValidDayEnd= "0" + stringValidDayEnd;
						}
						while (stringValidMonthEnd.length() < 2) {
							stringValidMonthEnd= "0" + stringValidMonthEnd;
						}
						
						String EndDate = stringValidDayEnd+stringValidMonthEnd+stringValidYearEnd;
					

						GoalsControl.saveValues(typeGoalField,
								Float.parseFloat(formattedDesiredNumber.getText().replace(".", "")),
								Float.parseFloat(formattedConcludedNumber.getText().replace(".", "")), EndDate,
								BegginingDate);
						 lblSucess.setVisible(true);
					}
				} else {

					// Checks if all fields are filled

					boolean test1 = GoalsControl.checkEmptyFields(formattedDesiredNumber.getText(), "DesiredNumber");
					boolean test2 = GoalsControl.checkEmptyFields(formattedConcludedNumber.getText(),
							"ConcludedNumber");

					// Checks if desired number is smaller than concluded number
					if (test1 == false && test2 == false) {
						GoalsControl.validateDesiredConcluded(
								Float.valueOf(formattedDesiredNumber.getText().replace(".", "")),
								Float.valueOf(formattedConcludedNumber.getText().replace(".", "")));
					}

				

				// Checks if an error is detected
				boolean detectError = GoalsControl.isDetectError();
				String error = GoalsControl.getError();
				if (detectError == true) {
					lblBlankField.setVisible(true);
					lblBlankField.setText(
							"<html>" + error.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
									+ "</html>");
				}

				else {
					GoalsControl.saveValues(typeGoalField,
							Float.parseFloat(formattedDesiredNumber.getText().replace(".", "")),
							Float.parseFloat(formattedConcludedNumber.getText().replace(".", "")));
                    lblSucess.setVisible(true);
				}
			}}

		}

		);
		
				GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(lblTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxDefDates)
										.addComponent(lblDesiredNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblBeggining)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(103)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(formattedDesiredNumber, Alignment.LEADING)
											.addComponent(goalSelection, Alignment.LEADING, 0, 169, Short.MAX_VALUE))
										.addComponent(formattedConcludedNumber, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblSucess))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesiredNumber, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(formattedDesiredNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedConcludedNumber, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addComponent(chckbxDefDates)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeggining, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblSucess)
					.addGap(8)
					.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(saveButton)
					.addGap(44))
		);
		setLayout(groupLayout);

	}
}
