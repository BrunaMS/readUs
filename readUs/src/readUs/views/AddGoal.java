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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals.goalType;

import java.awt.event.ItemListener;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;

public class AddGoal extends JPanel {
	private JTextField textFieldDesiredNumber;
	private JTextField textFieldConcludedNumber;

	/**
	 * Criacao do painel para a adição de novas metas
	 */
	public AddGoal() {

		boolean result = false;
		ReadingGoalsController GoalsControl = new ReadingGoalsController();

		// public boolean getResult() {
		// return result;
		// }

		JLabel lblTitle = new JLabel("Nova Meta");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 31));

		JComboBox goalSelection = new JComboBox();
		goalSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));

		goalSelection.addItem("Páginas");
		goalSelection.addItem("Livros");
		goalSelection.addItem("Capítulos");
		goalSelection.addItem("Palavras");

		JLabel lblGoalType = new JLabel("Tipo de objetivo");
		lblGoalType.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textFieldDesiredNumber = new JTextField();
		textFieldDesiredNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDesiredNumber.setColumns(10);

		JLabel lblDesiredNumber = new JLabel("N\u00FAmero Desejado");
		lblDesiredNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textFieldConcludedNumber = new JTextField();
		textFieldConcludedNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldConcludedNumber.setColumns(10);

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

		// public void dateValidation(int day, int month, int year) {

		// }
		// }
		// }

		JLabel lblBlankField = new JLabel("0");
		lblBlankField.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBlankField.setForeground(new Color(255, 0, 0));

		lblBlankField.setVisible(false);

		JButton saveButton = new JButton("Salvar");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// Save and validate user data

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String typeGoalfield = (String) goalSelection.getSelectedItem();
				lblBlankField.setVisible(false);
				boolean detectError = false;
				String error = "Erros:\n";

				if (chckbxDefDates.isSelected()) {
					if (textFieldDesiredNumber.getText().isEmpty()) {

						error = error
								+ "O campo numero desejado não pode ser deixado vazio. Por favor insira um número.\n";
						detectError = true;
					}
					if (textFieldConcludedNumber.getText().isEmpty()) {

						error = error
								+ "O campo numero concluido não pode ser deixado vazio. Por favor insira um número.\n";
						detectError = true;
					}
					if (dayBeggining.getItemCount() == 0) {

						error = error + "O campo dia do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}
					if (monthBeggining.getItemCount() == 0) {

						error = error + "O campo mes do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}
					if (yearBeggining.getItemCount() == 0) {

						error = error + "O campo ano do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}
					if (dayEnd.getItemCount() == 0) {

						error = error + "O campo dia do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}
					if (monthEnd.getItemCount() == 0) {

						error = error + "O campo mes do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}
					if (yearEnd.getItemCount() == 0) {

						error = error + "O campo ano do inicio pode ser deixado vazio. Por favor escolha uma opção.\n";
						detectError = true;
					}

					// Validates user inserted date

					// Begging of goal date

					if (Integer.valueOf((String) monthBeggining.getSelectedItem()) == 4
							|| Integer.valueOf((String) monthBeggining.getSelectedItem()) == 6
							|| Integer.valueOf((String) monthBeggining.getSelectedItem()) == 9
							|| Integer.valueOf((String) monthBeggining.getSelectedItem()) == 11) {
						if (Integer.valueOf((String) dayBeggining.getSelectedItem()) == 31) {
							error = error + "Data inválida. Cheque a data e tente novamente.\n";
							detectError = true;
						}
					}

					else if (Integer.valueOf((String) monthBeggining.getSelectedItem()) == 2) {
						if ((Integer.valueOf((String) yearBeggining.getSelectedItem()) % 4 == 0
								&& Integer.valueOf((String) yearBeggining.getSelectedItem()) % 100 != 0)
								|| (Integer.valueOf((String) yearBeggining.getSelectedItem()) % 400 == 0)) {
							if (Integer.valueOf((String) dayBeggining.getSelectedItem()) > 29) {
								error = error + "Data inválida. Cheque a data e tente novamente.\n";
								detectError = true;
							} else {
								if (Integer.valueOf((String) dayBeggining.getSelectedItem()) > 28) {
									error = error + "Data inválida. Cheque a data e tente novamente.\n";
									detectError = true;
								}
							}
						}
					}

					// End of goal date

					if (Integer.valueOf((String) monthEnd.getSelectedItem()) == 4
							|| Integer.valueOf((String) monthEnd.getSelectedItem()) == 6
							|| Integer.valueOf((String) monthEnd.getSelectedItem()) == 9
							|| Integer.valueOf((String) monthEnd.getSelectedItem()) == 11) {
						if (Integer.valueOf((String) dayEnd.getSelectedItem()) == 31) {
							error = error + "Data inválida. Cheque a data e tente novamente.\n";
							detectError = true;
						}
					} else if (Integer.valueOf((String) monthEnd.getSelectedItem()) == 2) {
						if ((Integer.valueOf((String) yearEnd.getSelectedItem()) % 4 == 0
								&& Integer.valueOf((String) yearEnd.getSelectedItem()) % 100 != 0)
								|| (Integer.valueOf((String) yearEnd.getSelectedItem()) % 400 == 0)) {
							if (Integer.valueOf((String) dayEnd.getSelectedItem()) > 29) {
								error = error + "Data inválida. Cheque a data e tente novamente.\n";
								detectError = true;
							}
						} else {
							if (Integer.valueOf((String) dayEnd.getSelectedItem()) > 28) {
								error = error + "Data inválida. Cheque a data e tente novamente.\n";
								detectError = true;
							}
						}
					}
					/*if (Integer.parseInt(textFieldDesiredNumber.getText()) > Integer.parseInt(textFieldConcludedNumber.getText())) {
						error = error
								+ "O número concluido não pode ser maior que o desejado. Por favor confira seus valores.\n";
						detectError = true;
					}*/
				} else {

					if (textFieldDesiredNumber.getText().isEmpty()) {

						error = error
								+ "O campo numero desejado não pode ser deixado vazio. Por favor insira um número.\n";
						detectError = true;
					}
					if (textFieldConcludedNumber.getText().isEmpty()) {

						error = error
								+ "O campo numero concluido não pode ser deixado vazio. Por favor insira um número.\n";
						detectError = true;

					}
					/*if (Integer.parseInt(textFieldDesiredNumber.getText()) > Integer.parseInt(textFieldConcludedNumber.getText())) {
					error = error
							+ "O número concluido não pode ser maior que o desejado. Por favor confira seus valores.\n";
					detectError = true;
				}*/
				}

				if (detectError = true) {
					lblBlankField.setVisible(true);

					lblBlankField.setText(
							"<html>" + error.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
									+ "</html>");
				}

				else {
					switch (typeGoalfield) {
					case "Páginas":
						GoalsControl.addGoal(goalType.PAGES, Float.parseFloat(textFieldDesiredNumber.getText()),
								Float.parseFloat(textFieldConcludedNumber.getText()));
					case "Livros":
						GoalsControl.addGoal(goalType.BOOKS, Float.parseFloat(textFieldDesiredNumber.getText()),
								Float.parseFloat(textFieldConcludedNumber.getText()));
					case "Capítulos":
						GoalsControl.addGoal(goalType.CHAPTERS, Float.parseFloat(textFieldDesiredNumber.getText()),
								Float.parseFloat(textFieldConcludedNumber.getText()));
					case "Palavras":
						GoalsControl.addGoal(goalType.WORDS, Float.parseFloat(textFieldDesiredNumber.getText()),
								Float.parseFloat(textFieldConcludedNumber.getText()));
					}

				}
			}

		}

		);
		
		MaskFormatter maskinteiro = null;
		try {
			maskinteiro = new MaskFormatter("######");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(202)
									.addComponent(lblTitle))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(58)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
											.addGap(21))
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
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldConcludedNumber, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
												.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldDesiredNumber, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))))
							.addGap(3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDesiredNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesiredNumber, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldConcludedNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBlankField, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(saveButton)
					.addGap(44))
		);
		setLayout(groupLayout);

	}

	private void dataValidation(JComboBox dayBeggining, JComboBox monthBeggining) {
		// TODO Auto-generated method stub

	}
}
