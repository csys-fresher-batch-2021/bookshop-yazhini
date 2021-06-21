package in.yazhini.service;

import in.yazhini.dao.BookDao;

import in.yazhini.exception.ServiceException;
import in.yazhini.model.BookDetails;
import in.yazhini.model.CustomerShop;
import in.yazhini.validator.CustomerShopValidator;

public class TestCustomerShop {
	private TestCustomerShop() {
		// default constructor
	}

	public static CustomerShop shoppingList(String bookName, int noOfBooks, String userName) {
		double price = 0;
		double gst = 0.05;
		CustomerShop shop = new CustomerShop();
		Integer bookId;
		try {
			CustomerShopValidator.isValidQuantity(noOfBooks, bookName);
			CustomerShopValidator.isValidBookName(bookName);
			for (BookDetails book : BookDao.getBookList()) {
				if (book.getBookName().equals(bookName))

				{

					// get the bookprice

					price = book.getBookPrice();

					// validate the price and noofbooks

					double totalAmount = price * noOfBooks;

					// validate the totalamount and gst
					double gstAmount = (totalAmount * gst) + totalAmount;

					// store the details in above object
					shop.setBookName(bookName);
					shop.setNoOfBooks(noOfBooks);
					shop.setPrice(price);
					shop.setTotalAmount(totalAmount);
					shop.setGst(gstAmount);
					bookId = book.getBookId();
					shop.setBookId(bookId);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return shop;
	}
}