package in.yazhini.service;

public class CustomerSelectBooks {
	// Store the BookName in Array
	public static boolean validateBookName(String bookName) {
		String[] arrayOfbookName = { "TamilNovels", "EnglishNovels", "MathsDiscoveries", "GKIndiaAtRisk" };
		for (int i = 0; i < arrayOfbookName.length; i++) {
			String userName = arrayOfbookName[i];
			if (bookName.equalsIgnoreCase(userName)) {
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public static boolean validateNoOfBooks(String bookName, Integer noOfBooks)
	// No of books are stored then use some condition//
	{
		boolean isValid = false;
		switch (bookName) {
		case "TamilNovels": {
			if (noOfBooks <=10 && noOfBooks > 0) {
				isValid = true;
				break;
			}
		}
		case "EnglishNovels": {
			if (noOfBooks <= 20 && noOfBooks > 0) {
				isValid = true;
				break;
			}
		}
		case "MathematicsDiscoveries": {
			if (noOfBooks <= 10 && noOfBooks > 0) {
				isValid = true;
				break;
			}
		}
		case "GKIndiaAtRisk": {
			if (noOfBooks <= 20 && noOfBooks > 0) {
				isValid = true;
				break;
			}

		}
		}
		return isValid;
	}
}