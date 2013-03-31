import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StoreCreditTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGet() {
//		fail("Not yet implemented");
		int[] i = {5,75,25} ;
		assertEquals("2 3" , StoreCredit.get(100, i));
		int[] j = {150,24,79,50,88,345,3} ;
		assertEquals("1 4" , StoreCredit.get(200, j));
		
		int[] k = {2, 1, 9, 4, 4, 56, 90, 3} ;
		assertEquals("4 5" , StoreCredit.get(8, k));
	}
	
	

}
