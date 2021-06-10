package in.yazhini.service;

import in.yazhini.dao.BookDao;
import in.yazhini.model.BookDetails;
import in.yazhini.validator.AddBookValidator;
import in.yazhini.validator.BookExistsValidator;

public class TestBookDetails {
	private TestBookDetails() {
	}

//add some books in a book list
	public static void addBook(BookDetails books) throws ClassNotFoundException {

		try {
			AddBookValidator.isValidBookName(books.getBookName());
			AddBookValidator.isValidAuthorName(books.getAuthorName());
			AddBookValidator.isValidBookPrice(books.getBookPrice());
			AddBookValidator.isValidNoOfBooks(books.getNoOfBooks());

			BookExistsValidator.existsBook(books.getBookName(), books.getAuthorName());
			BookDao.addBook(books.getBookName(), books.getAuthorName(), books.getBookPrice(), books.getNoOfBooks());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

//delete some book in booklist
	public static boolean deleteBook(String bookName, String authorName) {

		boolean isDeleted = false;
		BookDetails searchProduct = null;
		for (BookDetails books : BookDao.getBookList()) {

			if (books.getBookName().equalsIgnoreCase(bookName) && books.getAuthorName().equalsIgnoreCase(authorName)) {
				BookDao.deleteBook(bookName, authorName);
				searchProduct = books;
				break;
			}
		}
		if (searchProduct != null) {
			BookDao.getBookList().remove(searchProduct);
			isDeleted = true;
		}
		return isDeleted;
	}

}
