package in.yazhini.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBookValidator {
	private AddBookValidator() {
		// default constructor
	}

	/**
	 * validate if book name is null or not & if book name is empty space or not
	 * 
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean isValidBookName(String bookName) {
		boolean valid = false;
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(bookName);
		if (matcher.matches()) {
			return valid = true;
		}
		return valid;
	}

	/**
	 * validate if author name is null or not & if author name is empty space or not
	 * 
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean isValidAuthorName(String authorName) {
		boolean valid = false;

		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(authorName);
		if (matcher.matches()) {
			return valid = true;
		}
		return valid;
	}

	/**
	 * check whether cost is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean isValidBookPrice(float bookPrice) {
		boolean isValid = false;
		if (bookPrice > 0) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * check whether NoOfBook is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean isValidNoOfBooks(int noOfBooks) {
		boolean isValid = false;
		if (noOfBooks > 0) {
			isValid = true;
		}
		return isValid;

	}
}