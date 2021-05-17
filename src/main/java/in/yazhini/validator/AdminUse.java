package in.yazhini.validator;
import java.util.ArrayList;

import in.yazhini.model.BookDetails;

public class AdminUse{
	static ArrayList<BookDetails> bookLists = new ArrayList<BookDetails>();

	// For purpose of Add the BookDetails to the Admin//
	public static void addBookDetails(BookDetails ...books) {

		for (BookDetails bookDetails : books) {
			bookLists.add(bookDetails);
			
		}
		
	  
//		 Display all user details
//		 for (BookDetails user : userList) {
//		 System.out.println(user.BookName + "/" +user.AuthorName + "-" +
//		 user.BookPrice + "-" + user.NoOfBooks);
	}

	// Count the Number of books
	public static int noOfBookName() {
		int noOfBookName = bookLists.size();
		return noOfBookName;
	}

	public static void displayBooks() {

		// R2: Display BookDetails
		System.out.println("############ LIST OF BOOKS #########");
		for (BookDetails bookName : bookLists) {
			System.out.println(bookName);
				}
	}
}

