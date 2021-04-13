package readUs.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class OverviewView extends JPanel {

	/**
	 * Create the panel.
	 */
	public OverviewView() {
		initComponents();
		this.setSize(500, 500);
		
		JLabel lblNewLabel = new JLabel("Visão Geral");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(392)
					.addComponent(lblNewLabel)
					.addContainerGap(562, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(314)
					.addComponent(lblNewLabel)
					.addContainerGap(377, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

}
