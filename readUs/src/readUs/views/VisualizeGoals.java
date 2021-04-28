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
/**
 * Interface para a atualiza��o dos objetivos.
 * @author Beatriz Carolina
 * @version 1.0 (Abril 2021)
 *
 */
public class VisualizeGoals extends JPanel {
	ReadingGoalsController GoalsControl;
	
	
	/**
	 *  Painel para a atualizacao dos objetivos
	 */
	JLabel lblGoals= new JLabel("Metas");
	JProgressBar goalProgressBar = new JProgressBar();
	 
	public VisualizeGoals(ReadingGoalsController GoalsControl) {
		setBackground(new Color(255, 255, 255));
		this.GoalsControl = GoalsControl;
		
		
		
		lblGoals.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		
		goalProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		goalProgressBar.setForeground(new Color(0, 255, 127));
		goalProgressBar.setStringPainted(true);
		goalProgressBar.setVisible(false);
		
		int numbGoals=GoalsControl.getNumbGoals();
		JLabel lblShowGoal = new JLabel("");
		JComboBox comboBoxSelectGoal = new JComboBox();
		comboBoxSelectGoal.setBackground(Color.LIGHT_GRAY);
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
		
		JLabel lblGoalSelection = new JLabel("Escolha a meta");
		lblGoalSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(lblGoalSelection, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(goalProgressBar, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(lblShowGoal, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(185)
					.addComponent(lblGoals)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGoals)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSelectGoal, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGoalSelection, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblShowGoal, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(goalProgressBar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
