package readUs.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import readUs.views.GoalsView;
import readUs.views.LibraryView;
import readUs.views.MainView;
import readUs.views.OverviewView;

public class InitViews {
	public void initGoalFrame(MainView frame){
		GoalsView goalFrame = new GoalsView();
		goalFrame.setVisible(true);
		frame.setVisible(false);
		goalFrame.onGoalsView();
		goalFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	frame.setVisible(true);
		    	frame.setAutoRequestFocus(true);
		    }
		});
	}
	
	public void initLibraryFrame(MainView frame){
		LibraryView libFrame = new LibraryView();
		libFrame.setVisible(true);
		libFrame.onLibraryView();
		frame.setVisible(false);
		
		libFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	frame.setVisible(true);
		    	frame.setAutoRequestFocus(true);
		    }
		});
	}
	
	public void initOverviewFrame(MainView frame){
		OverviewView overviewFrame = new OverviewView();
		overviewFrame.setVisible(true);
		overviewFrame.onOverviewView();
		frame.setVisible(false);
		
		overviewFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	frame.setVisible(true);
		    	frame.setAutoRequestFocus(true);
		    }
		});
	}
	
	public void initWishlistFrame(MainView frame){
		LibraryView wishlistFrame = new LibraryView();
		wishlistFrame.initWishList();
		wishlistFrame.onWishlistView();
		wishlistFrame.setVisible(true);
		frame.setVisible(false);
		
		wishlistFrame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	frame.setVisible(true);
		    	frame.setAutoRequestFocus(true);
		    }
		});
	}

}
