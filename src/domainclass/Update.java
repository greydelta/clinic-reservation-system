package domainclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Update {
	private String resID;
	private String bookingDate;
	private String fname;
	private String lname;
	private int age;
	private String state;
	private String postcod;

	// constructor
	public Update(String resID,String bookingDate,String fname,String lname,int age,String state,String postcod) {
		this.resID = resID;
		this.bookingDate = bookingDate;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.state = state;
		this.postcod = postcod;
	}

	public Update() {
	}

	// accessors
	public String getID() {
		return resID;
	}

	public String getbookingDate() {
		return bookingDate;
	}

	public String getfname() {
		return fname;
	}

	public String getlname() {
		return lname;
	}

	public int age() {
		return age;
	}

	public String getState() {
		return state;
	}

	public String getPostcod() {
		return postcod;
	}

	// mutators
	public void setbookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}

	public void setlname(String lname) {
		this.lname = lname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostcod(String postcod) {
		this.postcod = postcod;
	}


	// method
	public static ArrayList<Update> initializeUpdate(String filepath) {

		ArrayList<Update> reservation = new ArrayList<Update>();
		String resID,bookingDate,fname,lname,age,state, postcod;

		try {
			Scanner x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");

			while (x.hasNext()) {
				resID = x.next();
				bookingDate = x.next();
				fname = x.next();
				lname = x.next();
				age = x.next();
				state = x.next();
				postcod = x.next();
			}
		} catch (Exception e) {
			System.out.println("create arrayReservation reservation.txt has error!");
		}

		return reservation;
	}

	

	public void updateReservation(ArrayList<Update> arrReservation, String filepath) throws IOException {
		FileWriter old = new FileWriter(filepath);
		old.write("");
		old.close();

		FileWriter update = new FileWriter(filepath, true);
		for (int i = 0; i < arrReservation.size(); i++) {
			if (arrReservation.get(i).getID().equals(resID))
				arrReservation.set(i, this);

			update.write(arrReservation.get(i).getID() + ","
					+ arrReservation.get(i).bookingDate + "," + arrReservation.get(i).fname + ","
					+ arrReservation.get(i).lname + "," + arrReservation.get(i).age + ","
					+ arrReservation.get(i).state + "," +arrReservation.get(i).postcod + ","
					+ "\n");
		}

		update.close();
	}
	
	/*protected static Update n;
	public static void main(String[] args) {
		n = new Update();
		n.initializeUpdate("update.txt");
	}*/
}
