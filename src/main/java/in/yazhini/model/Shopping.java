package in.yazhini.model;

import java.time.LocalDateTime;

public class Shopping {
	public Shopping() {
		// default constructor
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public BookDetails getBook() {
		return book;
	}

	public void setBook(BookDetails book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private UserDetails user;
	private BookDetails book;
	private Integer quantity;
	private Double totalAmount;
	private LocalDateTime orderedDate;
	private String name;
	private Long mobileNo;
	private String emailId;
	private String address;
	private String status;

	@Override
	public String toString() {
		return "Shopping [id=" + id + ", user=" + user + ", book=" + book + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + ", orderedDate=" + orderedDate + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", address=" + address + ", status=" + status + "]";
	}

}
