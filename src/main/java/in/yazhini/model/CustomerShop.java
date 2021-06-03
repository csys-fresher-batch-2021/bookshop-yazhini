package in.yazhini.model;

public class CustomerShop {
	private String bookName;
	private Integer noOfBooks;
	private Double price;
	private Double totalAmount;
	
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
	
	public CustomerShop(String bookName, Integer noOfBooks, Double price, Double totalAmount) {
		super();
		this.bookName = bookName;
		this.noOfBooks = noOfBooks;
		this.price = price;
		this.totalAmount = totalAmount;
		
	}

	@Override
	public String toString() {
		return "CustomerShop [bookName=" + bookName + ", noOfBooks=" + noOfBooks + ", price=" + price + ", totalAmount="
				+ totalAmount + "]";
	}

}
