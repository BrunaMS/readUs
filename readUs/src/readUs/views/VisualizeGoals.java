package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import readUs.controller.ReadingGoalsController;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VisualizeGoals extends JPanel {
	ReadingGoalsController GoalsControl;
	/**
	 * Create the panel.
	 */
	public VisualizeGoals(ReadingGoalsController GoalsControl) {
		this.GoalsControl = GoalsControl;
		
		JLabel lblGoals= new JLabel("Metas");
		lblGoals.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		
		
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

				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblGoals)
					.addGap(207))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblShowGoal, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(260)
					.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblGoals)
					.addGap(18)
					.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblShowGoal, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
