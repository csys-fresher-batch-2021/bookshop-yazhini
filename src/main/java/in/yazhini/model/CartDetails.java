package in.yazhini.model;

public class CartDetails {

	public CartDetails() {
		super();

	}

	@Override
	public String toString() {
		return "CartDetails [id=" + id + ", bookDetails=" + bookDetails + ", userDetails=" + userDetails + "]";
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	private BookDetails bookDetails;
	private UserDetails userDetails;

}
