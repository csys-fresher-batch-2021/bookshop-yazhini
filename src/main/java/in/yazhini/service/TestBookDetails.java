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
	public static boolean addBook(String bookName,String authorName,float bookPrice, float noOfBooks) {
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
