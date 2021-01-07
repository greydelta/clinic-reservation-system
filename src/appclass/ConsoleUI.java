package appclass;

import domainclass.*;
public class ConsoleUI {

	private Scanner scan;
	private Controller control;
	
	public ConsoleUI() {
		scan = null;
		control = null;
	}
	
	public void setScanner(Scanner sc) {
		this.scan = sc;
	}
	public void setController(Controller cont) {
		this.control = cont;
	}
	public Controller getController() {
		return control;
	}
	public void launch() {
	}
}
