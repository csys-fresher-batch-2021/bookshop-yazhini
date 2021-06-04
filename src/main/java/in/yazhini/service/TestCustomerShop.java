package in.yazhini.service;

import java.util.ArrayList;


import java.util.List;

import in.yazhini.model.BookDetails;
import in.yazhini.model.CustomerShop;
import in.yazhini.validator.CustomerShopValidator;

public class TestCustomerShop {
	private TestCustomerShop() {

	}
   
	private static final List<CustomerShop> purchase = new ArrayList<>();

	// store the details in list
	public static boolean shoppingList(String bookName, int noOfBooks) {
		boolean isAdded = false;
		double price = 0;
	    double gst=0.05;
		for (BookDetails add : TestBookDetails. getBookList()) {
			System.out.println("in");
			// bookname and noofbooks validation
			if (add.getBookName().equalsIgnoreCase(bookName) && CustomerShopValidator.isValidQuantity(noOfBooks,bookName)) {
				System.out.println("inout");
				// get the bookprice
				
				price = add.getBookPrice();
				System.out.println(price);
				// validate the price and noofbooks
				
				double totalAmount = price * noOfBooks;
				System.out.println(totalAmount);
				
//				totalAmount1 = add.getTotalAmount();
//				System.out.println(totalAmount1);
				
				double gstAmount = (totalAmount * gst) + totalAmount;
				System.out.println(gstAmount);

				CustomerShop shop = new CustomerShop(bookName, noOfBooks, price, totalAmount,gstAmount);
				purchase.add(shop);

				System.out.println(shop);
             
				isAdded = true;
				break;
			}
		}
		System.out.println("out");
		return isAdded;
	}

	public static List<CustomerShop> getOrders() {
		return purchase;
	} 
}
