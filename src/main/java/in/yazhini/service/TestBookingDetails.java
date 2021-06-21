package in.yazhini.service;

import in.yazhini.dao.BookDao;
import in.yazhini.dao.BookingDAO;
import in.yazhini.exception.ServiceException;
import in.yazhini.model.BookDetails;
import in.yazhini.model.Shopping;
import in.yazhini.validator.RegistrationValidator;

public class TestBookingDetails {

	public TestBookingDetails() {
		//default constructor
	}

	public static void bookingDetails(Shopping shop, String bookName, int quantity) {
		int bookQuantity = 0;
		try {
                 //validation in booking details
			         RegistrationValidator.isValidName(shop.getName());
					 RegistrationValidator.isValidEmailId(shop.getEmailId());
					 RegistrationValidator.isValidMobileNo(shop.getMobileNo());
					 RegistrationValidator.isValidAddress(shop.getAddress()); 

				for (BookDetails book : BookDao.getBookList()) {
					if (book.getBookName().equals(bookName) && (quantity <= book.getNoOfBooks())) {
						bookQuantity = (book.getNoOfBooks() - quantity);
						break;
					}
				}

				BookingDAO.addBooking(shop);
				BookDao.updateBook(bookName, bookQuantity);


		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}