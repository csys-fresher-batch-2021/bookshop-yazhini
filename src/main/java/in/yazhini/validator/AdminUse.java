package in.yazhini.validator;

import java.util.List;
import java.util.ArrayList;

import in.yazhini.model.BookDetails;

public class AdminUse {
	private AdminUse() {

	}

	static List<BookDetails> bookLists = new ArrayList<BookDetails>();

	// For purpose of Add the BookDetails to the Admin//
	public static void addBookDetails(BookDetails... books) {

		for (BookDetails bookDetails : books) {
			bookLists.add(bookDetails);

		}
	}

	// Count the Number of books
	public static int noOfBookName() {
		int noOfBookName = bookLists.size();
		return noOfBookName;
	}

	public static void displayBooks() {

		// R2: Display BookDetails

		for (BookDetails bookName : bookLists) {
			System.out.println("bookName");
		}
	}
}
