package readUs.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import readUs.controller.InitViews;

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

public class MainView extends JFrame {

	private JPanel contentPane;
	private InitViews viewsInitializationControl;

	public MainView() {
		viewsInitializationControl = new InitViews();
		initComponents();
	}
	
	private void initGoalFrame(){
		viewsInitializationControl.initGoalFrame(this);
	}
	
	private void initLibraryFrame(){
		viewsInitializationControl.initLibraryFrame(this);
	}
	
	private void initOverviewFrame(){
		viewsInitializationControl.initOverviewFrame(this);
	}
	
	private void initWishlistFrame(){
		viewsInitializationControl.initWishlistFrame(this);
	}
	
	private void initComponents() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 556);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblBemvindoa = new JLabel("Bem-vindo(a)!");
		lblBemvindoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindoa.setFont(new Font("URW Bookman L", Font.BOLD, 40));
		lblBemvindoa.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("O que deseja fazer hoje?");
		lblNewLabel.setFont(new Font("URW Bookman L", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1131, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblBemvindoa, GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1118, GroupLayout.PREFERRED_SIZE)
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblBemvindoa)
					.addGap(3)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton goalsButton = new JButton("Metas");
		goalsButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		goalsButton.setForeground(Color.BLACK);
		goalsButton.setBackground(Color.PINK);
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(goalsButton);
		
		JButton libraryButton = new JButton("Biblioteca");
		libraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		libraryButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		libraryButton.setForeground(Color.BLACK);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
		panel.add(libraryButton);
		
		JButton wishlistButton = new JButton("Lista de Desejos");
		wishlistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		wishlistButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		wishlistButton.setForeground(Color.BLACK);
		wishlistButton.setBackground(Color.PINK);
		panel.add(wishlistButton);
		
		JButton overviewButton = new JButton("Visão Geral");
		overviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		overviewButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		overviewButton.setForeground(Color.BLACK);
		overviewButton.setBackground(Color.PINK);
		panel.add(overviewButton);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
