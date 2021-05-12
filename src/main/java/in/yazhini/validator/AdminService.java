package in.yazhini.validator;

public class AdminService {

	// validate the data in Adminuser

	private AdminService() {

	}

	public static boolean login(String userName, String password, String role) {
		boolean isAdmin = false;
		if (userName.trim().equals("Yazhini") && password.trim().equals("Admin123") && role.trim().equals("ADMIN")) {
			isAdmin = true;
		}
		return isAdmin;
	}
}
