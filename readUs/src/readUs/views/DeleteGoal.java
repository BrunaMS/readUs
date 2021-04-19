package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.Color;

public class DeleteGoal extends JPanel {
	ReadingGoalsController GoalsControl;

	/**
	 * Create the panel.
	 */
	int numberGoals;
	public DeleteGoal(ReadingGoalsController GoalsControl) {
		
		this.GoalsControl = GoalsControl;
		numberGoals= GoalsControl.getNumbGoals();
		
		JLabel lblGoalSelection = new JLabel("Escolha a meta");
		lblGoalSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDeleteGoal = new JLabel("Deletar Meta");
		lblDeleteGoal.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JButton deleteButton = new JButton("Deletar");

		JLabel lblGoalTitle = new JLabel("Meta");
		lblGoalTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGoalTitle.setVisible(false);

		JLabel lblGoalData = new JLabel("Ler");
		lblGoalData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGoalData.setVisible(false);

		JComboBox comboBoxChooseGoal = new JComboBox();

		
		comboBoxChooseGoal.addItem("Selecione");
		for (int counter = 0; counter < numberGoals; counter++) {
			comboBoxChooseGoal.addItem("Meta " + (String.valueOf(counter+1)));
		}
		
		
		comboBoxChooseGoal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int index; 
				index = (comboBoxChooseGoal.getSelectedIndex());
				if (index > 0) {

					ReadingGoals goal = GoalsControl.getUserGoals()[index];

					lblGoalTitle.setText("Meta " + (index+1));
					lblGoalTitle.setVisible(true);

					// Case of goal w/ fixed time period

					if (goal.getStartTimestamp() == null) {
						switch (goal.getTypeGoal()) {

						case PAGES:
							String pagesNoDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " paginas	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n";
							lblGoalData.setText("<html>" + pagesNoDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);
							break;
						case BOOKS:
							String booksNoDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber()) + " livros	"
									+ "Concluidas:" + String.valueOf((int) goal.getConcludedNumber()) + "\n";
							lblGoalData.setText("<html>" + booksNoDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);
							break;
						case CHAPTERS:

							String chptrNoDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " capitulos	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n";
							lblGoalData.setText("<html>" + chptrNoDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);

							break;
						case WORDS:
							String wordsNoDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " palavras	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n";
							lblGoalData.setText("<html>" + wordsNoDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);
							break;

						}

					} else {

						// Beginning date of the goal
						Calendar cal = Calendar.getInstance();
						cal.setTime(goal.getStartTimestamp());
						// End date of the goal
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(goal.getEndTimestamp());

						switch (goal.getTypeGoal()) {

						case PAGES:
							String pagesWDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " paginas\n	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n" + "Período:" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(cal.get(Calendar.YEAR)) + "ate"
									+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(calendar.get(Calendar.YEAR));
							lblGoalData.setText("<html>" + pagesWDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);

							break;
						case BOOKS:
							String booksWDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " livros\n	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n" + "Período:" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(cal.get(Calendar.YEAR)) + "ate"
									+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH) - 1) + "/"
									+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(calendar.get(Calendar.YEAR));
							lblGoalData.setText("<html>" + booksWDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);

							break;
						case CHAPTERS:
							String chptrWDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " capitulos\n	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n" + "Período:" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(cal.get(Calendar.MONTH)) + "/"
									+ String.valueOf(cal.get(Calendar.YEAR)) + "ate"
									+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(calendar.get(Calendar.YEAR));
							lblGoalData.setText("<html>" + chptrWDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);

							break;
						case WORDS:
							String wordsWDate = "Ler: " + String.valueOf((int) goal.getDesiredNumber())
									+ " palavras\n	" + "Concluidas:" + String.valueOf((int) goal.getConcludedNumber())
									+ "\n" + "Período:" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(cal.get(Calendar.YEAR)) + "ate"
									+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "/"
									+ String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
									+ String.valueOf(calendar.get(Calendar.YEAR));
							lblGoalData.setText("<html>" + wordsWDate.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
									.replaceAll("\n", "<br/>") + "</html>");
							lblGoalData.setVisible(true);

							break;

						}

					}

				}
				deleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						GoalsControl.removeGoal(index);
						lblGoalData.setText(null);
						lblGoalData.setVisible(false);
						comboBoxChooseGoal.removeAllItems();
						comboBoxChooseGoal.addItem("Selecione");
						numberGoals=GoalsControl.getNumbGoals();
						for (int counter = 0; counter < numberGoals; counter++) {
							comboBoxChooseGoal.addItem("Meta " + (String.valueOf(counter + 1)));
						}
						comboBoxChooseGoal.setSelectedIndex(0);
						
						
					}
				});
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(53).addComponent(lblGoalSelection)
								.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
								.addComponent(comboBoxChooseGoal, GroupLayout.PREFERRED_SIZE, 124,
										GroupLayout.PREFERRED_SIZE)
								.addGap(71))
						.addGroup(groupLayout.createSequentialGroup().addGap(220).addComponent(lblDeleteGoal)
								.addContainerGap(262, Short.MAX_VALUE))
						.addGroup(groupLayout
								.createSequentialGroup().addGap(240).addComponent(lblGoalTitle)
								.addContainerGap(339, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(90)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGoalData, GroupLayout.PREFERRED_SIZE, 264,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(254, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(lblDeleteGoal).addGap(68)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblGoalSelection)
								.addComponent(comboBoxChooseGoal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(26).addComponent(lblGoalTitle).addGap(30).addComponent(lblGoalData)
						.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE).addComponent(deleteButton)
						.addGap(48)));
		setLayout(groupLayout);

	}
}
