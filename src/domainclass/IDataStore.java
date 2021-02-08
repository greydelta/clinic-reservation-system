package domainclass;
import java.util.List;

public interface IDataStore {

	public List<Staff> getAllStaffs();
	public List<Patient> getAllPatients();
	public List<Appointment> getAllAppointments();
	
	public void addStaff(Staff stf);
	public void addPatient(Patient pti);
	
	public void addAppointment(Appointment appt);
	public void updateAppointmentStatus(int appointment_id, String appointment_status);
	public void updateAppointmentDate(int appointment_id, String appointment_date);
	public void updateAppointmentTime(int appointment_id, String appointment_time);
}
