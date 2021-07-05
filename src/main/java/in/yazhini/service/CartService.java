package in.yazhini.service;

import in.yazhini.dao.CartDao;

import in.yazhini.exception.DBException;
import in.yazhini.exception.ServiceException;
import in.yazhini.exception.ValidatorException;
import in.yazhini.validator.CartValidator;


public class CartService {

	public static void addcart(int userId,int bookId) throws ServiceException {
		try {
			CartValidator.existsCart(userId,bookId);
			CartDao.addCart(userId,bookId);
			
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	public static void deleteUser(int userId,int bookId) {

		try {
		
			CartDao.deleteCart(userId,bookId);
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
