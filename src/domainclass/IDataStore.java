package domainclass;
import java.util.List;

public interface IDataStore {

	public List<Staff> getAllStaffs();
	public List<Patient> getAllPatients();
	public List<Appointment> getAllAppointments();
}
