package readUs.views;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GoalsView extends JPanel {

	/**
	 * Create the panel.
	 */
	public GoalsView() {
		initComponents();
		this.setSize(500, 500);
		
		JLabel lblNewLabel = new JLabel("Metas");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(392)
					.addComponent(lblNewLabel)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(323)
					.addComponent(lblNewLabel)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
