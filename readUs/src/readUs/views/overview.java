package readUs.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;

public class overview extends JFrame {

	private JPanel contentPane;
	private JTextField txtOsSeusLivros;
	private JTextField txtFaltamApeas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					overview frame = new overview();
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
	public overview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton overview = new JButton("Visão Geral");
		overview.setBackground(new Color(255, 255, 255));
		overview.setForeground(Color.BLACK);
		overview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		overview.setBounds(10, 424, 251, 49);
		panel.add(overview);
		
		JButton btnNewButton_1_1_1 = new JButton("Biblioteca");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(271, 424, 265, 49);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Lista de Desejos");
		btnNewButton_1_1_1_1.setBounds(546, 424, 265, 49);
		panel.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Metas");
		btnNewButton_1_1_1_1_1.setBounds(821, 424, 265, 49);
		panel.add(btnNewButton_1_1_1_1_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(183, 236, 726, 20);
		panel.add(progressBar);
		
		txtOsSeusLivros = new JTextField();
		txtOsSeusLivros.setFont(new Font("Helvetica Light", Font.PLAIN, 16));
		txtOsSeusLivros.setText("Os seus livros est\u00E3o te esperando");
		txtOsSeusLivros.setBackground(Color.WHITE);
		txtOsSeusLivros.setBounds(183, 197, 726, 20);
		panel.add(txtOsSeusLivros);
		txtOsSeusLivros.setColumns(10);
		
		txtFaltamApeas = new JTextField();
		txtFaltamApeas.setFont(new Font("Montserrat", Font.PLAIN, 16));
		txtFaltamApeas.setText("Faltam  apenas XX p\u00E1ginas para concluir o seu objetivo!");
		txtFaltamApeas.setBounds(183, 284, 735, 52);
		panel.add(txtFaltamApeas);
		txtFaltamApeas.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon image = new ImageIcon(getClass().getResource("/imagem/Read Us.jpg")); 
		JLabel label = new JLabel(image);
		lblNewLabel.setBounds(46, 48, 96, 148);
		panel.add(lblNewLabel);
	}
}
