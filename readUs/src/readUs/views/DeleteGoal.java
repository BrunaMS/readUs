package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class DeleteGoal extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeleteGoal() {
		
		JLabel lblGoalSelection = new JLabel("Escolha a meta");
		
		JLabel lblDeletaMeta = new JLabel("Deletar Meta");
		lblDeletaMeta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JComboBox comboBoxChooseGoal = new JComboBox();
		
		JButton deleteButton = new JButton("Deletar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(lblDeletaMeta)
					.addContainerGap(174, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(180, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblGoalSelection)
					.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
					.addComponent(comboBoxChooseGoal, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeletaMeta)
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxChooseGoal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalSelection))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(deleteButton)
					.addGap(47))
		);
		setLayout(groupLayout);

	}

}
