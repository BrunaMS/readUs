package readUs.views;
import readUs.controller.InitViews;

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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

/**
 * View usada como padrão para o desenvolvimento de toda a interface com o usuário, definindo 
 * o padrão de botões e ações realizadas em comum entre todas a demais.
 * 
 * @author Bruna Medeiros
 * @version 1.0 (Abr 2021)
 */
public class MainView extends JFrame {
	JButton goalsButton;
	JButton libraryButton;
	JButton wishlistButton;
	JButton overviewButton;
	
	JPanel viewsPanel;
	JPanel buttonsPanel;
	
	private JPanel contentPane;
	private InitViews viewsInitializationControl;

	/**
	 * Inicializa componentes da interface e define ações a serem tomadas caso um dos botões disponíveis seja pressionado.
	 */
	public MainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/readUs/views/Read Us.png")));
		viewsInitializationControl = new InitViews();
		initComponents();
		this.setLocationRelativeTo(null);
		viewsInitializationControl.initOverviewFrame(this, viewsPanel);
	}
	
	/**
	 * Inicializa JFrame com dados das metas de usuário e ações disponíveis para serem executadas.
	 */
	private void initGoalFrame(){
		viewsInitializationControl.initGoalFrame(this, viewsPanel);
	}
	
	/**
	 * Inicializa JFrame com dados da biblioteca e ações disponíveis para serem executadas em seus itens.
	 */
	private void initLibraryFrame(){
		viewsInitializationControl.initLibraryFrame(this, viewsPanel);
	}
	
	/**
	 * Inicializa JFrame com dados gerais sobre o usuário.
	 */
	private void initOverviewFrame(){
		viewsInitializationControl.initOverviewFrame(this, viewsPanel);
	}
	
	/**
	 * Inicializa JFrame com dados da lista de desejos e ações disponíveis para serem executadas em seus itens.
	 */
	private void initWishlistFrame(){
		viewsInitializationControl.initWishlistFrame(this, viewsPanel);
	}
	
	/**
	 * Define itens ativados ou desativados quando o botão de metas é pressionado.
	 */
	public void onGoalsView() {
		goalsButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(false);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(true);
	}

	/**
	 * Define itens ativados ou desativados quando o botão de bibliotecas é pressionado.
	 */
	public void onLibraryView() {
		libraryButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(false);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(true);
	}
	
	/**
	 * Define itens ativados ou desativados quando o botão de lista de desejos é pressionado.
	 */
	public void onWishlistView() {
		wishlistButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(false);
		overviewButton.setEnabled(true);
	}

	/**
	 * Define itens ativados ou desativados quando o botão de visao geral é pressionado.
	 */
	public void onOverviewView() {
		overviewButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		libraryButton.setEnabled(true);
		wishlistButton.setEnabled(true);
		overviewButton.setEnabled(false);
	}
	
	/**
	 * Inicializa todos os componentes do JFrame principal.
	 */
	private void initComponents() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		buttonsPanel = new JPanel();
		viewsPanel = new JPanel();
		viewsPanel.setBackground(Color.WHITE);

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
		GridBagLayout gbl_viewsPanel = new GridBagLayout();
		gbl_viewsPanel.columnWidths = new int[]{0};
		gbl_viewsPanel.rowHeights = new int[]{0};
		gbl_viewsPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_viewsPanel.rowWeights = new double[]{Double.MIN_VALUE};
		viewsPanel.setLayout(gbl_viewsPanel);
		buttonsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		libraryButton = new JButton("Biblioteca");
		libraryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initLibraryFrame();
			}
		});
		
		overviewButton = new JButton("Inicio");
		overviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initOverviewFrame();
			}
		});
		overviewButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		overviewButton.setForeground(Color.BLACK);
		overviewButton.setBackground(new Color(0, 255, 127));
		buttonsPanel.add(overviewButton);
		libraryButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		libraryButton.setForeground(Color.BLACK);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(new Color(0, 255, 127));
		buttonsPanel.add(libraryButton);
		
		wishlistButton = new JButton("Lista de Desejos");
		wishlistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initWishlistFrame();
			}
		});
		wishlistButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		wishlistButton.setForeground(Color.BLACK);
		wishlistButton.setBackground(new Color(0, 255, 127));
		buttonsPanel.add(wishlistButton);
		
		goalsButton = new JButton("Metas");
		goalsButton.setFont(new Font("L M Mono Lt10", Font.BOLD, 20));
		goalsButton.setForeground(Color.BLACK);
		goalsButton.setBackground(new Color(0, 255, 127));
		goalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initGoalFrame();
			}
		});
		buttonsPanel.add(goalsButton);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Seta formato dos botões ao iniciar a lista de desejos.
	 */
	public void initWishList() {
		wishlistButton.setEnabled(false);
		wishlistButton.setBackground(Color.WHITE);
		libraryButton.setEnabled(true);
		libraryButton.setBackground(new Color(0, 255, 127));
		overviewButton.setEnabled(true);
		overviewButton.setBackground(new Color(0, 255, 127));
		goalsButton.setEnabled(true);
		goalsButton.setBackground(new Color(0, 255, 127));
	}

	/**
	 * Seta formato dos botões ao iniciar a biblioteca.
	 */
	public void initLibrary() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(new Color(0, 255, 127));
		libraryButton.setEnabled(false);
		libraryButton.setBackground(Color.WHITE);
		overviewButton.setEnabled(true);
		overviewButton.setBackground(new Color(0, 255, 127));
		goalsButton.setEnabled(true);
		goalsButton.setBackground(new Color(0, 255, 127));
	}
	
	/**
	 * Seta formato dos botões ao iniciar as metas.
	 */
	public void initGoals() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(new Color(0, 255, 127));
		libraryButton.setEnabled(true);
		libraryButton.setBackground(new Color(0, 255, 127));
		overviewButton.setEnabled(true);
		overviewButton.setBackground(new Color(0, 255, 127));
		goalsButton.setEnabled(false);
		goalsButton.setBackground(Color.WHITE);
	}
	
	/**
	 * Seta formato dos botões ao iniciar visão geral.
	 */
	public void initOverview() {
		wishlistButton.setEnabled(true);
		wishlistButton.setBackground(new Color(0, 255, 127));
		libraryButton.setEnabled(true);
		libraryButton.setBackground(new Color(0, 255, 127));
		overviewButton.setEnabled(false);
		overviewButton.setBackground(Color.WHITE);
		goalsButton.setEnabled(true);
		goalsButton.setBackground(new Color(0, 255, 127));
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
