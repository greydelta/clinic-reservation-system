package domainclass;
import java.util.*;

public class DataLists implements IDataStore{

	// Lists to store data
	private List<Staff> staff;
	private List<Patient> patient;
	private List<Appointment> appointment;
	
	// Constructor
	public DataLists() {
		this.staff = new ArrayList<>();
		this.patient = new ArrayList<>();
		this.appointment = new ArrayList<>();
	}
	
	// Accessor methods
	public List<Staff> getAllStaffs(){
		return this.staff;
	}
	public List<Patient> getAllPatients(){
		return this.patient;
	}
	public List<Appointment> getAllAppointments(){
		return this.appointment;
	}
}