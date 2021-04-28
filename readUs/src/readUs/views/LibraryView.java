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
		setBackground(Color.WHITE);
		
		JButton btnMostrarLivros = new JButton("Listar itens");
		btnMostrarLivros.setBackground(Color.LIGHT_GRAY);
		btnMostrarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to show items (books, magazines or comics)
				ListBooksView listLibView = new ListBooksView(libControl);
				listLibView.showBooks();
			}
			
		});
		
		JButton btnRemoveBook = new JButton("Remover item");
		btnRemoveBook.setBackground(Color.LIGHT_GRAY);
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to remove items (books, magazines or comics)
				RemoveBookView rmLibView = new RemoveBookView(libControl);
				rmLibView.setVisible(true);
			}
		});
		
		JButton btnEditarLivro = new JButton("Editar item");
		btnEditarLivro.setBackground(Color.LIGHT_GRAY);
		btnEditarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create new JFrame to update items (books, magazines or comics)
				UpdateBookView updateLibView = new UpdateBookView(libControl);
				updateLibView.setVisible(true);
			}
		});
		
		JButton btnAdicionarLivro = new JButton("Adicionar item");
		btnAdicionarLivro.setBackground(Color.LIGHT_GRAY);
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(141)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEditarLivro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnRemoveBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnMostrarLivros, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnAdicionarLivro, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addGap(132))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(btnMostrarLivros, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdicionarLivro, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRemoveBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEditarLivro, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		setLayout(groupLayout);
	}
}
