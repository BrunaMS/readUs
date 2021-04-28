package readUs.views;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.border.EmptyBorder;

import readUs.controller.ReadingGoalsController;
import readUs.model.ReadingGoals;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Interface para o CRUD dos objetivos.
 * @author Beatriz Carolina
 * @version 1.0 (Abril 2021)
 *
 */
public class GoalsView extends JPanel {

	
	ReadingGoalsController GoalsControl = new ReadingGoalsController();

	public ReadingGoalsController getGoalsControl() {
		return GoalsControl;
	}
	/**
	 * Painel para o  CRUD dos objetivos
	 */
	public GoalsView() {
		setBackground(Color.WHITE);
		initComponents();
//		this.setSize(500, 500);

		JButton btnCreateNewGoal = new JButton("Criar nova meta");
		btnCreateNewGoal.setBackground(Color.LIGHT_GRAY);
		btnCreateNewGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGoal newGoal = new AddGoal(GoalsControl);
				newGoal.setVisible(true);
				JFrame newWindow = new JFrame();
				newWindow.getContentPane().add(newGoal);
				newWindow.setVisible(true);
				newWindow.setBounds(100, 100, 600, 500);
				newWindow.setLocationRelativeTo(null);

			}
		});

		JButton btnSeeGoals = new JButton("Visualizar metas");
		btnSeeGoals.setBackground(Color.LIGHT_GRAY);
		btnSeeGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizeGoals visualizeGoal = new VisualizeGoals(GoalsControl);
				visualizeGoal.setVisible(true);
				JFrame newWindow = new JFrame();
				newWindow.getContentPane().add(visualizeGoal);
				newWindow.setVisible(true);
				newWindow.setBounds(100, 100, 600, 500);
				newWindow.setLocationRelativeTo(null);
			}
		});

		JButton btnUpdateGoals = new JButton("Atualizar meta");
		btnUpdateGoals.setBackground(Color.LIGHT_GRAY);
		btnUpdateGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateGoal updatedGoal = new UpdateGoal(GoalsControl);
				updatedGoal.setVisible(true);
				JFrame newWindow = new JFrame();
				newWindow.getContentPane().add(updatedGoal);
				newWindow.setVisible(true);
				newWindow.setBounds(100, 100, 600, 500);
				newWindow.setLocationRelativeTo(null);
			}
		});

		JButton btnDeleteGoals = new JButton("Deletar meta");
		btnDeleteGoals.setBackground(Color.LIGHT_GRAY);
		btnDeleteGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteGoalView deleteGoal = new DeleteGoalView(GoalsControl);
				deleteGoal.setVisible(true);
				JFrame newWindow = new JFrame();
				newWindow.getContentPane().add(deleteGoal);
				newWindow.setVisible(true);
				newWindow.setBounds(100, 100, 600, 500);
				newWindow.setLocationRelativeTo(null);
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(195)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCreateNewGoal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnSeeGoals, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnUpdateGoals, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnDeleteGoals, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addGap(178))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(82, Short.MAX_VALUE)
					.addComponent(btnCreateNewGoal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSeeGoals, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnUpdateGoals, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDeleteGoals, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		setLayout(groupLayout);
	}

	private void initComponents() {
		// TODO Auto-generated method stub

	}
}