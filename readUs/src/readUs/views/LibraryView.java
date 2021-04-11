package readUs.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class LibraryView extends JFrame {

	private JPanel contentPane;
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryView frame = new LibraryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibraryView() {
		initComponents();
	}
	
	
	public void initWishList() {
		wishlistButton.setEnabled(false);
		wishlistButton.setBackground(Color.WHITE);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
	}
	
	JLabel lblNewLabel; 
	JScrollPane scrollPane;
	JButton goalsButton;
	JButton libraryButton;
	JButton wishlistButton;
	JButton overviewButton;
	
	protected void initComponents() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 556);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		lblNewLabel = new JLabel("Minha Biblioteca");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		goalsButton = new JButton("Metas");
		goalsButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		goalsButton.setForeground(Color.BLACK);
		goalsButton.setBackground(Color.PINK);
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(goalsButton);
		
		libraryButton = new JButton("Biblioteca");
		libraryButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		libraryButton.setForeground(Color.BLACK);
		libraryButton.setEnabled(false);
		libraryButton.setBackground(Color.WHITE);
		panel.add(libraryButton);
		
		wishlistButton = new JButton("Lista de Desejos");
		wishlistButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		wishlistButton.setForeground(Color.BLACK);
		wishlistButton.setBackground(Color.PINK);
		panel.add(wishlistButton);
		
		overviewButton = new JButton("Visão Geral");
		overviewButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		overviewButton.setForeground(Color.BLACK);
		overviewButton.setBackground(Color.PINK);
		panel.add(overviewButton);
		contentPane.setLayout(gl_contentPane);
	}

}
