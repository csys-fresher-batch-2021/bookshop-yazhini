package in.yazhini.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import in.yazhini.exception.ValidatorException;

public class RegistrationValidator {
	private RegistrationValidator() {
	}

	/**
	 * check whether Name is valid or not
	 * 
	 * @param Name
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidName(String name) {
		String regex = ".*[0-9@$%^=()./#&+-].*";
		if (name == null || name.trim().equals("") || name.matches(regex) || name.length() < 3) {
			throw new ValidatorException("!!!!  InValid UserName !!!!");
		}
	}

	/**
	 * check whether emailId is valid or not
	 * 
	 * @param emailId
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidEmailId(String emailId) {
		String condition = "[A-Za-z0-9+._-]+@[a-z]+[.][a-z]{2,3}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(emailId);
		if (!matcher.matches()) {
			throw new ValidatorException("!!!!  InValid Email-Id !!!!");
		}
	}

	/**
	 * check whether mobileNo is valid or not
	 * 
	 * @param mobileNo
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidMobileNo(Long mobileNo) {
		String mobileNumber = mobileNo.toString();
		String condition = "[6-9]{1}[0-9]{9}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(mobileNumber);
		if (!matcher.matches()) {
			throw new ValidatorException("!!!! InValid MobileNo !!!!");
		}
	}

	/**
	 * check whether address is valid or not
	 * 
	 * @param address
	 * @throws ValidatorException
	 * @return
	 */

	public static void isValidAddress(String address) {
		if ((address.length() <= 3) || (address == null) || (address.trim().equals(""))) {
			throw new ValidatorException("!!!! InValid Address !!!!");
		}
	}
}