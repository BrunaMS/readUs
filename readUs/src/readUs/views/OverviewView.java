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
import javax.swing.LayoutStyle.ComponentPlacement;

public class OverviewView extends JPanel {

	/**
	 * Create the panel.
	 */
	public OverviewView() {
		initComponents();
		this.setSize(500, 500);
		
		JLabel lblITitle = new JLabel("In\u00EDcio");
		lblITitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblQuote = new JLabel("Os seus livros est\u00E3o te esperando ...");
		lblQuote.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(204)
					.addComponent(lblITitle, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addComponent(lblQuote, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblITitle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(112)
					.addComponent(lblQuote, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(311, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

}