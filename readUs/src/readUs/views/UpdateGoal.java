package readUs.views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals.goalType;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class UpdateGoal extends JPanel {
	private JTextField textFieldDesiredNumber;
	private JTextField textFieldConcludedNumber;
	/**
	 * Create the panel.
	 */
	public UpdateGoal() {
		boolean result=false;
		ReadingGoalsController GoalsControl= new ReadingGoalsController();
		
		//public boolean getResult() {
			//return result;
		//}
		
		JLabel lblTitle = new JLabel("Atualizar Meta");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JComboBox goalSelection = new JComboBox();
		
	
		goalSelection.addItem("Páginas");
		goalSelection.addItem("Livros");
		goalSelection.addItem("Capítulos");
		goalSelection.addItem("Palavras");
		
		
		

		
		
		JLabel lblGoalType = new JLabel("Tipo de objetivo");
		
		textFieldDesiredNumber = new JTextField();
		textFieldDesiredNumber.setColumns(10);
		
		JLabel lblDesiredNumber = new JLabel("N\u00FAmero Desejado");
		
		textFieldConcludedNumber = new JTextField();
		textFieldConcludedNumber.setColumns(10);
		
		JLabel lblConcludedNumber = new JLabel("N\u00FAmero Concluido");
		
		JButton saveButton = new JButton("Salvar");
		
		// Salvar as informações adicionadas pelo usuario
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String typeGoalfield = (String) goalSelection.getSelectedItem();
			
			switch(typeGoalfield) {
			case "Páginas":
				GoalsControl.addGoal(goalType.PAGES,Float.parseFloat(textFieldDesiredNumber.getText()), Float.parseFloat(textFieldConcludedNumber.getText()));
			case "Livros":
				GoalsControl.addGoal(goalType.BOOKS,Float.parseFloat(textFieldDesiredNumber.getText()), Float.parseFloat(textFieldConcludedNumber.getText()));
			case "Capítulos":
				GoalsControl.addGoal(goalType.CHAPTERS,Float.parseFloat(textFieldDesiredNumber.getText()), Float.parseFloat(textFieldConcludedNumber.getText()));
			case "Palavras":
				GoalsControl.addGoal(goalType.WORDS,Float.parseFloat(textFieldDesiredNumber.getText()), Float.parseFloat(textFieldConcludedNumber.getText()));
			}
	
			}
		});
		
	
		
	
	

		// Add combobox for the selection of the beggining and end of the goals
		
		
		JComboBox dayBeggining = new JComboBox();
		
		
		JComboBox monthBeggining = new JComboBox();
		
		
		
		JComboBox yearBeggining = new JComboBox();
		
	
		
		
		JLabel lblBeggining = new JLabel("In\u00EDcio");
		
		JLabel lblEnd = new JLabel("Fim");
		
		JComboBox dayEnd = new JComboBox();
		
		JComboBox monthEnd = new JComboBox();
	
		JComboBox yearEnd = new JComboBox();
		
		
		for (int days = 1; days <=31; days++) {
			
			  dayBeggining.addItem(String.valueOf(days));
			  dayEnd.addItem(String.valueOf(days));
			}
		
		for (int month= 1; month <=12; month++) {
			
			 monthBeggining.addItem(String.valueOf(month));
			 monthEnd.addItem(String.valueOf(month));
			}
		
		for (int year= 2000; year <=2030; year++) {
			
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
		chckbxDefDates.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxDefDates.isSelected()) {
						
						dayBeggining.setVisible(true);	
				        monthBeggining.setVisible(true);
				        yearBeggining.setVisible(true);
				        dayEnd.setVisible(true);
				        monthEnd.setVisible(true);
				        yearEnd.setVisible(true);
		         }
			    else {
				        dayBeggining.setVisible(false);	
				        monthBeggining.setVisible(false);
				        yearBeggining.setVisible(false);
				        dayEnd.setVisible(false);
				        monthEnd.setVisible(false);
				        yearEnd.setVisible(false);
				        
				}}}
		);
/*/
 * Validates data inserted by the user		
 */
		
		JLabel lblInvalideDate = new JLabel("Data inv\u00E1lida! Tente outro valor.");
		lblInvalideDate.setForeground(Color.RED);
		lblInvalideDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblInvalideDate.setVisible(false);
	/*
		public void dataValidation(int dayValidation, int monthValidation,  int yearValidation)
       {
			if(monthValidation == 4 || monthValidation == 6 ||  monthValidation == 9|| monthValidation == 11) {
				if (dayValidation == 31) {
					lblInvalideDate.setVisible(false);
				}
			else if(monthValidation == 2) {
				if ((yearValidation % 4 == 0 && yearValidation % 100 != 0) || (yearValidation % 400 == 0)) {
					if(dayValidation>29){
					lblInvalideDate.setVisible(true);
					}
				else{
				if(dayValidation>28){
					lblInvalideDate.setVisible(true);
				}
			}
			}
		}
		*/
		
		JLabel lblGoalSelection = new JLabel("Escolha a meta");
		
		JComboBox comboBoxChooseGoal = new JComboBox();
		
			
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(151)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInvalideDate)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblBeggining)
											.addGap(18)
											.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(chckbxDefDates)
										.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDesiredNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGoalSelection, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
									.addGap(22)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(12)
											.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(comboBoxChooseGoal, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldConcludedNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
												.addComponent(textFieldDesiredNumber, Alignment.LEADING, 124, 124, Short.MAX_VALUE)
												.addComponent(goalSelection, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxChooseGoal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalSelection, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDesiredNumber, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxDefDates))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDesiredNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldConcludedNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeggining, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblInvalideDate)
					.addGap(14)
					.addComponent(saveButton)
					.addGap(27))
		);
		setLayout(groupLayout);

	}

	private void dataValidation(JComboBox dayBeggining, JComboBox monthBeggining) {
		// TODO Auto-generated method stub
		
	}
}
