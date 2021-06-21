package in.yazhini.service;

import in.yazhini.dao.UserDao;
import in.yazhini.exception.ServiceException;

import in.yazhini.model.UserDetails;

import in.yazhini.validator.UserValidator;

public class TestUser {
	
	public TestUser() {
	//default constructor	
	}

	public static void addUser(UserDetails users) throws ServiceException {
         
		try {
			//name and password validation
			UserValidator.isValidUserName(users.getUserName());
			UserValidator.isValidPassword(users.getPassword());
			UserValidator.existsUser(users.getUserName());
			UserDao.addUser(users);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
