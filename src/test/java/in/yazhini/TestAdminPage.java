package in.yazhini;

import static org.junit.Assert.assertFalse;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.yazhini.validator.AdminService;

public class TestAdminPage {
	/** Declare the Valid Admin Details 
	 * @param role **/
	@Test
	public void testCase1() {
		String userName = "Yazhini";
		String password = "Admin123";
		String role ="ADMIN";
		boolean login = AdminService.login(userName, password,role);
		assertTrue(login);
	}

	/** Declare the InValid Admin Details **/
	@Test
	public void testCase2() {
		String userName = "Yazhini";
		String password = "1234567890";
		String role ="Customer";
		boolean login = AdminService.login(userName, password,role);
		assertFalse(login);
	}

}
