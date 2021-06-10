package in.yazhini.validator;

import in.yazhini.dao.BookDao;

import in.yazhini.model.BookDetails;

public class CustomerShopValidator {
	private CustomerShopValidator() {

	}

	public static boolean isValidQuantity(int noOfBooks, String bookName) {
		boolean isValid = false;
		int quantity = 0;
		for (BookDetails book : BookDao.getBookList()) {

			// bookname and noofbooks validation
			if (book.getBookName().equalsIgnoreCase(bookName)) {
				quantity = book.getNoOfBooks();

				if (quantity >= noOfBooks) {
					isValid = true;
				}
			}

		}
		return isValid;
	}
}
