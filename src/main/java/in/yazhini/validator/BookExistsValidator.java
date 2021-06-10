package in.yazhini.validator;

import java.util.List;

import in.yazhini.dao.BookDao;
import in.yazhini.model.BookDetails;


public class BookExistsValidator {
	
	public BookExistsValidator() {
	}

	public static void existsBook(String bookName, String authorName) {

		List<BookDetails> bookList = BookDao.getBookList();

		try {
			for (BookDetails books : bookList) {

				if (books.getBookName().equalsIgnoreCase(bookName)) {

					throw new RuntimeException("BookName already Exists");
				}
				if (books.getAuthorName().equalsIgnoreCase(authorName)) {

					throw new RuntimeException("AuthorName already Exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
