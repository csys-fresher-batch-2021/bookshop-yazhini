package in.yazhini.validator;

import in.yazhini.model.BookDetails;

import in.yazhini.service.TestBookDetails;

public class CustomerShopValidator {
	private CustomerShopValidator() {
		
	}
	public static boolean isValidQuantity(int noOfBooks, String bookName) {
		boolean isValid = false;
		int quantity = 0;
		for (BookDetails add : TestBookDetails.getBookList()) {

			// bookname and noofbooks validation
			if (add.getBookName().equalsIgnoreCase(bookName)) {
				quantity = add.getNoOfBooks();
				
				if (quantity > noOfBooks) {

					isValid = true;
				}
			}

		}
		return isValid;
	}
}
