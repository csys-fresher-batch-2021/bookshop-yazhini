package in.yazhini.model;

import java.time.LocalDate;

public class CustomerShop {
	public CustomerShop() {
		// default constructor
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	private Integer bookId;
	private String bookName;
	private Integer noOfBooks;
	private Double price;
	private Double totalAmount;
	private double gst;
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

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

	@Override
	public String toString() {
		return "CustomerShop [bookId=" + bookId + ", bookName=" + bookName + ", noOfBooks=" + noOfBooks + ", price="
				+ price + ", totalAmount=" + totalAmount + ", gst=" + gst + ", date=" + date + "]";
	}

}