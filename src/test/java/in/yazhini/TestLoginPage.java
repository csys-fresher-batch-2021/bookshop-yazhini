package in.yazhini;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.yazhini.validator.LoginPage;

public class TestLoginPage {
	/**
	 * Declare the Valid Admin Details
	 * 
	 * @param role
	 **/
	@Test
	public void adminValidation() {
		String userName = "Yazhini";
		String password = "Admin123";
		String role = "ADMIN";
		boolean login = LoginPage.adminLogin(userName, password, role);
		assertTrue(login);
	}

	/** Declare the valid Customer Details **/
	@Test
	public void customerValidation() {
		String userName = "Kani";
		String password = "kani123";
		String role = "CUSTOMER";
		boolean login = LoginPage.customerLogin(userName, password, role);
		assertTrue(login);
	}

}
