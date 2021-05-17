
package in.yazhini.validator;

public class AdminService {

	// validate the data in Adminuser

	private AdminService() {

	}

	public static boolean adminLogin(String userName, String password, String role) {
		boolean isAdmin = false;
		if (userName.trim().equals("Yazhini") && password.trim().equals("Admin123") && role.trim().equals("ADMIN")) {
			isAdmin = true;
		}
		return isAdmin;
	}

	public static boolean customerLogin(String userName, String password, String role) {
		boolean isCustomer = false;
		if (userName.trim().equals("Kani") && password.trim().equals("kani123") && role.trim().equals("CUSTOMER")) {
			isCustomer = true;
		}
		return isCustomer;

	}
}
