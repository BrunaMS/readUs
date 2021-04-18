package readUs.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import readUs.controller.LibraryController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryView extends JPanel {

	LibraryController libControl = new LibraryController();
	/**
	 * Create the frame.
	 */
	public LibraryView() {
		initComponents();
		this.setSize(500, 500);
		
		JLabel lblStatus = new JLabel("Status");
		JLabel lblNewLabel = new JLabel("Biblioteca");
		
		JButton btnMostrarLivros = new JButton("Listar Livros");
		btnMostrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBooksView listLibView = new ListBooksView();
				listLibView.showBooks(libControl);
			}
			
		});
		
		JButton btnSearchBook = new JButton("Buscar Livro");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRemoveBook = new JButton("Remover Livro");
		
		JButton btnEditarLivro = new JButton("Editar Livro");
		
		JButton btnAdicionarLivro = new JButton("Adicionar Livro");
		btnAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookView addLibView = new AddBookView();
				addLibView.setAutoRequestFocus(true);
				addLibView.setVisible(true);
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(173, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(209))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnRemoveBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEditarLivro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdicionarLivro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
								.addComponent(btnSearchBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMostrarLivros, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(150))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStatus)
					.addContainerGap(418, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel)
					.addGap(42)
					.addComponent(btnMostrarLivros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearchBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditarLivro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdicionarLivro)
					.addGap(18)
					.addComponent(lblStatus)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	private void initComponents() {		
	}
}
