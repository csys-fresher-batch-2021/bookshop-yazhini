package in.yazhini;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.yazhini.validator.AdminService;

public class TestAdminPage {
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
		boolean login = AdminService.adminLogin(userName, password, role);
		assertTrue(login);
	}

	/** Declare the InValid Admin Details **/
	@Test
	public void customerValidation() {
		String userName = "Kani";
		String password = "kani123";
		String role = "CUSTOMER";
		boolean login = AdminService.customerLogin(userName, password, role);
		assertTrue(login);
	}

}
