package de.wlad;

public class EmptyFilenameException extends Exception {

	private static final long serialVersionUID = 3652914212776981144L;
	
	private Menu.MenuOption mo;
	
	public EmptyFilenameException(Menu.MenuOption mo) {
		this.mo = mo;
	}
	
	public Menu.MenuOption getMenuOption() {
		return mo;
	}
}
