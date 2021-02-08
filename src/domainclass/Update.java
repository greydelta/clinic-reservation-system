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

}
