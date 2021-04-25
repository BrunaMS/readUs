package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class VisualizeGoals extends JPanel {
	ReadingGoalsController GoalsControl;
	
	/**
	 * Create the panel.
	 */
	public VisualizeGoals(ReadingGoalsController GoalsControl) {
		this.GoalsControl = GoalsControl;
		
		
		JLabel lblGoals= new JLabel("Metas");
		lblGoals.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JProgressBar goalProgressBar = new JProgressBar();
		goalProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		goalProgressBar.setForeground(Color.PINK);
		goalProgressBar.setStringPainted(true);
		goalProgressBar.setVisible(false);
		
		int numbGoals=GoalsControl.getNumbGoals();
		JLabel lblShowGoal = new JLabel("");
		JComboBox comboBoxSelectGoal = new JComboBox();
		comboBoxSelectGoal.addItem("Selecione");
		int numberGoals = GoalsControl.getNumbGoals();
		for (int counter = 1; counter<=numberGoals; counter++) {
			comboBoxSelectGoal.addItem("Metas" + counter);
		}
		
		comboBoxSelectGoal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				int index =comboBoxSelectGoal.getSelectedIndex()-1 ;
				
				
                 String showGoal = GoalsControl.getStringGoals(index);
			
				lblShowGoal.setText("<html>" + showGoal.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll("\n", "<br/>") + "</html>");
				
				
				
				
				
				goalProgressBar.setValue((int) (GoalsControl.getProgress(index)*100));
				goalProgressBar.setVisible(true);
			

				
			}
		});
		

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblGoals)
					.addGap(207))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblShowGoal, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goalProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(168))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(260)
					.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblGoals)
					.addGap(18)
					.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblShowGoal, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goalProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(61))))
		);
		setLayout(groupLayout);

	}
}
