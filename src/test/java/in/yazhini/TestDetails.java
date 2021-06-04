package in.yazhini;

import static org.junit.Assert.assertEquals;


import java.util.List;


import org.junit.Test;

import in.yazhini.model.RegistrationDetails;
import in.yazhini.service.TestRegistrationDetails;

public class TestDetails {
	
		@Test
		public void DetailsTest() {
			List<RegistrationDetails> detailList = TestRegistrationDetails.getDetailsList();
			assertEquals(6,detailList.size());
		}

	}


