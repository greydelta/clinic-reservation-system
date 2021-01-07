package appclass;

import domainclass.*;

public class App {
	public static void main(String[] args) {
		IDataStore dataLists = new DataLists();
	    Controller controller = new Controller(dataLists);
	    ConsoleUI userInterface = new ConsoleUI();
	    userInterface.setController(controller);
	    userInterface.launch();
	}
}