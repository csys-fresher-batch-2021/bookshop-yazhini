package in.yazhini.validator;

import in.yazhini.model.BookDetails;

import in.yazhini.service.TestBookDetails;

public class CustomerShopValidator {
	public static boolean isValidQuantity(int noOfBooks,String bookName) {
		boolean isValid = false;
		int quantity=0;
		for (BookDetails add : TestBookDetails.getBookList()) {
			
			// bookname and noofbooks validation
			if (add.getBookName().equalsIgnoreCase(bookName) ) {
				quantity = add.getNoOfBooks();
				System.out.println(quantity);
				if(quantity > noOfBooks) {
				System.out.println("correct book");
				isValid = true;
				}
			System.out.println("wrong");
			
		}
			
	}
		return isValid;
		
}
}
	