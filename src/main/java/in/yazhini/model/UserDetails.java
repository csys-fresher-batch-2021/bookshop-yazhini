package in.yazhini.model;

public class UserDetails {
	public UserDetails() {
		//default constructor

	}

	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password + ", userId=" + userId + "]";
	}

	private String userName;
	private String password;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
