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
	
	JPanel viewsPanel;
	JPanel buttonsPanel;
	
	private JPanel contentPane;
	private InitViews viewsInitializationControl;

	public MainView() {
		viewsInitializationControl = new InitViews();
		initComponents();
		this.setLocationRelativeTo(null);
	}
	
	private void initGoalFrame(){
		viewsInitializationControl.initGoalFrame(this, viewsPanel);
	}
	
	private void initLibraryFrame(){
		viewsInitializationControl.initLibraryFrame(this, viewsPanel);
	}
	
	private void initOverviewFrame(){
		viewsInitializationControl.initOverviewFrame(this, viewsPanel);
	}
	
	private void initWishlistFrame(){
		viewsInitializationControl.initWishlistFrame(this, viewsPanel);
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
		
		buttonsPanel = new JPanel();
		viewsPanel = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonsPanel, GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(viewsPanel, GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(viewsPanel, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonsPanel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
		);
		buttonsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		goalsButton = new JButton("Metas");
		goalsButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		goalsButton.setForeground(Color.BLACK);
		goalsButton.setBackground(Color.PINK);
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initGoalFrame();
			}
		});
		buttonsPanel.add(goalsButton);
		
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
		buttonsPanel.add(libraryButton);
		
		wishlistButton = new JButton("Lista de Desejos");
		wishlistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initWishlistFrame();
			}
		});
		wishlistButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		wishlistButton.setForeground(Color.BLACK);
		wishlistButton.setBackground(Color.PINK);
		buttonsPanel.add(wishlistButton);
		
		overviewButton = new JButton("Inicio");
		overviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initOverviewFrame();
			}
		});
		overviewButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		overviewButton.setForeground(Color.BLACK);
		overviewButton.setBackground(Color.PINK);
		buttonsPanel.add(overviewButton);
		contentPane.setLayout(gl_contentPane);
	}

	public void initWishList() {
		wishlistButton.setEnabled(false);
		wishlistButton.setBackground(Color.WHITE);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
		overviewButton.setEnabled(true);
		overviewButton.setBackground(Color.PINK);
		goalsButton.setEnabled(true);
		goalsButton.setBackground(Color.PINK);
	}

	public void initLibrary() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(Color.PINK);
		libraryButton.setEnabled(false);
		libraryButton.setBackground(Color.WHITE);
		overviewButton.setEnabled(true);
		overviewButton.setBackground(Color.PINK);
		goalsButton.setEnabled(true);
		goalsButton.setBackground(Color.PINK);
	}
	
	public void initGoals() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(Color.PINK);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
		overviewButton.setEnabled(true);
		overviewButton.setBackground(Color.PINK);
		goalsButton.setEnabled(false);
		goalsButton.setBackground(Color.WHITE);
	}
	
	public void initOverview() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(Color.PINK);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(Color.PINK);
		overviewButton.setEnabled(false);
		overviewButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		goalsButton.setBackground(Color.PINK);
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
