package in.yazhini.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import in.yazhini.dao.UserDao;
import in.yazhini.exception.ValidatorException;
import in.yazhini.model.UserDetails;

public class UserValidator {
	private UserValidator() {

	}

	/**
	 * check whether userName is valid or not
	 * 
	 * @param userName
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidUserName(String userName) {
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(userName);
		if (!matcher.matches()) {
			throw new ValidatorException("InValid Name");
		}
	}

	/**
	 * check whether password is valid or not
	 * 
	 * @param password
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidPassword(String password) {
		String condition = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			throw new ValidatorException("!!!! InValid PassWord !!!! ");
		}
	}

	/**
	 * check whether userName is exists
	 * 
	 * @param userName
	 * @throws ValidatorException
	 * @return
	 */
	public static void existsUser(String userName) {
		List<UserDetails> userList = UserDao.getUserList();
		try {
			for (UserDetails users : userList) {
				if (users.getUserName().equalsIgnoreCase(userName)) {
					throw new ValidatorException("UserName already Exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(e.getMessage());
		}
	}
}
