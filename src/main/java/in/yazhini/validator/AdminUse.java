package in.yazhini.validator;

import java.util.List;
import java.util.ArrayList;

import in.yazhini.model.BookDetails;

public class AdminUse {
	private AdminUse() {

	}

	static List<BookDetails> bookList = new ArrayList<>();

	// For purpose of Add the BookDetails to the Admin//
	public static void addBookDetails(BookDetails... books) {

		for (BookDetails bookDetails : books) {
			bookList.add(bookDetails);

		}
	}

	// Count the Number of books
	public static int noOfBookName() {
		return bookList.size();

	}

	public static void displayBooks() {

		// R2: Display BookDetails
		for (BookDetails bookName : bookList) {
			System.out.println(bookName);
		}
	}
}
