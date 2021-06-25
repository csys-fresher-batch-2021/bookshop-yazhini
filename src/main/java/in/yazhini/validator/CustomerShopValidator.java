package in.yazhini.validator;

import in.yazhini.dao.BookDao;
import in.yazhini.exception.ValidatorException;
import in.yazhini.model.BookDetails;

public class CustomerShopValidator {
	private CustomerShopValidator() {
		// default constructor
	}

	/**
	 * check whether Quantity is valid or not
	 * 
	 * @param bookName
	 * @param noOfBooks
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidQuantity(int noOfBooks, String bookName) {
		int quantity = 0;
		for (BookDetails book : BookDao.getBookList()) {
			if (book.getBookName().equals(bookName)) {
				quantity = book.getNoOfBooks();
				if (quantity < noOfBooks) {
					throw new ValidatorException("InSufficient Quantity");
				}
			}
		}
	}

	/**
	 * check whether bookName is valid or not
	 * 
	 * @param bookName
	 * @throws ValidatorException
	 * @return
	 */
	public static void isValidBookName(String bookName) {
		boolean isValid = false;
		for (BookDetails book : BookDao.getBookList()) {
			if (book.getBookName().equals(bookName)) {
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			throw new ValidatorException("InValid BookName");
		}
	}
}
