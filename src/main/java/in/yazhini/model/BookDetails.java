package in.yazhini.model;

public class BookDetails {
	private String bookName;
	private String authorName;
	private Float bookPrice;
	private Integer noOfBooks;

//create a constructor to the details
	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public BookDetails(String bookName, String authorName, Float bookPrice, Integer noOfBooks) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
		this.noOfBooks = noOfBooks;
	}

	// To declare the Booklist in purpose of retrieve
	@Override
	public String toString() {
		return "BookDetails [bookName=" + bookName + ", authorName=" + authorName + ", bookPrice=" + bookPrice
				+ ", noOfBooks=" + noOfBooks + "]";
	}
}
