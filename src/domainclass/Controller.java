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
	
	// Methods
	public void addStaff(String staff_id, String staff_password, String staff_name, int staff_type) {
		Staff staff = new Staff(staff_id, staff_password, staff_name, staff_type);
		dataLists.addStaff(staff);
	}
	
	public void addPatient(int patient_id, String patient_name, String patient_contact) {
		Patient patient = new Patient(patient_id, patient_name, patient_contact);
		dataLists.addPatient(patient);
	}
	
	public void updatePatient(Patient existingPatient, String patient_name, String patient_contact) {
		dataLists.updatePatient(existingPatient, patient_name, patient_contact);
	}
	
	public void addAppointment(int appointment_id, String appointment_status, String appointment_date,
			String appointment_time, Staff appointment_doc, Patient appointment_patient) {
		
		Appointment appointment = new Appointment(appointment_id, appointment_status, appointment_date,
				appointment_time, appointment_doc, appointment_patient);
		
		dataLists.addAppointment(appointment);
	}
	
	public void updateAppointmentStatus(int appointment_id, String appointment_status) {
		dataLists.updateAppointmentStatus(appointment_id, appointment_status);
	}
	
	public void updateAppointmentDate(int appointment_id, String appointment_date){
		dataLists.updateAppointmentDate(appointment_id, appointment_date);
	}
	
	public void updateAppointmentTime(int appointment_id, String appointment_time) {
		dataLists.updateAppointmentTime(appointment_id, appointment_time);
	}
}
