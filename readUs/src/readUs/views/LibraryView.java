package readUs.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class LibraryView extends JPanel {

	/**
	 * Create the frame.
	 */
	public LibraryView() {
		initComponents();
		this.setSize(500, 500);
		
		JLabel lblNewLabel = new JLabel("Biblioteca");
		
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
	}
}
