package in.yazhini.model;

public class CustomerShop {
	public CustomerShop() {

	}

	private String bookName;
	private Integer noOfBooks;
	private Double price;
	private Double totalAmount;
	private double gst;

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

//create a constructor to the details
	public String getBookName() {
		return bookName;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public Double getPrice() {
		return price;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Double getGst() {
		return gst;
	}

	public CustomerShop(String bookName, Integer noOfBooks, Double price, Double totalAmount, Double gst) {
		super();
		this.bookName = bookName;
		this.noOfBooks = noOfBooks;
		this.price = price;
		this.totalAmount = totalAmount;
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "CustomerShop [bookName=" + bookName + ", noOfBooks=" + noOfBooks + ", price=" + price + ", totalAmount="
				+ totalAmount + ", gst=" + gst + "]";
	}

}
