package in.yazhini.validator;

import java.util.regex.Pattern;

public class RegistrationValidator {
	private RegistrationValidator() {

	}

	// name validation
	public static boolean isValidName(String name) {
		boolean isValid = true;

		String regex = ".*[0-9@$%^=()./#&+-].*";
		if (name == null || name.trim().equals("") || name.matches(regex) || name.length() < 3) {
			isValid = false;
		}
		return isValid;
	}

	// emailid validation
	public static boolean isValidEmailId(String emailId) {
		boolean isValid = false;
		String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (Pattern.matches(emailPattern, emailId)) {
			isValid = true;
		}
		return isValid;
	}

	// maobileno validation
	public static boolean isValidMobileNo(Long mobileNo) {

		boolean isValid = false;
		if (mobileNo > 5999999999L) {
			isValid = true;
		}
		return isValid;
	}

	// address validation
	public static boolean isValidAddress(String address) {
		boolean isValid = false;
		int i = 0;
		if (((address.charAt(i) >= 'A' && address.charAt(i) <= 'Z')
				|| (address.charAt(i) >= '0' && address.charAt(i) <= '9')
				|| (address.charAt(i) >= 'a' && address.charAt(i) <= 'z') || (address.charAt(i) == ' ')
				|| (address.charAt(i) == ',') || (address.charAt(i) == '.') || (address.charAt(i) == '/')
				|| (address.charAt(i) == '-')) && (address.length() >= 3)) {
			isValid = true;
		}
		return isValid;
	}
}