package readUs.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import readUs.controller.LibraryController;
import readUs.model.Book;
import readUs.model.Comic;
import readUs.model.Literature;
import readUs.model.Magazine;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveBookView extends JFrame {

	private JPanel contentPane;

	private JLabel mainTitleLabel;
	private JComboBox titleComboBox;
	private JButton deleteBookButton;
	
	LibraryController libControl;
	private JLabel itemContentLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveBookView frame = new RemoveBookView(new LibraryController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void updateTitleComboBox(){
		String[] books = libControl.getAllBooksName();
		titleComboBox.removeAllItems();
		titleComboBox.addItem("Selecione");
		for(int i = 0; i < books.length; i++) {
			titleComboBox.addItem(books[i]);
		}
		titleComboBox.setSelectedIndex(0);
	}

	/**
	 * Create the frame.
	 */
	public RemoveBookView(LibraryController libController){
		this.libControl = libController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		mainTitleLabel = new JLabel("Titulo");
		mainTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		deleteBookButton = new JButton("Deletar Livro");
		deleteBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = (String)titleComboBox.getSelectedItem();
				libControl.removeItem(title);
				updateTitleComboBox();
				JOptionPane.showMessageDialog(contentPane, "Item removido com sucesso! =)");
			}
		});
		
		itemContentLabel = new JLabel("");
		
		titleComboBox = new JComboBox();
		titleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		titleComboBox.setSelectedIndex(0);
		titleComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String title = (String)titleComboBox.getSelectedItem();
				if(titleComboBox.getSelectedIndex() != 0 && title != null) {
					Literature item = libControl.getItem(title);
					deleteBookButton.setEnabled(true);
					itemContentLabel.setText("<html>" + item.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
				else if(titleComboBox.getSelectedIndex() == 0) {
					deleteBookButton.setEnabled(false);
					itemContentLabel.setText(null);
				}
			}
		});
		updateTitleComboBox();
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(102)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(133)
							.addComponent(mainTitleLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(titleComboBox, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(itemContentLabel, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(184)
					.addComponent(deleteBookButton)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainTitleLabel)
					.addGap(6)
					.addComponent(titleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(itemContentLabel, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(deleteBookButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
