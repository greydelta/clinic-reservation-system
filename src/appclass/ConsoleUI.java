package appclass;

import domainclass.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

	/* Variables
	****************************************/
	private Scanner scan;
	private Controller control;
	
	/* Constructor 
	****************************************/
	public ConsoleUI() {
		scan = null;
		control = null;
	}
	
	/* Accessor Methods
	*****************************************/
	public void setScanner(Scanner sc) {
		this.scan = sc;
	}
	public void setController(Controller cont) {
		this.control = cont;
	}
	public Controller getController() {
		return control;
	}
	// A0 : Initiate all load methods
	public void loadAllData() {
		loadStaffData();
		loadPatientData();
		loadAppointmentData();
	}
	
	// A1 : Load data from staff.txt
	public void loadStaffData() {
		File staff = new File("staff.txt");
		try {
			setScanner(new Scanner(staff));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		int count = 0;
		while(scan.hasNextLine()) {
			String dataFromFile = scan.nextLine();
			String[] split = dataFromFile.split(";");
			String id = split[0];
			String name = split[1];
			String password = split[2];
			int type = Integer.parseInt(split[3]);
			control.addStaff(id, name, password, type);
			count++;
		}
		System.out.println("Loaded "+count+" rows of data from staff.txt");
	}
	
	// A2 : Load data from patient.txt
	public void loadPatientData() {
		File patient = new File("patient.txt");
		try {
			setScanner(new Scanner(patient));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		int count = 0;
		while(scan.hasNextLine()) {
			String dataFromFile = scan.nextLine();
			String[] split = dataFromFile.split(";");
			int id = Integer.parseInt(split[0]);
			String name = split[1];
			String contact = split[2];
			control.addPatient(id, name, contact);
			count++;
		}
		System.out.println("Loaded "+count+" rows of data from patient.txt");
	}
	
	// A3 : Load data from appointment.txt
	public void loadAppointmentData() {
		File patient = new File("appointment.txt");
		try {
			setScanner(new Scanner(patient));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		int count = 0;
		
		while(scan.hasNextLine()) {
			String dataFromFile = scan.nextLine();
			String[] split = dataFromFile.split(";");
			int id = Integer.parseInt(split[0]);
			String status = split[1];
			String date = split[2];
			String time = split[3];
			Staff tempStaff = new Staff(split[4], split[5], split[6], Integer.parseInt(split[7]));
			Patient tempPatient = new Patient(Integer.parseInt(split[8]), split[9], split[10]);
			control.addAppointment(id, status, date, time, tempStaff, tempPatient);
			count++;
		}
		System.out.println("Loaded "+count+" rows of data from appointment.txt");
	}
	public void launch() {
		Staff loginSession = mainMenu();
	public Staff mainMenu() {
		setScanner(new Scanner(System.in));
		Staff login = null;
		int mainMenuChoice, status =-1;
		
		do {
			mainMenuChoice = -1;
			login = null;
			System.out.println("\n<<Main Menu>>");
			System.out.println("==================================");
			System.out.println("           Welcome to             ");
			System.out.println("    Clinic Appointment System     ");
			System.out.println("==================================");
			System.out.println("Would you like to,");
			System.out.println("1. Login as Staff/Doctor");
			System.out.println("2. Exit this system");
			
			mainMenuChoice = intChoiceInput(1, 2);
					
			switch(mainMenuChoice){
				case 1: 
					login = login();
					if(login != null)
						status = 1;
					break;
				case 2:
					System.out.println("\nThank you & have a nice day!");
					System.exit(0);
					break;
				}	
		}while(status != 1);
		return login;
	}
	}
}
