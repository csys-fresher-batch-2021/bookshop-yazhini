package in.yazhini.validator;

import in.yazhini.dao.CartDao;
import in.yazhini.dao.BookDao;
import in.yazhini.dao.UserDao;
import in.yazhini.exception.ValidatorException;
import in.yazhini.model.BookDetails;
import in.yazhini.model.CartDetails;
import in.yazhini.model.UserDetails;

public class CartValidator {

	public static void existsCart(int userId, int bookId) {
		String userName = "";
		String bookName = "";

		for (UserDetails user : UserDao.getUserList()) {
			if (userId == user.getUserId()) {
				userName = user.getUserName();
			}
		}
		for (BookDetails books : BookDao.getBookList()) {
			if (bookId == books.getBookId()) {
				bookName = books.getBookName();
			}
		}
		for (CartDetails carts : CartDao.getCartList()) {
			if (userName.equals(carts.getUserDetails().getUserName())
					&& bookName.equals(carts.getBookDetails().getBookName())) {
				throw new ValidatorException("The Book Is Already AddToCart");
				
			}
		
		}

	}
	
}

