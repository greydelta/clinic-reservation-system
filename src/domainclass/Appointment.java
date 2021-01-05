package domainclass;

public class Appointment {

	private int appointment_id;
	private String appointment_status; // 3 status: Booked, Cancelled, Consulted
	private String appointment_date;
	private String appointment_time;
	private Staff appointment_doc; // Can select from list of staff where userType = 2 (Doctor)
	private Patient appointment_patient;
	
	public Appointment() {
		this.setAppointment_id(0);
		this.setAppointment_status(null);
		this.setAppointment_date(null);
		this.setAppointment_time(null);
	}
	
	public Appointment(int appointment_id, String appointment_status, String appointment_date,
			String appointment_time, Staff appointment_doc, Patient appointment_patient) {
		this.setAppointment_id(appointment_id);
		this.setAppointment_status(appointment_status);
		this.setAppointment_date(appointment_date);
		this.setAppointment_time(appointment_time);
		this.appointment_doc = appointment_doc;
		this.appointment_patient = appointment_patient;
	}
	
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getAppointment_status() {
		return appointment_status;
	}

	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}

	public Staff getAppointment_doc() {
		return this.appointment_doc;
	}

	public Patient getAppointment_patient() {
		return this.appointment_patient;
	}
}
