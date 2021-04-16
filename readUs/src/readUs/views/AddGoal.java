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
import readUs.model.ReadingGoals.goalType;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGoal extends JPanel {
	private JTextField textFieldDesiredNumber;
	private JTextField textFieldConcludedNumber;

	/**
	 * Criacao do painel para a adição de novas metas
	 */
	public AddGoal() {
		
		boolean result=false;
		ReadingGoalsController GoalsControl= new ReadingGoalsController();
		
		//public boolean getResult() {
			//return result;
		//}
		
		JLabel lblTitle = new JLabel("Nova Meta");
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
		
	
		
	
	

		
		
		JComboBox dayBeggining = new JComboBox();
		
		
		
		JComboBox monthBeggining = new JComboBox();
		
		
		
		JComboBox yearBeggining = new JComboBox();
		
		
		
		JLabel lblBeggining = new JLabel("In\u00EDcio");
		
		JLabel lblEnd = new JLabel("Fim");
		
		JComboBox dayEnd = new JComboBox();
		
		
		
		JComboBox monthEnd = new JComboBox();
		
		
		
		JComboBox yearEnd = new JComboBox();
		
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
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxDefDates)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDesiredNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblBeggining)
										.addGap(18)
										.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(63, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(120)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldDesiredNumber, 124, 124, 124)
										.addComponent(goalSelection, 0, 124, Short.MAX_VALUE)
										.addComponent(textFieldConcludedNumber, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
									.addGap(58))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goalSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesiredNumber, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(textFieldDesiredNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblConcludedNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(chckbxDefDates))
						.addComponent(textFieldConcludedNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBeggining, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearBeggining, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(saveButton)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
