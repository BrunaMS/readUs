package readUs.views;
import readUs.controller.LibraryController;
import readUs.model.Collection.sortType;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListBooksView extends JFrame {

	private JPanel contentPane;
	private JLabel booksList = new JLabel("BooksList");
	private LibraryController libControl;
	
	String[] strBooksName;
	int qntBooks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListBooksView frame = new ListBooksView(new LibraryController());
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
	public ListBooksView(LibraryController libController){
		this.libControl = libController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 387);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libControl.setSort(comboBox.getSelectedIndex());
				updateList();
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome (A-Z)", "Nome (Z-A)", "Ano de Lançamento", "Número de páginas", "Progresso"}));
		
		
		JLabel lblNewLabel = new JLabel("Ordenar por:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addContainerGap())
		);
		scrollPane.setViewportView(booksList);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void showBooks(){
		libControl.setSort(sortType.NAME_A_Z);
		updateList();
	}
	
	private void updateList(){
		this.strBooksName = libControl.getAllBooksName();
		qntBooks = libControl.getQntBooks();
		if(qntBooks == 0) {
			booksList.setForeground(Color.RED);
			booksList.setText("Sem livros aqui... Que tal adicionar algum para sua biblioteca antes? =D");
			return;
		}
		
		
		String booksName = "";
		for(int i = 0; i < qntBooks; i++) {
			booksName +=  strBooksName[i] + "\n";
		}
		booksList.setText("<html>" + booksName.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
	
	}
}
