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
import javax.swing.SwingConstants;
/**
 * Interface para a visao geral dos objetivos
 * @author Beatriz Carolina
 * @version 1.0 (Abril 2021)
 *
 */
public class OverviewView extends JPanel {

	/**
	 * Cria o painel de visao geral 
	 */
	public OverviewView() {
		setBackground(Color.WHITE);
		initComponents();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OverviewView.class.getResource("/readUs/views/overview.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}