package domainclass;
import java.util.*;

public class Controller {

	private IDataStore dataLists;
	
	// Accessor Methods
	public Controller(IDataStore dataLists) {
		this.dataLists = dataLists;
	}

	public List<Staff> getAllStaffs(){
		return dataLists.getAllStaffs();
	}
	
	public List<Patient> getAllPatients(){
		return dataLists.getAllPatients();	
	}
	
	public List<Appointment> getAllAppointments(){
		return dataLists.getAllAppointments();
	}
}
