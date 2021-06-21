package in.yazhini.validator;

import in.yazhini.dao.UserDao;
import in.yazhini.model.UserDetails;

public class LoginPage {
	private LoginPage() {
		// default constructor
	}

//admin login to the standard input
	public static boolean adminLogin(String userName, String password, String role) {
		boolean isAdmin = false;
		if (userName.trim().equals("Yazhini") && password.trim().equals("Admin123") && role.trim().equals("ADMIN")) {
			isAdmin = true;
		}
		return isAdmin;
	}

// customer login  to store the database
	public static boolean customerLogin(String userName, String password) {
		boolean isCustomer = false;
		for (UserDetails user : UserDao.getUserList()) {

			if (userName.trim().equals(user.getUserName()) && password.trim().equals(user.getPassword())) {
				isCustomer = true;
				break;
			}

		}
		return isCustomer;
	}
}
