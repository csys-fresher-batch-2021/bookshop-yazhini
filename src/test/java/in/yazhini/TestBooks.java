package in.yazhini;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.yazhini.dao.BookDao;
import in.yazhini.model.BookDetails;

public class TestBooks {

	@Test
	public void numberOfBookTypesTest() {
		List<BookDetails> bookList = BookDao.getBookList();
		assertEquals(4, bookList.size());
	}

}
