package readUs.views;

import readUs.model.Comic;
import readUs.model.Literature;
import readUs.model.Magazine;
import readUs.model.Literature.itemType;
import readUs.model.Book;
import readUs.controller.LibraryController;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;


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
import java.text.ParseException;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;

/**
 * Classe para exibição e comunicação entre usuário e o software 
 * implementado para modificação/atualização de itens da biblioteca. 
 * @author Bruna Medeiros 
 * @version 1.0 (Abr 2021)
 */
/**
 * @author bruna
 *
 */
public class UpdateBookView extends JFrame {
	LibraryController libControl;
	
	private JPanel contentPane;
	private JComboBox titleComboBox;
	private JLabel titleLabel;
	private JComboBox bookTypeComboBox;
	
	private JLabel mainTitleLabel;
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
	private JTextField titleField;

	/**
	 * Torna visível ou invisível campos relativos à classe Book()
	 * @param enabled: True, caso deseje ativar os componentes
	 * 				   False, caso deseje desativar (tornar invisível)
	 */
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
		
		bookTypeLabel.setVisible(enabled);
		bookTypeComboBox.setVisible(enabled);
	}

	/**
	 * Torna visível ou invisível campos relativos à classe Magazine()
	 * @param enabled: True, caso deseje ativar os componentes
	 * 				   False, caso deseje desativar (tornar invisível)
	 */
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
		
		bookTypeLabel.setVisible(enabled);
		bookTypeComboBox.setVisible(enabled);
	}
	
	/**
	 * Torna visível ou invisível campos relativos à classe Comic()
	 * @param enabled: True, caso deseje ativar os componentes
	 * 				   False, caso deseje desativar (tornar invisível)
	 */
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
		
		bookTypeLabel.setVisible(enabled);
		bookTypeComboBox.setVisible(enabled);
	}
	
	/**
	 * Fecha Frame de atualização de itens.
	 */
	private void closeFrame() {
		this.dispose();
	}
	
	/**
	 * Atualiza instância/item de um livro (Book()) dentro da biblioteca (Collection())
	 * @param item Objeto do tipo Book() que deseja-se atualizar.
	 */
	private void updateBookFields(Book item){
		magazinesFieldsSetVisible(false);
		comicsFieldsSetVisible(false);
		bookFieldsSetVisible(true);
		
		titleField.setText(item.getName());
		publisherField.setText(item.getPublisher());
		nationalityField.setText(item.getNationality());
		yearSpinner.setValue(item.getFirstEdition());
		languageField.setText(item.getOriginalLanguage());
		
		String awards = "";
		for(int i = 0; i < item.getAwards().length; i++) {
			awards += item.getAwards()[i] + ";"; 
		}
		awardsField.setText(awards);
		pagesSpinner.setValue(item.getNumberPages());
		readPagesSpinner.setValue(item.getNumberPagesRead());
		genreField.setText(item.getGenre());
		
		String author = "";
		for(int i = 0; i < item.getAuthor().length; i++) {
			author += item.getAuthor()[i] + ";"; 
		}
		authorField.setText(author);
	}
	
	/**
	 * Atualiza instância/item de um livro (Magazine()) dentro da biblioteca (Collection())
	 * @param item Objeto do tipo Magazine() que deseja-se atualizar.
	 */
	private void updateMagazineFields(Magazine item){
		bookFieldsSetVisible(false);
		comicsFieldsSetVisible(false);
		magazinesFieldsSetVisible(true);
		
		titleField.setText(item.getName());
		publisherField.setText(item.getPublisher());
		nationalityField.setText(item.getNationality());
		yearSpinner.setValue(item.getFirstEdition());
		languageField.setText(item.getOriginalLanguage());
		
		String awards = "";
		for(int i = 0; i < item.getAwards().length; i++) {
			awards += item.getAwards()[i] + ";"; 
		}
		awardsField.setText(awards);
		pagesSpinner.setValue(item.getNumberPages());
		readPagesSpinner.setValue(item.getNumberPagesRead());
		genreField.setText(item.getGenre());

		String headlines = "";
		for(int i = 0; i < item.getHeadline().length; i++) {
			headlines += item.getHeadline()[i] + ";"; 
		}
		headLineField.setText(headlines);
		frequencyComboBox.setSelectedItem(item.getFrequency());
		dateField.setText(item.getCoverDate());
	}
	
	/**
	 * Atualiza instância/item de um livro (Comic()) dentro da biblioteca (Collection())
	 * @param item Objeto do tipo Comic() que deseja-se atualizar.
	 */
	private void updateComicFields(Comic item){
		bookFieldsSetVisible(false);
		magazinesFieldsSetVisible(false);
		comicsFieldsSetVisible(true);
		
		titleField.setText(item.getName());
		publisherField.setText(item.getPublisher());
		nationalityField.setText(item.getNationality());
		yearSpinner.setValue(item.getFirstEdition());
		languageField.setText(item.getOriginalLanguage());
		
		String awards = "";
		for(int i = 0; i < item.getAwards().length; i++) {
			awards += item.getAwards()[i] + ";"; 
		}
		awardsField.setText(awards);
		pagesSpinner.setValue(item.getNumberPages());
		readPagesSpinner.setValue(item.getNumberPagesRead());
		genreField.setText(item.getGenre());

		
		String writers = "";
		for(int i = 0; i < item.getWriter().length; i++) {
			writers += item.getWriter()[i] + ";"; 
		}	
		writerField.setText(writers);
		
		String pencillers = "";
		for(int i = 0; i < item.getPenciller().length; i++) {
			pencillers += item.getPenciller()[i] + ";"; 
		}
		PencillerField.setText(pencillers);
		
		String inkers = "";
		for(int i = 0; i < item.getInker().length; i++) {
			inkers += item.getInker()[i] + ";"; 
		}
		inkerField.setText(inkers);
		
		String letterers = "";
		for(int i = 0; i < item.getLetterer().length; i++) {
			letterers += item.getLetterer()[i] + ";"; 
		}
		lettererField.setText(letterers);
		
		String colourist = "";
		for(int i = 0; i < item.getColourist().length; i++) {
			colourist += item.getColourist()[i] + ";"; 
		}
		colouristField.setText(colourist);
		
		String mainChars = "";
		for(int i = 0; i < item.getMainCharacters().length; i++) {
			mainChars += item.getMainCharacters()[i] + ";"; 
		}
		mainCharsField.setText(mainChars);
	}

	
	/**
	 * Atualiza lista de itens da biblioteca
	 */
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
	public UpdateBookView(LibraryController libController){
		setBackground(Color.WHITE);
		this.libControl = libController;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		mainTitleLabel = new JLabel("Título");
		mainTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
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
		int maxPages = (int) pagesSpinner.getValue();
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
		
		bookTypeComboBox = new JComboBox();
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
		saveBookButton.setBackground(Color.LIGHT_GRAY);
		saveBookButton.setVisible(false);
		saveBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idxItem = libControl.getItemIndex((String)titleComboBox.getSelectedItem());
				
				int releaseYear, pages, readPages;
				String title, publisher, nationality, language, genre;
				String[] awards;

				releaseYear = (int)yearSpinner.getValue(); 
				pages = (int)pagesSpinner.getValue();
				readPages = (int)readPagesSpinner.getValue();
				
				title = titleField.getText();
				if(title.isBlank()) {
					JOptionPane.showMessageDialog(null, "O título da obra não pode ser deixado vazio.", 
							"Título vazio", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(libControl.exists(title) && !title.contentEquals((String)titleComboBox.getSelectedItem())) {
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(null, "Ja existe um livro na sua biblioteca com esse nome. Deseja continuar?", "Aviso: Livro duplicado",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (response != JOptionPane.YES_OPTION) {
						return;
					}
				}
				
				libControl.removeItem((String)titleComboBox.getSelectedItem());
				publisher = publisherField.getText();
				nationality = nationalityField.getText();
				language = languageField.getText();
				genre = genreField.getText();
				awards = libControl.splitStringArray(awardsField.getText(), ";");
	
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
				JOptionPane.showMessageDialog(contentPane, "Item alterado com sucesso! =)");
				closeFrame();
				
			}
			
		});
		
		headlineLabel = new JLabel("Manchete");
		
		headLineField = new JTextField();
		headLineField.setColumns(10);
		
		titleComboBox = new JComboBox();
		titleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		titleComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String title = (String)titleComboBox.getSelectedItem();
				if(titleComboBox.getSelectedIndex() != 0 && title != null) {
					saveBookButton.setVisible(true);
					Literature item = libControl.getItem(title);
					switch(item.getType()) {
						case BOOK:
							bookTypeComboBox.setSelectedIndex(0);
							updateBookFields((Book)item);
							break;
						case MAGAZINE:
							bookTypeComboBox.setSelectedIndex(1);
							updateMagazineFields((Magazine)item);
							break;
						case COMIC:
							bookTypeComboBox.setSelectedIndex(2);
							updateComicFields((Comic)item);
							break;
					}
				}
			}
		});
		
		titleLabel = new JLabel("Título");
		titleField = new JTextField();
		titleField.setColumns(10);

		updateTitleComboBox();
		bookFieldsSetVisible(false);
		magazinesFieldsSetVisible(false);
		comicsFieldsSetVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookTypeLabel)
								.addComponent(publisherLabel, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(numberPagesLabel)
										.addComponent(nationalityLabel)
										.addComponent(genreLabel)
										.addComponent(frequencyLabel)
										.addComponent(writerLabel)
										.addComponent(inkerLabel)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(headlineLabel)
											.addComponent(colouristLabel)))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(titleLabel))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(titleField)
								.addComponent(inkerField)
								.addComponent(colouristField)
								.addComponent(nationalityField)
								.addComponent(pagesSpinner, 0, 0, Short.MAX_VALUE)
								.addComponent(genreField)
								.addComponent(frequencyComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(writerField)
								.addComponent(bookTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(publisherField)
								.addComponent(headLineField))
							.addGap(18)
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
						.addComponent(titleComboBox, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lettererField)
								.addComponent(mainCharsField)
								.addComponent(PencillerField)
								.addComponent(authorField)
								.addComponent(readPagesSpinner, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(awardsField)
								.addComponent(languageField)
								.addComponent(saveBookButton, Alignment.TRAILING)
								.addComponent(dateField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(yearSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(284)
					.addComponent(mainTitleLabel)
					.addContainerGap(288, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(mainTitleLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(titleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLabel)
						.addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(yearSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(languageLabel)
								.addComponent(languageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(awardsLabel)
								.addComponent(awardsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(readPagesLabel)
								.addComponent(readPagesSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(authorLabel)
								.addComponent(authorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(dateLabel)
								.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(PencillerLabel)
								.addComponent(PencillerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(letterer)
								.addComponent(lettererField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(mainCharsLabel)
								.addComponent(mainCharsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(saveBookButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookTypeLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(publisherLabel)
								.addComponent(publisherField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nationalityLabel)
								.addComponent(nationalityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(numberPagesLabel)
								.addComponent(pagesSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(genreLabel)
								.addComponent(genreField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(frequencyLabel)
								.addComponent(frequencyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(writerLabel)
								.addComponent(writerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(inkerLabel)
								.addComponent(inkerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(colouristLabel)
								.addComponent(colouristField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(headLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(headlineLabel))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
