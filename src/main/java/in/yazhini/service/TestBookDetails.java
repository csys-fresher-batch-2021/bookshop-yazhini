package in.yazhini.service;

import java.util.ArrayList;


import java.util.List;

import in.yazhini.model.BookDetails;


public class TestBookDetails {
	private TestBookDetails() {
	}

//add the book details in standard
	private static final List<BookDetails> bookList = new ArrayList<>();
	static {

		BookDetails book1 = new BookDetails("TamilNovels", "Thiruvalluvar", 200f, 10f);
		bookList.add(book1);
		BookDetails book2 = new BookDetails("English Novels", "George Orwell", 250f, 20f);
		bookList.add(book2);
		BookDetails book3 = new BookDetails("Mathematical Discoveries", "Srinivasa Ramanujan", 300f, 10f);
		bookList.add(book3);
		BookDetails book4 = new BookDetails("GK-India at Risk", "Jaswant Singh", 220f, 30f);
		bookList.add(book4);

	}

	public static List<BookDetails> getBookList() {
		return bookList;
	}

//Add the book details in dynamically
	//public static boolean addBook(String bookName, String authorName, float bookPrice, float noOfBooks) {

		//if (AddBookValidator.isValidBookName(bookName) && (AddBookValidator.isValidAuthorName(authorName)
				//&& (AddBookValidator.isValidBookPrice(bookPrice) && (AddBookValidator.isValidNoOfBooks(noOfBooks))))) {

			//BookDetails newBookList = new BookDetails(bookName, authorName, bookPrice,noOfBooks);
			//bookList.add(newBookList);
			//return true;
		//}
		//return false;

	//}
}
