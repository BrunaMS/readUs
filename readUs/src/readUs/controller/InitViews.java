package readUs.controller;

import readUs.views.GoalsView;
import readUs.views.LibraryView;
import readUs.views.MainView;
import readUs.views.OverviewView;

public class InitViews {
	public void initGoalFrame(MainView frame){
		GoalsView goalFrame = new GoalsView();
		goalFrame.setVisible(true);
		frame.setVisible(false);
	}
	
	public void initLibraryFrame(MainView frame){
		LibraryView libFrame = new LibraryView();
		libFrame.setVisible(true);
		frame.setVisible(false);
	}
	
	public void initOverviewFrame(MainView frame){
		OverviewView overviewFrame = new OverviewView();
		overviewFrame.setVisible(true);
		frame.setVisible(false);
	}
	
	public void initWishlistFrame(MainView frame){
		LibraryView wishlistFrame = new LibraryView();
		wishlistFrame.initWishList();
		wishlistFrame.setVisible(true);
		frame.setVisible(false);
	}

}
