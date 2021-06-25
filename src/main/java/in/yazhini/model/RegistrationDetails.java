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

	@Override
	public String toString() {
		return "RegistrationDetails [name=" + name + ", emailId=" + emailId + ", mobileno=" + mobileno + ", address="
				+ address + "]";
	}

}