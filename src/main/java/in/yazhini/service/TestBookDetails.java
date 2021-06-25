package in.yazhini.service;

import in.yazhini.dao.BookDao;
import in.yazhini.exception.DBException;
import in.yazhini.exception.ServiceException;
import in.yazhini.model.BookDetails;
import in.yazhini.validator.AddBookValidator;
import in.yazhini.validator.BookExistsValidator;

public class TestBookDetails {
	/**
	 * AddBooks
	 * 
	 * @param Shop
	 * @throws ClassNotFoundException
	 * @throws ServiceException
	 * @return
	 */
	public static void addBook(BookDetails books) throws ServiceException {
		try {
			AddBookValidator.isValidBookName(books.getBookName());
			AddBookValidator.isValidBookName(books.getBookName());
			AddBookValidator.isValidAuthorName(books.getAuthorName());
			AddBookValidator.isValidBookPrice(books.getBookPrice());
			AddBookValidator.isValidNoOfBooks(books.getNoOfBooks());
			BookExistsValidator.existsBook(books.getBookName(), books.getAuthorName());
			BookDao.addBook(books.getBookName(), books.getAuthorName(), books.getBookPrice(), books.getNoOfBooks());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * DeleteBooks
	 * 
	 * @param bookName
	 * @param authorName
	 * @throws ClassNotFoundException
	 * @throws DBException
	 * @throws ServiceException
	 * @return
	 */
	public static void deleteBook(String bookName, String authorName) {
		boolean isValid = false;
		try {
			for (BookDetails books : BookDao.getBookList()) {
				if (books.getBookName().equals(bookName) && books.getAuthorName().equals(authorName)) {
					BookDao.deleteBook(bookName, authorName);
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				throw new ServiceException("No Mathching Books Found");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
