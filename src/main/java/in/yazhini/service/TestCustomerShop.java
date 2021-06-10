package in.yazhini.service;

import in.yazhini.dao.CustomerShopDao;
import in.yazhini.model.BookDetails;
import in.yazhini.model.CustomerShop;
import in.yazhini.validator.CustomerShopValidator;

public class TestCustomerShop {
	private TestCustomerShop() {

	}

	// store the details in list
	public static CustomerShop shoppingList(String bookName, int noOfBooks) {
		double price = 0;
		double gst = 0.05;
		CustomerShop shop = new CustomerShop();

		try {
			for (BookDetails book : TestBookDetails.getBookList()) {

				// bookname and noofbooks validation

				if (book.getBookName().equalsIgnoreCase(bookName)
						&& CustomerShopValidator.isValidQuantity(noOfBooks, bookName)) {

					// get the bookprice

					price = book.getBookPrice();

					// validate the price and noofbooks

					double totalAmount = price * noOfBooks;

					// validate the totalamount and gst
					double gstAmount = (totalAmount * gst) + totalAmount;

					shop.setBookName(bookName);
					shop.setNoOfBooks(noOfBooks);
					shop.setPrice(price);
					shop.setTotalAmount(totalAmount);
					shop.setGst(gstAmount);

//					purchase.add(shop);
					CustomerShopDao.addDetails(bookName, noOfBooks, price, totalAmount, gstAmount);

				}

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return shop;
	}
}
