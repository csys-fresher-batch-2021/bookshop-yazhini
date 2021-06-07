package in.yazhini.service;

import java.util.ArrayList;

import java.util.List;

import in.yazhini.dao.CustomerShopDao;
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
		double gst = 0.05;
		for (BookDetails add : TestBookDetails.getBookList()) {

			// bookname and noofbooks validation
			try {
				if (add.getBookName().equalsIgnoreCase(bookName)
						&& CustomerShopValidator.isValidQuantity(noOfBooks, bookName)) {

					// get the bookprice

					price = add.getBookPrice();

					// validate the price and noofbooks

					double totalAmount = price * noOfBooks;

					// validate the totalamount and gst
					double gstAmount = (totalAmount * gst) + totalAmount;

					CustomerShop shop = new CustomerShop(bookName, noOfBooks, price, totalAmount, gstAmount);
					purchase.add(shop);
					CustomerShopDao.addDetails(bookName, noOfBooks, price, totalAmount, gstAmount);
					isAdded = true;
					break;

				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return isAdded;
	}

	public static List<CustomerShop> getOrders() {
		return purchase;
	}
}
