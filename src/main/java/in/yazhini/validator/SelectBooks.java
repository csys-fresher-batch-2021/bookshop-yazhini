package in.yazhini.validator;

import java.util.ArrayList;

import in.yazhini.service.CustomerSelectBooks;

public class SelectBooks {
	private SelectBooks() {
	}

	public static ArrayList<String> Validates(String bookName, String authorName, Integer noOfBooks) {
		ArrayList<String> errors = new ArrayList<String>();
		boolean bookNameValidation = CustomerSelectBooks.checkBookName(bookName);
		if (bookNameValidation == false)
		// To check the input is proper or not that can be uesd to Boolean Validation//
		{
			errors.add("BookName is InValid");

			boolean noOfBooksValidation = CustomerSelectBooks.validateNoOfBooks(bookName, noOfBooks);
			if (noOfBooksValidation == false) {
				errors.add("NoOfBooks is InValid");
			}
		}

		return errors;
	}
}
