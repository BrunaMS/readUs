package readUs.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import readUs.controller.LibraryController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AddBookView extends JFrame {
	LibraryController libControl;
	
	private JPanel contentPane;

	private JLabel titleLabel;
	private JTextField titleField;
	private JLabel publisherLabel;
	private JTextField publisherField;
	private JLabel nationalityLabel;
	private JTextField nationalityField;
	private JLabel languageLabel;
	private JTextField languageField;
	private JLabel awardsLabel;
	private JTextField awardsField;
	private JLabel genreLabel;
	private JTextField genreField;
	private JLabel authorLabel;
	private JTextField authorField;
	private JLabel yearLabel;
	private JSpinner yearSpinner;
	private JLabel numberPagesLabel;
	private JSpinner pagesSpinner;
	private JLabel readPagesLabel;
	private JSpinner readPagesSpinner;
	private JFormattedTextField dateField;
	
	
	private JLabel registerNewBookLabel;
	private JLabel frequencyLabel;
	private JLabel dateLabel;
	private JLabel writerLabel;
	private JLabel PencillerLabel;
	private JLabel inkerLabel;
	private JLabel mainCharsLabel;
	private JLabel letterer;
	private JLabel colouristLabel;
	private JLabel bookTypeLabel;
	
	
	private JTextField writerField;
	private JTextField PencillerField;
	private JTextField inkerField;
	private JTextField colouristField;
	private JTextField mainCharsField;
	private JTextField lettererField;
	
	private JButton saveBookButton;
	private JComboBox frequencyComboBox;
	private JLabel headlineLabel;
	private JTextField headLineField;

	public void bookFieldsSetVisible(boolean enabled) {
		titleField.setVisible(enabled);
		publisherField.setVisible(enabled);
		nationalityField.setVisible(enabled);
		yearSpinner.setVisible(enabled);
		languageField.setVisible(enabled);
		awardsField.setVisible(enabled);
		pagesSpinner.setVisible(enabled);
		readPagesSpinner.setVisible(enabled);
		genreField.setVisible(enabled);
		authorField.setVisible(enabled);

		titleLabel.setVisible(enabled);
		publisherLabel.setVisible(enabled);
		nationalityLabel.setVisible(enabled);
		languageLabel.setVisible(enabled);
		awardsLabel.setVisible(enabled);
		genreLabel.setVisible(enabled);
		authorLabel.setVisible(enabled);
		yearLabel.setVisible(enabled);
		numberPagesLabel.setVisible(enabled);
		readPagesLabel.setVisible(enabled);
		yearLabel.setVisible(enabled);
	}

	public void magazinesFieldsSetVisible(boolean enabled) {
		titleField.setVisible(enabled);
		publisherField.setVisible(enabled);
		nationalityField.setVisible(enabled);
		yearSpinner.setVisible(enabled);
		languageField.setVisible(enabled);
		awardsField.setVisible(enabled);
		pagesSpinner.setVisible(enabled);
		readPagesSpinner.setVisible(enabled);
		genreField.setVisible(enabled);
		headLineField.setVisible(enabled);
		frequencyComboBox.setVisible(enabled);
		dateField.setVisible(enabled);

		titleLabel.setVisible(enabled);
		publisherLabel.setVisible(enabled);
		nationalityLabel.setVisible(enabled);
		yearLabel.setVisible(enabled);
		languageLabel.setVisible(enabled);
		awardsLabel.setVisible(enabled);
		numberPagesLabel.setVisible(enabled);
		readPagesLabel.setVisible(enabled);
		genreLabel.setVisible(enabled);
		headlineLabel.setVisible(enabled);
		frequencyLabel.setVisible(enabled);
		dateLabel.setVisible(enabled);
	}
	
	public void comicsFieldsSetVisible(boolean enabled) {
		titleField.setVisible(enabled);
		publisherField.setVisible(enabled);
		nationalityField.setVisible(enabled);
		yearSpinner.setVisible(enabled);
		languageField.setVisible(enabled);
		awardsField.setVisible(enabled);
		pagesSpinner.setVisible(enabled);
		readPagesSpinner.setVisible(enabled);
		genreField.setVisible(enabled);
		writerField.setVisible(enabled);
		PencillerField.setVisible(enabled);
		inkerField.setVisible(enabled);
		lettererField.setVisible(enabled);
		colouristField.setVisible(enabled);
		mainCharsField.setVisible(enabled);

		titleLabel.setVisible(enabled);
		publisherLabel.setVisible(enabled);
		nationalityLabel.setVisible(enabled);
		yearLabel.setVisible(enabled);
		languageLabel.setVisible(enabled);
		awardsLabel.setVisible(enabled);
		numberPagesLabel.setVisible(enabled);
		readPagesLabel.setVisible(enabled);
		genreLabel.setVisible(enabled);
		writerLabel.setVisible(enabled);
		PencillerLabel.setVisible(enabled);
		inkerLabel.setVisible(enabled);
		letterer.setVisible(enabled);
		colouristLabel.setVisible(enabled);
		mainCharsLabel.setVisible(enabled);
		
	}
	
	private void closeFrame() {
		this.dispose();
	}
	
	/**
	 * Create the frame.
	 */
	public AddBookView(LibraryController libController){
		this.libControl = libController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		registerNewBookLabel = new JLabel("Cadastrar nova Leitura");
		registerNewBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleField = new JTextField();
		titleField.setColumns(10);
		
		titleLabel = new JLabel("Título");
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		publisherField = new JTextField();
		publisherField.setColumns(10);
		
		publisherLabel = new JLabel("Editora");
		publisherLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nationalityField = new JTextField();
		nationalityField.setColumns(10);
		
		nationalityLabel = new JLabel("Nacionalidade");
		nationalityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		yearLabel = new JLabel("Ano de Lançamento");
		yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		languageLabel = new JLabel("Linguagem Original");
		
		awardsLabel = new JLabel("Premios");
		awardsLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		
		numberPagesLabel = new JLabel("Numero de paginas");
		
	    SpinnerModel value =  new SpinnerNumberModel(500, //initial value  
									                 1, //minimum value  
									                 Integer.MAX_VALUE, //maximum value  
									                 1); //step 
		pagesSpinner = new JSpinner(value);
		pagesSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int maxPages = (int) pagesSpinner.getValue();
				SpinnerModel value;
				value = new SpinnerNumberModel(maxPages, //initial value  
	                	   0, //minimum value  
	                	   maxPages, //maximum value  
		                   1); //step 
				int oldValue = (int)readPagesSpinner.getValue();
				readPagesSpinner.setModel(value);
			    if(oldValue > maxPages) {
			    	readPagesSpinner.setValue(maxPages);
			    }
			    else {
			    	readPagesSpinner.setValue(oldValue);
			    }
			}
		});
	    value =  new SpinnerNumberModel(2021, //initial value  
                0, //minimum value  
               2021, //maximum value  
               1); //step 
		yearSpinner = new JSpinner(value); //step 
		JComponent editor = new JSpinner.NumberEditor(yearSpinner, "####");
		yearSpinner.setEditor(editor);
		
		languageField = new JTextField();
		languageField.setColumns(10);
		
		awardsField = new JTextField();
		awardsField.setColumns(10);
		
		readPagesLabel = new JLabel("Paginas Lidas");
		int maxPages = (Integer) pagesSpinner.getValue();
	    value = new SpinnerNumberModel(0, //initial value  
				                	   0, //minimum value  
				                	   maxPages, //maximum value  
					                   1); //step 
		readPagesSpinner = new JSpinner(value);
		
		genreLabel = new JLabel("Gênero");
		
		genreField = new JTextField();
		genreField.setColumns(10);
		
		authorLabel = new JLabel("Autor");
		
		authorField = new JTextField();
		authorField.setColumns(10);
		
		frequencyLabel = new JLabel("Frequência");
		
		frequencyComboBox = new JComboBox();
		frequencyComboBox.setModel(new DefaultComboBoxModel(new String[] {"Diario", "Semanal", "Quinzenal", "Mensal", "Semestral", "Anual"}));
		
		dateLabel = new JLabel("Data da Publicacao");
		
		
		try {
			MaskFormatter maskDate = new MaskFormatter("##/##/####");
			maskDate.setPlaceholderCharacter('_');
			dateField = new JFormattedTextField(maskDate);
		} catch (ParseException e1) {
			dateField = new JFormattedTextField();
			System.out.println("Error defining mask");
		}
		
		
		writerLabel = new JLabel("Escritor");
		
		writerField = new JTextField();
		writerField.setColumns(10);
		
		PencillerLabel = new JLabel("Desenhista");
		
		PencillerField = new JTextField();
		PencillerField.setColumns(10);
		
		inkerLabel = new JLabel("Arte Finalista");
		
		inkerField = new JTextField();
		inkerField.setColumns(10);
		
		letterer = new JLabel("Letrista");
		
		colouristLabel = new JLabel("Colorista");
		
		colouristField = new JTextField();
		colouristField.setColumns(10);
		
		mainCharsLabel = new JLabel("Personagens Principais");
		
		mainCharsField = new JTextField();
		mainCharsField.setColumns(10);
		
		lettererField = new JTextField();
		lettererField.setColumns(10);
		
		JComboBox bookTypeComboBox = new JComboBox();
		bookTypeComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				switch(bookTypeComboBox.getSelectedIndex()) {
					case 0: // Book
						comicsFieldsSetVisible(false);
						magazinesFieldsSetVisible(false);
						bookFieldsSetVisible(true);
						break;
					case 1: // Magazine
						comicsFieldsSetVisible(false);
						bookFieldsSetVisible(false);
						magazinesFieldsSetVisible(true);
						break;
					case 2: // Comic
						magazinesFieldsSetVisible(false);
						bookFieldsSetVisible(false);
						comicsFieldsSetVisible(true);
						break;
				}
				
			}
		});
		bookTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Livro", "Revista", "HQ (Comics)"}));
		
		bookTypeLabel = new JLabel("Classificação");
		
		saveBookButton = new JButton("Salvar");
		saveBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int releaseYear, pages, readPages;
				String title, publisher, nationality, language, genre;
				String[] awards;

				releaseYear = (int)yearSpinner.getValue(); 
				pages 		= (int)pagesSpinner.getValue();
				readPages 	= (int)readPagesSpinner.getValue();
				
				title 		= titleField.getText();
				if(title.isBlank()) {
					JOptionPane.showMessageDialog(null, "O título da obra não pode ser deixado vazio.", 
							"Título vazio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(libControl.exists(title)) {
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(null, "Ja existe um livro na sua biblioteca com esse nome. Deseja continuar mesmo assim?", "Aviso: Livro duplicado",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response != JOptionPane.YES_OPTION) {
						return;
					}
					title = title + "(1)";
				}
				publisher 	= publisherField.getText();
				nationality = nationalityField.getText();
				language 	= languageField.getText();
				genre 		= genreField.getText();
				awards 	= libControl.splitStringArray(awardsField.getText(), ";");
	
				switch(bookTypeComboBox.getSelectedIndex()) {
					case 0: // Book
						String[] author	= libControl.splitStringArray(authorField.getText(), ";");
						libControl.addBook(title, publisher, nationality, releaseYear, language, awards, 
										   pages, readPages, genre, author);
						break;
					case 1: // Magazine				
						String frequency = String.valueOf(frequencyComboBox.getSelectedItem());
						String coverDate = dateField.getText();
						String[] headline = libControl.splitStringArray(writerField.getText(), ";");
						libControl.addMagazine(title, publisher, nationality, releaseYear, language, awards, 
											   pages, readPages, genre, headline, frequency, coverDate);
						break;
					case 2: // Comic
						String[] writer		= libControl.splitStringArray(writerField.getText(), ";");
						String[] penciller 	= libControl.splitStringArray(PencillerField.getText(), ";");
						String[] inker 		= libControl.splitStringArray(inkerField.getText(), ";");
						String[] letterer 	= libControl.splitStringArray(lettererField.getText(), ";");
						String[] colourist 	= libControl.splitStringArray(colouristField.getText(), ";");
						String[] mainChars 	= libControl.splitStringArray(mainCharsField.getText(), ";");
						
						libControl.addComic(title, publisher, nationality, releaseYear, language, awards, 
											pages, readPages, genre, writer, penciller, inker, letterer, 
											colourist, mainChars);
						break;
				}
				JDialog.setDefaultLookAndFeelDecorated(true);
				JOptionPane.showMessageDialog(contentPane, "Item adicionado com sucesso! =)");
				closeFrame();
				
			}
			
		});
		
		headlineLabel = new JLabel("Manchete");
		
		headLineField = new JTextField();
		headLineField.setColumns(10);
		
		comicsFieldsSetVisible(false);
		magazinesFieldsSetVisible(false);
		bookFieldsSetVisible(true);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(bookTypeComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(publisherLabel, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
										.addComponent(titleLabel)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(numberPagesLabel)
												.addComponent(nationalityLabel)
												.addComponent(genreLabel)
												.addComponent(frequencyLabel)
												.addComponent(writerLabel)
												.addComponent(inkerLabel)
												.addComponent(colouristLabel)
												.addComponent(headlineLabel))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(frequencyComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(pagesSpinner, 0, 0, Short.MAX_VALUE)
														.addComponent(titleField)
														.addComponent(publisherField)
														.addComponent(nationalityField)
														.addComponent(genreField))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(awardsLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(readPagesLabel)
															.addComponent(authorLabel)
															.addComponent(dateLabel)
															.addComponent(PencillerLabel)
															.addComponent(letterer)
															.addComponent(mainCharsLabel)
															.addComponent(languageLabel))
														.addComponent(yearLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
												.addComponent(writerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(inkerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(colouristField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(yearSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lettererField)
													.addComponent(mainCharsField)
													.addComponent(PencillerField)
													.addComponent(authorField)
													.addComponent(readPagesSpinner, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
													.addComponent(awardsField)
													.addComponent(languageField)
													.addComponent(dateField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(headLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(saveBookButton)))))
							.addGap(142))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(registerNewBookLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
							.addComponent(bookTypeLabel)
							.addGap(172))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(bookTypeLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(registerNewBookLabel)))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(titleLabel)
							.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(yearLabel))
						.addComponent(yearSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(publisherField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(publisherLabel))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nationalityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nationalityLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(languageLabel)
								.addComponent(languageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(awardsLabel)
								.addComponent(awardsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pagesSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(numberPagesLabel)
						.addComponent(readPagesLabel)
						.addComponent(readPagesSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(genreLabel)
							.addComponent(genreField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(authorLabel)
							.addComponent(authorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(frequencyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(frequencyLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(dateLabel)
								.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(writerLabel)
							.addComponent(writerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(PencillerLabel)
								.addComponent(PencillerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(inkerLabel)
								.addComponent(inkerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(letterer))
						.addComponent(lettererField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(colouristLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(colouristField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(mainCharsLabel)
							.addComponent(mainCharsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveBookButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(headlineLabel)
							.addComponent(headLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookView frame = new AddBookView(new LibraryController());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
