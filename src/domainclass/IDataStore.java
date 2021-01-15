package domainclass;
import java.util.List;

public interface IDataStore {

	public List<Staff> getAllStaffs();
	public List<Patient> getAllPatients();
	public List<Appointment> getAllAppointments();
	
	public void addStaff(Staff stf);
	public void addPatient(Patient pti);
	
	public void addAppointment(Appointment appt);
}
