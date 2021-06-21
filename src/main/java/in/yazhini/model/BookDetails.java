package in.yazhini.model;

public class BookDetails {
	public BookDetails() {
		// default constructor
	}

	private Integer bookId;
	private String bookName;
	private String authorName;
	private Float bookPrice;
	private Integer noOfBooks;

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public Integer getBookId() {
		return bookId;
	}

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

	public BookDetails(Integer bookId, String bookName, String authorName, Float bookPrice, Integer noOfBooks) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
		this.noOfBooks = noOfBooks;

	}

	// To declare the Booklist in purpose of retrieve
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ",bookName=" + bookName + ", authorName=" + authorName + ", bookPrice="
				+ bookPrice + ", noOfBooks=" + noOfBooks + "]";
	}

}
