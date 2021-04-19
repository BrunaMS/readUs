package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import readUs.controller.ReadingGoalsController;

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
	
		
		JScrollBar scrollBar = new JScrollBar();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblGoals)
					.addGap(169)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblGoals)
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		setLayout(groupLayout);

	}

}
