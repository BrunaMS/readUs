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
	JButton goalsButton;
	JButton libraryButton;
	JButton wishlistButton;
	JButton overviewButton;
	
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
	
	public void onGoalsView() {
		goalsButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(false);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(true);
	}
	
	public void onLibraryView() {
		libraryButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(false);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(true);
	}
	
	public void onWishlistView() {
		wishlistButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(false);
		overviewButton.setEnabled(true);
	}
	
	public void onOverviewView() {
		overviewButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(false);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(454, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		goalsButton = new JButton("Metas");
		goalsButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		goalsButton.setForeground(Color.BLACK);
		goalsButton.setBackground(Color.PINK);
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initGoalFrame();
			}
		});
		panel.add(goalsButton);
		
		libraryButton = new JButton("Biblioteca");
		libraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initLibraryFrame();
			}
		});
		libraryButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		libraryButton.setForeground(Color.BLACK);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
		panel.add(libraryButton);
		
		wishlistButton = new JButton("Lista de Desejos");
		wishlistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initWishlistFrame();
			}
		});
		wishlistButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		wishlistButton.setForeground(Color.BLACK);
		wishlistButton.setBackground(Color.PINK);
		panel.add(wishlistButton);
		
		overviewButton = new JButton("Visão Geral");
		overviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initOverviewFrame();
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
