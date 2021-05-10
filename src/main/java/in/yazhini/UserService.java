package in.yazhini;
public class UserService {
	// validate the data in Adminuser
	
	
	public static boolean login(String userName, String password) {
		if (userName.trim().equals("Yazhini") &&password.trim().equals("Admin123") ) {
			return true;
		}
		else {
			return false;
			
		}
	}
	
}
