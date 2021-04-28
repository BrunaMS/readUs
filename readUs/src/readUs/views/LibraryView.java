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


/**
 * Mostra ações disponíveis a serem realizadas com a biblioteca e seus itens 
 * e redireciona para novas views de acordo com a opção selecionada pelo usuário.
 *
 *	@author Bruna Medeiros
 *  @version 1.0 (Apr 2021) 
 */
public class LibraryView extends JPanel {
	LibraryController libControl = new LibraryController();
	
	/**
	 * Inicializa componentes do JFrame e define Listeners para os botões da interface
	 */
	public LibraryView() {
		this.setSize(500, 500);
		JLabel lblNewLabel = new JLabel("Biblioteca");
		
		JButton btnMostrarLivros = new JButton("Listar Livros");
		btnMostrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to show items (books, magazines or comics)
				ListBooksView listLibView = new ListBooksView(libControl);
				listLibView.showBooks();
			}
			
		});
		
		JButton btnRemoveBook = new JButton("Remover Livro");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to remove items (books, magazines or comics)
				RemoveBookView rmLibView = new RemoveBookView(libControl);
				rmLibView.setVisible(true);
			}
		});
		
		JButton btnEditarLivro = new JButton("Editar Livro");
		btnEditarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to update items (books, magazines or comics)
				UpdateBookView updateLibView = new UpdateBookView(libControl);
				updateLibView.setVisible(true);
			}
		});
		
		JButton btnAdicionarLivro = new JButton("Adicionar Livro");
		btnAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to add items (books, magazines or comics)
				AddBookView addLibView = new AddBookView(libControl);
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
								.addComponent(btnMostrarLivros, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdicionarLivro, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
							.addGap(150))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel)
					.addGap(42)
					.addComponent(btnMostrarLivros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdicionarLivro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditarLivro)
					.addContainerGap(233, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
