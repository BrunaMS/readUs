package readUs.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class WishlistView extends JPanel {

	/**
	 * Create the panel.
	 */
	public WishlistView() {
		this.setSize(500, 500);
		
		JLabel lblNewLabel = new JLabel("Lista de Desejos");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(466)
					.addComponent(lblNewLabel)
					.addContainerGap(488, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(lblNewLabel)
					.addContainerGap(345, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
