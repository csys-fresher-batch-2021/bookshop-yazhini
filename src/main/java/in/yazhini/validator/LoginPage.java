package in.yazhini.validator;

public class LoginPage {

	// create a costructor to theclass

	private LoginPage() {

	}

//admin login to the standard input
	public static boolean adminLogin(String userName, String password, String role) {
		boolean isAdmin = false;
		if (userName.trim().equals("Yazhini") && password.trim().equals("Admin123") && role.trim().equals("ADMIN")) {
			isAdmin = true;
		}
		return isAdmin;
	}

// customer login to the standard input
	public static boolean customerLogin(String userName, String password, String role) {
		boolean isCustomer = false;
		if (userName.trim().equals("Kani") && password.trim().equals("kani123") && role.trim().equals("CUSTOMER")) {
			isCustomer = true;
		}
		return isCustomer;
	}
}
