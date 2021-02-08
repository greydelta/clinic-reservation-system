package appclass;

import domainclass.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
	
	// B0 : Initiate launch for Main Menu and Sub-Menus
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
	
	// B2 : Sub-Menu (can be accessed after successful login)
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
		
		switch(choice) {
			case 1: 
				if(loginValid.getStaff_type() == 1)
					createAppointment();
				break;
			case 2: 
				if(loginValid.getStaff_type() == 1)
					updateAppointment();
				else
					choice = 8;
				break;
			case 7:
				choice = 8;
				break;
		}
		return choice;
	}
	
	// B3 : Login Method to verify login credentials
	public Staff login() {
		int signInChoice = -1, doWhile1 = -1, doWhile2 = -1, doWhile3 = -1,
			innerDoWhile1 = -1, innerDoWhile2 = -1;
		Staff loginValid = null;
		String id = null, pass = null;
		
		do { // doWhile3
			do { //doWhile1
				System.out.println("\n<<Login>>");
				
				do { // innerDoWhile1
					System.out.print("Enter ID: ");
					// Check if input is valid
					try {
						id = stringInputValidation();
						innerDoWhile1 = 1;}
					catch (IllegalArgumentException e) {
						System.err.println(e.getMessage());
						bufferFor5Miliseconds();
						innerDoWhile1 = 0;}
				}while(innerDoWhile1 != 1);
				
				do {
					System.out.print("Enter Password: ");
					// Check if input is valid
					try {
						pass = stringInputValidation();
						innerDoWhile2 = 1;}   
					catch (IllegalArgumentException e) {
						System.err.println(e.getMessage());
						bufferFor5Miliseconds();
						innerDoWhile2 = 0;}
				}while(innerDoWhile2 != 1);
				
				// Both input are valid, proceed to validate
				loginValid = validateStaff(id, pass);
				doWhile1 = 1;
			}while(doWhile1 != 1);
			
			if(loginValid != null) {
				//System.out.println("\nLogged in as: " + loginValid.getStaff_name());
				doWhile3 = 1;
			}
			else {
				do {
					System.out.println("\nIncorrect name/password.");
					System.out.println("1. Login again");
					System.out.println("2. Exit to Main Menu");
					signInChoice = intChoiceInput(1, 2);
					
					if(signInChoice == 1) {
						doWhile1 = 0; 
						doWhile2 = 1; // Prompt enter input
						doWhile3 = 0;
						innerDoWhile1 = 0;
						innerDoWhile2 = 0;
					}
					else if(signInChoice == 2) {
						return loginValid;
					}
				}while(doWhile2 != 1);
			}
			
		}while(doWhile3 != 1);
		
		return loginValid;
	}
	
	// B4 : Method to validate login credentials exist in database
	public Staff validateStaff(String id, String pass) {
		List<Staff> staff = control.getAllStaffs();
		for (Staff tempStaff: staff) {
			if(id.equals(tempStaff.getStaff_id()) && pass.equals(tempStaff.getStaff_password()))
				return tempStaff;
		}
		return null;
	}
	public void createAppointment() {
		String name = null, contact = null, status = null, date = null, time = null;
    	int id = 0, flag = -1; Staff doc = new Staff();
    	Patient exist = new Patient();
    	List<Appointment> appointment = control.getAllAppointments();

    	System.out.println("\n<<Create Appointment>>");
    	
    	name = promptInputPatientName();
    	contact = promptInputPatientContact();
		exist = checkIfPatientExist(name, contact);
    	
		if(exist != null) {
			System.out.println("<<Patient Exist!>>");
			
			for(Appointment tempAppt: appointment) {
				if(tempAppt.getAppointment_patient().getPatient_id() == exist.getPatient_id())
					if(tempAppt.getAppointment_status().equals("Booked")) {
						flag = 1;
						break;
					}
			}
			
			if(flag == 1) {
				System.out.println("<<There is an existing booking!>>");
			}
			else {
				// Generate Appointment ID
		    	id = appointment.size() + 1 ;
				status = convertStatus(promptInputAppointmentStatus());
				date = promptInputAppointmentDate();
				time = promptInputAppointmentTime();
		    	doc = promptInputAppointmentDoc();
				
		    	control.addAppointment(id, status, date, time, doc, exist);
				System.out.println("\n>> New Appointment Created for " +name+" ("+contact+")");
			}
		}
		else
			System.out.println("<<Patient Does Not Exist!>>");
	}
	public void updateAppointment() {
		String name = null, contact = null, status = null, date = null, time = null;
    	int choice = 0, num = 0; //Staff doc = new Staff();
    	Patient exist = new Patient();
    	List<Appointment> appointment = control.getAllAppointments();

    	System.out.println("\n<<Update Appointment>>");
    	
    	name = promptInputPatientName();
    	contact = promptInputPatientContact();
		exist = checkIfPatientExist(name, contact);
    	
		if(exist != null) {
			System.out.println("<<Patient Exist!>>");
			int count = 0, noBooking = 0;
			List<String> listToStoreID = new ArrayList<>();

			System.out.println("Num  Status\tDate\t\tTime\tDoctor\t\tPatient Name");
			System.out.println("---  ---------\t----------\t-----\t-----------\t-------------");
			
			// generate list of appointment by this patient
			for(Appointment tempApt : appointment) {
				count++; 
				if(tempApt.getAppointment_patient().getPatient_id() == exist.getPatient_id()) {
					num++;
					System.out.println(num+".   "+tempApt.getAppointment_status()
									+"\t"+tempApt.getAppointment_date() +"\t"+tempApt.getAppointment_time()
									+"\t"+tempApt.getAppointment_doc().getStaff_name()
									+"\t\t"+tempApt.getAppointment_patient().getPatient_name());
					listToStoreID.add(String.valueOf(tempApt.getAppointment_id()));
				}
				else {
					noBooking++;
					continue;
				}
			}
			
			if(noBooking == count) {
				System.out.println("<<No booking found!>>");
			}
			else {
				System.out.println("<<Choose booking to update>>");
				int diff = count - noBooking;
				choice = intChoiceInput(1, diff);
				int id = Integer.parseInt(listToStoreID.get(choice-1).toString());
				
				do {
					int flag = -1;
					System.out.println("<<Select component to update>>");
					System.out.println("1. Appointment Status");
					System.out.println("2. Appointment Date");
					System.out.println("3. Appointment Time");
					System.out.println("4. Return to Sub-Menu");
					choice = intChoiceInput(1, 4);
				
					switch(choice) {
						case 1:
							// Check if patient has an active booking, if yes flag = 1
							for(Appointment tempAppt: appointment) {
								if(tempAppt.getAppointment_patient().getPatient_id() == exist.getPatient_id())
									if(tempAppt.getAppointment_status().equals("Booked")) {
										flag = 1;
										break;
									}
							}
							
							int flag1 = -1;
							if(flag == 1) { // has active appointment
								if(flag1 != 1) // user choose active booking "Booked" to update to => "Booked"
									status = convertStatus(promptInputAppointmentStatus());
									if(status == "Booked")
										System.out.println("<<Not allowed to update to 'Booked' as there is an existing booking!>>");
									else { // user choose to update active booking "Booked" to either "Consulted" or "Cancelled"
										control.updateAppointmentStatus(id, status);
										System.out.println("<<Status updated to: "+status+">>");
										break;
									}
							} 
							else {  // no active appointment
								status = convertStatus(promptInputAppointmentStatus());
								control.updateAppointmentStatus(id, status);
								System.out.println("<<Status updated to: "+status+">>");
							}
							break;
						case 2:
							date = promptInputAppointmentDate();
							control.updateAppointmentDate(id, date);
							System.out.println("<<Date updated to: "+date+">>");
							break;
						case 3:
							time = promptInputAppointmentTime();
							control.updateAppointmentTime(id, time);
							System.out.println("<<Time updated to: "+time+">>");
							break;
						case 4:
							break;
					}
					
					System.out.println("\n>> Appointment Updated for " +name+" ("+contact+")");
				}while(choice != 4);
			}
		}
		else
			System.out.println("<<Patient Does Not Exist!>>");
	}
	}
	public int promptInputAppointmentStatus() {
		int doWhile = -1, choice = 0;
		do {
			System.out.println("<<Enter Appointment Status>>");
			System.out.println("1. Booked");
			System.out.println("2. Consulted");
			System.out.println("3. Cancelled");
			System.out.print(">> Choice: ");
			try {
				choice = intInputValidation(1, 3);
				doWhile = 1;
			}   
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();
				doWhile = 0;} 
		}while(doWhile != 1);
		return choice;
	}
	public String promptInputAppointmentDate() {
		int doWhile = -1; String date = null;
		do {
			System.out.print("Enter Appointment Date (DD/MM/YYYY): ");
			try {
				date = stringInputValidation();
				doWhile = 1;
			}   
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();
				doWhile = 0;} 
		}while(doWhile != 1);
		return date;
	}
	public String promptInputAppointmentTime() {
		int doWhile = -1; String time = null;
		do {
			System.out.print("Enter Appointment Time (HH:MM): ");
			try {
				time = stringInputValidation();
				doWhile = 1;
			}   
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();
				doWhile = 0;} 
		}while(doWhile != 1);
		return time;
	}
	public Staff promptInputAppointmentDoc() {
		int doWhile = -1, innerDoWhile = -1; String doc = null;
		List<Staff> staff = control.getAllStaffs();
		Staff docFound = new Staff();
		
		do {
			System.out.println("<<Enter Appointment Doctor>>");
			int count = 1;
			for (Staff tempStaff: staff) {
				if(tempStaff.getStaff_type() == 2) {
					System.out.println(count+". "+tempStaff.getStaff_name()+" ("+tempStaff.getStaff_id()+")");
					count++;
				}
			}
			do {
				System.out.print(">> Choice (Enter DocID): ");
				try {
					doc = stringInputValidation();
					docFound = validateDoctor(doc);
					if(docFound != null) {
						innerDoWhile = 1;
						doWhile = 1;
					}
					else {
						System.out.println("<<Incorrect DocID!>>");
						innerDoWhile = 0;
					}	
				}   
				catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
					bufferFor5Miliseconds();
					innerDoWhile = 0;} 
			}while(innerDoWhile != 1);
		
		}while(doWhile != 1);
		return docFound;
	}
	public Staff validateDoctor(String id) {
		List<Staff> staff = control.getAllStaffs();
		for (Staff tempStaff: staff) {
			if(tempStaff.getStaff_type() == 2) 
				if(tempStaff.getStaff_id().equals(id))
					return tempStaff;
			else
				continue;
		}
		return null;
	}
	public String convertStatus(int status) {
		switch(status) {
			case 1:
				return "Booked";
			case 2: 
				return "Consulted";
			case 3:
				return "Cancelled";
			default:
				return null;
		}
	}
	public String promptInputPatientName() {
		int doWhile = -1; String name = null;
		do {
			System.out.print("Enter Patient Name: ");
			try {
				name = stringInputValidation();
				doWhile = 1;
			}   
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();
				doWhile = 0;} 
		}while(doWhile != 1);
		return name;
	}
	public String promptInputPatientContact() {
		int doWhile = -1; String contact = null;
		do {
			System.out.print("Enter Patient Contact: ");
			try {
				contact = stringInputValidation();
				doWhile = 1;
			}   
			catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				bufferFor5Miliseconds();
				doWhile = 0;} 
		}while(doWhile != 1);
		return contact;
	}
	
	public Patient checkIfPatientExist(String name, String contact) {
    	List<Patient> patient = control.getAllPatients();
		
		for (Patient tempPatient: patient) {
			if(tempPatient.getPatient_name().equals(name))
				if(tempPatient.getPatient_contact().equals(contact))
					return tempPatient; // exist
			else
				continue; // doesnt exist
		}
		return null;
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
