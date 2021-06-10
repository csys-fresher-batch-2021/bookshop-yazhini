package in.yazhini.validator;

import java.util.List;

import in.yazhini.model.BookDetails;
import in.yazhini.service.TestBookDetails;

public class BookExistsValidator {
	public static void existsBook(String bookName, String authorName) {

		List<BookDetails> bookList = TestBookDetails.getBookList();

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
