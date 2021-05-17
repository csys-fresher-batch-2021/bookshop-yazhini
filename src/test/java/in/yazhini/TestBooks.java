package in.yazhini;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.yazhini.model.BookDetails;
import in.yazhini.service.TestBookDetails;

public class TestBooks {

	@Test
	public void numberOfBookTypesTest() {
		List<BookDetails> bookList = TestBookDetails.getBookList();
		assertEquals(4, bookList.size());
	}

}
