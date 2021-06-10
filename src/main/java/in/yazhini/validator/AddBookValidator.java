package in.yazhini.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.yazhini.exception.ValidatorException;

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
	public static void isValidBookName(String bookName) {
		
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(bookName);
		if (!matcher.matches()) {
			throw new ValidatorException("InValid BookName");
		}
		
	}

	/**
	 * validate if author name is null or not & if author name is empty space or not
	 * 
	 * 
	 * @param bookName
	 * @return
	 */
	public static void isValidAuthorName(String authorName) {

		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(authorName);
		if (!matcher.matches()) {
			throw new ValidatorException("InValid AuthorName");
		}
		
	}

	/**
	 * check whether cost is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static void isValidBookPrice(float bookPrice) {
	
		if (bookPrice < 200) {
			throw new ValidatorException("InValid BookPrice");
		}
	}

	/**
	 * check whether NoOfBook is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static void isValidNoOfBooks(int noOfBooks) {
	
		if (noOfBooks < 10) {
			throw new ValidatorException("InValid NoOfBooks");
		}
		}
}