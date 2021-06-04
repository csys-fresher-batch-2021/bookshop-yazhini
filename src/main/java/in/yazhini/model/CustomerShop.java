package in.yazhini.model;

public class CustomerShop {
	private String bookName;
	private Integer noOfBooks;
	private Double price;
	private Double totalAmount;
	private double gst;

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
