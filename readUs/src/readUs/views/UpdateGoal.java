package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals;

import java.awt.event.ItemListener;

import java.text.NumberFormat;

import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.text.NumberFormatter;

import java.awt.Color;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;

public class UpdateGoal extends JPanel {
	ReadingGoalsController GoalsControl;

	/**
	 * Updating panel
	 */
	public UpdateGoal(ReadingGoalsController GoalsControl) {
		this.GoalsControl = GoalsControl;
		boolean result = false;

		JLabel lblTitle = new JLabel("Alterar Meta");
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

			dayBeggining.addItem(String.valueOf(days));
			dayEnd.addItem(String.valueOf(days));
		}

		for (int month = 1; month <= 12; month++) {

			monthBeggining.addItem(String.valueOf(month));
			monthEnd.addItem(String.valueOf(month));
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

						String BegginingDate = String.valueOf(validDayBeggining) + String.valueOf(validMonthBeggining)
								+ String.valueOf(validYearBeggining);

						String EndDate = String.valueOf(validDayEnd) + String.valueOf(validMonthEnd)
								+ String.valueOf(validYearEnd);

						GoalsControl.saveValues(typeGoalField,
								Float.parseFloat(formattedDesiredNumber.getText().replace(".", "")),
								Float.parseFloat(formattedConcludedNumber.getText().replace(".", "")), EndDate,
								BegginingDate);

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

				}
			}

		}

		);

		JComboBox goalLibrarySelection = new JComboBox();
		goalLibrarySelection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int index;
				index = goalLibrarySelection.getSelectedIndex();
				if (index >= 0) {

					ReadingGoals goal = GoalsControl.getUserGoals()[index];

					switch (goal.getTypeGoal()) {

					case PAGES:
						goalSelection.setSelectedItem("Paginas");
						break;
					case BOOKS:
						goalSelection.setSelectedItem("Livros");
						break;
					case CHAPTERS:
						goalSelection.setSelectedItem("Capitulos");
						break;
					case WORDS:
						goalSelection.setSelectedItem("Palavras");
						break;

					}

					formattedDesiredNumber.setText(String.valueOf(goal.getDesiredNumber()));
					formattedConcludedNumber.setText(String.valueOf(goal.getConcludedNumber()));

					if (goal.getStartTimestamp() == null) {
						chckbxDefDates.setSelected(false);
					} else {
						chckbxDefDates.setSelected(true);
						Date date = new Date(goal.getStartTimestamp().getTime());
						System.out.println(date);

					}

				}
			}
		});

		goalLibrarySelection.setFont(new Font("Tahoma", Font.PLAIN, 14));

		int numberGoals = GoalsControl.getNumbGoals();

		for (int counter = 0; counter < numberGoals; counter++) {
			goalLibrarySelection.addItem("Meta " + (String.valueOf(counter + 1)));
			System.out.println("Meta");
		}

		JLabel lblEscolhaAMeta = new JLabel("Escolha a meta");
		lblEscolhaAMeta.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(202).addComponent(lblTitle))
								.addGroup(groupLayout.createSequentialGroup().addGap(58).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
												.createSequentialGroup().addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING).addComponent(
																chckbxDefDates)
														.addComponent(lblDesiredNumber, GroupLayout.PREFERRED_SIZE, 120,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblGoalType, GroupLayout.PREFERRED_SIZE, 120,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE,
																120, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblBeggining)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(10)
																.addComponent(monthBeggining,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(lblEscolhaAMeta, GroupLayout.PREFERRED_SIZE, 120,
																GroupLayout.PREFERRED_SIZE))
												.addGap(103)
												.addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(formattedDesiredNumber, Alignment.LEADING)
																.addComponent(
																		goalSelection, Alignment.LEADING, 0, 169,
																		Short.MAX_VALUE)
																.addComponent(goalLibrarySelection,
																		GroupLayout.PREFERRED_SIZE, 169,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(formattedConcludedNumber,
																GroupLayout.PREFERRED_SIZE, 169,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING)
														.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 481,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 25,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))))
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup().addGap(233).addComponent(saveButton,
										GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(51, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(18)
				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(10)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(goalLibrarySelection, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEscolhaAMeta, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesiredNumber, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(formattedDesiredNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(formattedConcludedNumber, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
				.addGap(16).addComponent(chckbxDefDates).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeggining, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(saveButton).addGap(44)));
		setLayout(groupLayout);

	}

	private void dataValidation(JComboBox dayBeggining, JComboBox monthBeggining) {
		// TODO Auto-generated method stub

	}
}