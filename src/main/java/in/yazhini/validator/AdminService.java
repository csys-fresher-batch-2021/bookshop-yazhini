package in.yazhini.validator;

public class AdminService {

	// validate the data in Adminuser

	public static boolean login(String userName, String password) {
		return (userName.trim().equals("Yazhini") && password.trim().equals("Admin123"));

	}
}
