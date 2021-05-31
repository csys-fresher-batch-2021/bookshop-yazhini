package in.yazhini.validator;

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
		boolean isValid = true;

		String regex = ".*[0-9@$%^=()./#&+-].*";
		if (bookName == null || bookName.trim().equals("") || bookName.matches(regex) || bookName.length() < 3) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * validate if author name is null or not & if author name is empty space or not
	 * 
	 * 
	 * @param bookName
	 * @return
	 */
	public static boolean isValidAuthorName(String authorName) {
		boolean isValid = true;

		String regex = ".*[0-9@$%^=()./#&+-].*";
		if (authorName == null || authorName.trim().equals("") || authorName.matches(regex)
				|| authorName.length() < 3) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * check whether cost is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean isValidBookPrice(Float bookPrice) {
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
