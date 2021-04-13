package readUs.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import readUs.views.GoalsView;
import readUs.views.LibraryView;
import readUs.views.MainView;
import readUs.views.OverviewView;
import readUs.views.WishlistView;

public class InitViews {
	GoalsView goalFrame;
	LibraryView libFrame; 
	OverviewView overviewFrame;
	WishlistView wishlistFrame;
	
	public InitViews() {
		goalFrame = new GoalsView();
		libFrame = new LibraryView();
		overviewFrame = new OverviewView();
		wishlistFrame = new WishlistView();

		libFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		goalFrame.setVisible(false);
		
	}
	
	public void initGoalFrame(MainView frame, JPanel panel){
		panel.add(goalFrame);
		libFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		
		frame.initGoals();
		goalFrame.setVisible(true);
		goalFrame.setEnabled(true);
	}
	
	public void initLibraryFrame(MainView frame, JPanel panel){
		panel.add(libFrame);
		goalFrame.setVisible(false);
		overviewFrame.setVisible(false);
		wishlistFrame.setVisible(false);
		
		frame.initLibrary();
		libFrame.setVisible(true);
		libFrame.setEnabled(true);
	}
	
	public void initOverviewFrame(MainView frame, JPanel panel){
		panel.add(overviewFrame);
		goalFrame.setVisible(false);
		libFrame.setVisible(false);
		wishlistFrame.setVisible(false);
	
		frame.initOverview();
		overviewFrame.setVisible(true);
		overviewFrame.setEnabled(true);
	}
	
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
