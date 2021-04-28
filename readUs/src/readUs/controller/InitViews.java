package readUs.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import readUs.views.GoalsView;
import readUs.views.LibraryView;
import readUs.views.MainView;
import readUs.views.OverviewView;

/**
 * Classe para inicialização das views (JPanels) do software
 * @author Bruna Medeiros
 * @version 1.0 (Abr 2021)
 */
public class InitViews {
	GoalsView goalFrame;
	LibraryView libFrame; 
	OverviewView overviewFrame;
	LibraryView wishlistFrame;
	
	public InitViews() {
		goalFrame = new GoalsView();
		libFrame = new LibraryView();
		overviewFrame = new OverviewView();
		wishlistFrame = new LibraryView();

		libFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		goalFrame.setVisible(false);
		
	}
	
	/**
	 * Inicializa painel de metas do usuário
	 * @param frame: View principal onde o JPanel será adicionado
	 * @param panel: Panel principal do JFrame escolhido
	 */
	public void initGoalFrame(MainView frame, JPanel panel){
		goalFrame.setSize(panel.getSize());
		panel.add(goalFrame);
		libFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		
		frame.initGoals();
		goalFrame.setVisible(true);
		goalFrame.setEnabled(true);
	}
	
	/**
	 * Inicializa painel de biblioteca do usuário
	 * @param frame: View principal onde o JPanel será adicionado
	 * @param panel: Panel principal do JFrame escolhido
	 */
	public void initLibraryFrame(MainView frame, JPanel panel){
		panel.add(libFrame);
		goalFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		
		frame.initLibrary();
		libFrame.setVisible(true);
		libFrame.setEnabled(true);
	}
	
	/**
	 * Inicializa painel inicial a ser mostrado para o usuário
	 * @param frame: View principal onde o JPanel será adicionado
	 * @param panel: Panel principal do JFrame escolhido
	 */
	public void initOverviewFrame(MainView frame, JPanel panel){
		panel.add(overviewFrame);
		goalFrame.setVisible(false);
		libFrame.setVisible(false);
		wishlistFrame.setVisible(false);
	
		frame.initOverview();
		overviewFrame.setVisible(true);
		overviewFrame.setEnabled(true);
	}
	
	/**
	 * Inicializa painel de lista de desejos do usuário
	 * @param frame: View principal onde o JPanel será adicionado
	 * @param panel: Panel principal do JFrame escolhido
	 */
	public void initWishlistFrame(MainView frame, JPanel panel){
		panel.add(wishlistFrame);
		goalFrame.setVisible(false);
		libFrame.setVisible(false);
		overviewFrame.setVisible(false);
		
		frame.initWishList();
		wishlistFrame.setVisible(true);
		wishlistFrame.setEnabled(true);
	}

}
