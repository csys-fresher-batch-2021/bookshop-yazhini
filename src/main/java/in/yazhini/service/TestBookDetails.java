package in.yazhini.service;

import java.util.ArrayList;

import java.util.List;

import in.yazhini.dao.BookDao;
import in.yazhini.model.BookDetails;
import in.yazhini.validator.AddBookValidator;
import in.yazhini.validator.BookExistsValidator;

public class TestBookDetails {
	private TestBookDetails() {

	}

	// list of bookdetails to stored in array list
	private static final List<BookDetails> bookList = new ArrayList<>();
	static {

		BookDetails book1 = new BookDetails("TamilNovels", "Thiruvalluvar", 200f, 10);
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

//add some books in a book list
	public static boolean addBook(BookDetails books) throws ClassNotFoundException {
		boolean isAdded = false;

		if ((AddBookValidator.isValidBookName(books.getBookName()))
				&& (AddBookValidator.isValidAuthorName(books.getAuthorName()))
				&& (AddBookValidator.isValidBookPrice(books.getBookPrice()))
				&& (AddBookValidator.isValidNoOfBooks(books.getNoOfBooks()))) {

			BookExistsValidator.existsBook(books.getBookName(), books.getAuthorName());
			BookDetails books1 = new BookDetails(books.getBookName(), books.getAuthorName(), books.getBookPrice(),
					books.getNoOfBooks());
			bookList.add(books1);

			BookDao.addBook(books.getBookName(), books.getAuthorName(), books.getBookPrice(), books.getNoOfBooks());
			isAdded = true;
		}
		return isAdded;
	}

//delete some book in booklist
	public static boolean deleteBook(String bookName, String authorName) {

		boolean isDeleted = false;
		BookDetails searchProduct = null;
		for (BookDetails books : bookList) {

			if ((books.getBookName().equalsIgnoreCase(bookName)
					&& (books.getAuthorName().equalsIgnoreCase(authorName)))) {
				searchProduct = books;
				try {
					BookDao.deleteBook(bookName, authorName);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
				break;
			}
		}
		if (searchProduct != null) {
			bookList.remove(searchProduct);
			isDeleted = true;
		}
		return isDeleted;
	}

}
