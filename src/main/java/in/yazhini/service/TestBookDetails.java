package in.yazhini.service;

import java.util.ArrayList;

import java.util.List;

import in.yazhini.model.BookDetails;
import in.yazhini.validator.AddBookValidator;

public class TestBookDetails {
	private TestBookDetails() {
	}

	private static final List<BookDetails> bookList = new ArrayList<>();
	static {

		BookDetails book1 = new BookDetails("TamilNovels", "Thiruvalluvar", 200f,  10);
		bookList.add(book1);
		BookDetails book2 = new BookDetails("EnglishNovels", "George Orwell", 250f, 20);
		bookList.add(book2);
		BookDetails book3 = new BookDetails("MathematicalDiscoveries", "Srinivasa Ramanujan", 300f, 10);
		bookList.add(book3);
		BookDetails book4 = new BookDetails("GK-India at Risk", "Jaswant Singh", 220f, 30);
		bookList.add(book4);

	}

	public static List<BookDetails> getBookList() {
		return bookList;
	}
	public static boolean addBook(String bookName,String authorName,float bookPrice, int noOfBooks) {
		boolean isAdded=false;
		if ((AddBookValidator.isValidBookName(bookName)) && (AddBookValidator.isValidAuthorName(bookName))
				&&(AddBookValidator.isValidBookPrice(bookPrice))&&(AddBookValidator.isValidNoOfBooks(noOfBooks))){
		
			BookDetails books = new BookDetails(bookName,authorName,bookPrice,noOfBooks);
				bookList.add(books);
				
		isAdded=true;
		}
		return isAdded;
	}
	
}

