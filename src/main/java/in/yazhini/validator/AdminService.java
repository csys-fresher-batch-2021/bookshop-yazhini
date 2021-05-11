package in.yazhini.validator;

public class AdminService {

	// validate the data in Adminuser
      private AdminService () {
	
        }
	public static boolean login(String userName, String password) {
		return (userName.trim().equals("Yazhini") && password.trim().equals("Admin123"));

	}
}
