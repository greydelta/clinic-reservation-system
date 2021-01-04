package domainclass;

public class Patient {

	private int patient_id;
	private String patient_name;
	private String patient_contact;
	
	// Constructor
	public Patient() {
		this.setPatient_id(0);
		this.setPatient_name(null);
		this.setPatient_contact(null);
	}
	
	public Patient(int patient_id, String patient_name, String patient_contact) {
		this.setPatient_id(patient_id);
		this.setPatient_name(patient_name);
		this.setPatient_contact(patient_contact);
	}

	// Accesor Methods
	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_contact() {
		return patient_contact;
	}

	public void setPatient_contact(String patient_contact) {
		this.patient_contact = patient_contact;
	}
}
