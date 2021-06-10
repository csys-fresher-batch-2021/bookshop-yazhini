package in.yazhini.service;

import java.util.ArrayList;

import java.util.List;

import in.yazhini.dao.RegistrationDao;
import in.yazhini.model.BookDetails;
import in.yazhini.model.RegistrationDetails;

import in.yazhini.validator.RegistrationValidator;

public class TestRegistrationDetails {
	private TestRegistrationDetails() {

	}

	private static final List<RegistrationDetails> detailsList = new ArrayList<>();

	public static List<RegistrationDetails> getDetailsList() {
		return detailsList;
	}

	// added a customer details in arraylist
	public static boolean addDetails(String name, String emailId, Long mobileNo, String address, int quantity,
			String bookName) {
		boolean isAdded = false; // all details are validate
		try {
			if ((RegistrationValidator.isValidName(name)) && (RegistrationValidator.isValidEmailId(emailId))
					&& (RegistrationValidator.isValidMobileNo(mobileNo))
					&& (RegistrationValidator.isValidAddress(address))) {
				// create a object to the get the and store the details
				RegistrationDetails details = new RegistrationDetails(name, emailId, mobileNo, address);
				detailsList.add(details);
				// send details in DAO class
				RegistrationDao.addDetails(name, emailId, mobileNo, address);

				for (BookDetails book : TestBookDetails.getBookList()) {
					if (book.getBookName().equalsIgnoreCase(bookName) || (quantity <= book.getNoOfBooks())) {
						book.setNoOfBooks(book.getNoOfBooks() - quantity);
					}
				}
			}
			isAdded = true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return isAdded;
	}
}
