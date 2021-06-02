package in.yazhini;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.Test;

import in.yazhini.model.RegistrationDetails;
import in.yazhini.service.TestRegistrationDetails;

public class TestDetails {
	
		@Test
		public void numberOfBookTypesTest() {
			List<RegistrationDetails> detailList = TestRegistrationDetails.getDetailList();
			assertEquals(4,detailList.size());
		}

	}


