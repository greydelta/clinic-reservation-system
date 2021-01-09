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
		int choice = 0, staff = -1;
		staff = loginSession.getStaff_type();
		while(choice != 1) {
			choice = subMenu(loginSession);
			if(choice == 8 && staff == 1) {
				System.out.println("Thank you for using our system!");
				System.exit(0);
			}
			else if(choice == 2 && staff == 2) {
				System.out.println("Thank you for using our system!");
				System.exit(0);
			}
			else {
				choice = 0;
			}
		}
	}
	
	// B1 : Main Menu Method (main welcome page)
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
	public int subMenu(Staff loginValid) {
		int choice = -1;

		System.out.println("\n<<Sub-Menu>>");
		if(loginValid.getStaff_type() == 1) {
			System.out.println(" >>Logged In as (Staff): "+loginValid.getStaff_name());
			System.out.println(" 1. Create Appointment");
			System.out.println(" 2. Update/Cancel Appointment");
			System.out.println(" 3. Search Appointment (by Doctor)");
			System.out.println(" 4. Create Patient Profile");
			System.out.println(" 5. Update Patient Profile");
			System.out.println(" 6. View Patient record and Information");
			System.out.println(" 7. Exit this system");
			System.out.print(">>Choice: ");
			try {
				choice = intInputValidation(1, 7);}
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();}
		}
		else if(loginValid.getStaff_type() == 2) {
			System.out.println(" >>Logged In as (Doctor): "+loginValid.getStaff_name());
			System.out.println(" 1. View Patient record and Information");
			System.out.println(" 2. Exit this system");
			System.out.print(">>Choice: ");
			try {
				choice = intInputValidation(1, 2);}
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();}
		}
		
		return choice;
	}
	}
	
	// F1 : Combination of Method F2 and F4
	public int intChoiceInput(int x, int y) {
		int choice = -1, doWhile = -1;
		do {
			System.out.print(">>Choice: ");
        	try {
        		choice = intInputValidation(x, y);
        		doWhile = 1;} 
        	catch (IllegalArgumentException e) {
        		System.err.println(e.getMessage());
        		bufferFor5Miliseconds();
        		doWhile = 0;}
		}while(doWhile != 1);
		return choice;
	}
	
	// F2 : Method for integer input validation
	public int intInputValidation(int lower, int upper) throws IllegalArgumentException {
		setScanner(new Scanner(System.in));
		int userInput;
	        
		if (scan.hasNextLine()){
			String tempString = scan.nextLine();

			// Check if blank / only whitespace
			if(tempString.isEmpty() == true)	
				throw new IllegalArgumentException("\nNot allowed to enter blank values!");
			else
		        // Check if is valid integer
		        try {
		        	// Convert to integer
		        	userInput = Integer.parseInt(tempString);
		        }
		        catch (NumberFormatException e) {
		        	throw new IllegalArgumentException("\nEnter integers Only!");
		        }
		        	
		        // Check if range is same, then can only enter that value
		        if(lower == upper) 
		        	if(userInput != lower)
			            throw new IllegalArgumentException("\nEnter "+lower+" only!");
			        else
		            	return userInput;
		           
		        // Check if it is within range
		        if (userInput < lower || userInput > upper)
		              throw new IllegalArgumentException("\nEnter values between "+lower+" and "+upper+" only!");
		        else
		              return userInput;
	        } 
	        else
	            throw new IllegalArgumentException("\nEnter integers Only!");
	}
	    
    // Method F3 : Method for string input validation
    public String stringInputValidation() throws IllegalArgumentException{
    	setScanner(new Scanner(System.in));
    	String userInput;
    	if (scan.hasNextLine()){
    		userInput = scan.nextLine();
    		if(userInput.isEmpty() == true)
        		throw new IllegalArgumentException("Not allowed to enter blank values!");
    		else
    			return userInput;
    	}
    	else
    		throw new IllegalArgumentException("Scanner is closed");	
    }
	    
    /* Method F4 : Pause execution for 5 seconds
	*****************************************/
    public void bufferFor5Miliseconds() {
    	try {
			TimeUnit.MILLISECONDS.sleep(500);}
		catch (InterruptedException e1) {
			System.err.print(e1.getMessage());}
    }
}
