package domainclass;

public class Staff {

	private String staff_id;
	private String staff_password;
	private String staff_name;
	private int staff_type;
	
	// Constructor
	public Staff() {
		this.setStaff_id("");
		this.setStaff_password("");
		this.setStaff_name("");
		this.setStaff_type(0);
	}

	public Staff(String staff_id, String staff_password, String staff_name, int staff_type) {
		this.setStaff_id(staff_id);
		this.setStaff_password(staff_password);
		this.setStaff_name(staff_name);
		this.setStaff_type(staff_type);
	}
	
	// Accesor Methods
	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_password() {
		return staff_password;
	}

	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public int getStaff_type() {
		return staff_type;
	}

	public void setStaff_type(int staff_type) {
		this.staff_type = staff_type;
	}
}
