package in.yazhini.model;

public class RegistrationDetails {
	private String name;
	private String emailId;
	private Long mobileno;
	private String address;

	public String getName() {
		return name;
	}

	public String getEmailId() {
		return emailId;
	}

	public Long getMobileNo() {
		return mobileno;
	}

	public String getAddress() {
		return address;
	}

	public RegistrationDetails(String name, String emailId, Long mobileno, String address) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.mobileno = mobileno;
		this.address = address;
	}

	@Override
	public String toString() {
		return "RegistrationDetails [name=" + name + ", emailId=" + emailId + ", mobileno=" + mobileno + ", address="
				+ address + "]";
	}

}