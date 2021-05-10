package in.yazhini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAdminPage {
	/** Declare the Valid Admin Details **/
	@Test
	public void testCase1() {
		String userName = "Yazhini";
		String userId = "Admin123";
		boolean login = UserService.login(userName, userId);
		assertTrue(login);
	}

	/** Declare the InValid Admin Details **/
	@Test
	public void testCase2() {
		String userName = "Yazhini";
		String userId = "1234567890";
		boolean login=UserService.login(userName, userId);
		assertFalse(login);
	}

}
