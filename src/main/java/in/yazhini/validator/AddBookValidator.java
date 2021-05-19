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
		boolean isValid = false;
		if (!bookName.equals("null") && !bookName.trim().equals("")) {
			isValid = true;
		}
		return isValid;
	}
	public static boolean isValidAuthorName(String authorName) {
		boolean isValid = false;
		if (!authorName.equals("null") && !authorName.trim().equals("")) {
			isValid = true;
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
		if (bookPrice > 0){
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean isValidNoOfBooks(Float noOfBooks) {
		boolean isValid = false;
		if (noOfBooks > 0){
			isValid = true;
		}
		return isValid;

	}
}
	
			

