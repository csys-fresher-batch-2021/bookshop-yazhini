package in.yazhini;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import in.yazhini.model.BookDetails;
import in.yazhini.validator.AdminUse;

public class TestBookDetails {

	@Test
	public void testCase() {
		

	}
		/**
		 * This method used to add book details and display books
		 * 
		 * @param args
		 */
		
		
	
		private static List <BookDetails>bookList=new ArrayList<BookDetails>();
    static {
    	System.out.println("\n BOOK DETAILS");
		System.out.println("BookName-AuthorName-BookPrice-NoOfBooks\n");
		BookDetails book1 = new BookDetails("TamilNovels","Thiruvalluvar",200f,10f); /**
												 * Store the available books user1.BookName = "Tamil Novels"; And
												 * authors name,price amount, user1.AuthorName="Thiruvalluvar"; then
												 * available number of books
												 **/
		//book1.bookName = "TamilNovels";
		//book1.authorName = "Thiruvalluvar";
		//book1.bookPrice = 200f;
		//book1.noOfBooks = 10f;

		BookDetails book2 = new BookDetails("English Novels","George Orwell",250f,20f);
		//book2.bookName = "English Novels";
		//book2.authorName = "George Orwell";
		//book2.bookPrice = 250f;
		//book2.noOfBooks = 20f;

		BookDetails book3 = new BookDetails("Mathematical Discoveries","Srinivasa Ramanujan",300f,10f);
		//book3.bookName = "Mathematical Discoveries";
		//book3.authorName = "Srinivasa Ramanujan";
		//book3.bookPrice = 300f;
		//book3.noOfBooks = 10f;

		BookDetails book4 = new BookDetails("GK-India at Risk","Jaswant Singh",220f,30f);
		//book4.bookName = "GK-India at Risk";
		//book4.authorName = "Jaswant Singh";
		//book4.bookPrice = 220f;
		//book4.noOfBooks = 30f;
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
	
    
		AdminUse.addBookDetails(book1, book2, book3, book4); // Call the AdminUse to display the Books

		int count1 = AdminUse.noOfBookName();
		System.out.println("Total NoOfBook is =" + count1);

		AdminUse.displayBooks();

		// 3 functionalities - add book , list books, count books

	}

}
