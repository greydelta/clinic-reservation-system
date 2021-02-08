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
	
	// Methods
	public void addStaff(Staff stf){
		this.staff.add(stf);
	}
	public void addPatient(Patient pti){
		this.patient.add(pti);
	}
	
	public void addAppointment(Appointment appt){
		this.appointment.add(appt);
	}
	public void updateAppointmentStatus(int appointment_id, String appointment_status) {
		int count = -1;
		for (Appointment tempAppointment: this.appointment) { 
			++count;
			if(tempAppointment.getAppointment_id() == appointment_id) // find appointment
				this.appointment.get(count).setAppointment_status(appointment_status);
		}
	}
	public void updateAppointmentDate(int appointment_id, String appointment_date) {
		int count = -1;
		for (Appointment tempAppointment: this.appointment) {
			++count;
			if(tempAppointment.getAppointment_id() == appointment_id) // find appointment
				this.appointment.get(count).setAppointment_date(appointment_date);
		}
	}
	public void updateAppointmentTime(int appointment_id, String appointment_time) {
		int count = -1;
		for (Appointment tempAppointment: this.appointment) {
			++count;
			if(tempAppointment.getAppointment_id() == appointment_id) // find appointment
				this.appointment.get(count).setAppointment_time(appointment_time);
		}
	}
}
