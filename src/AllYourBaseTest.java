import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AllYourBaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDuplicateNumber() {
//		fail("Not yet implemented");
		assertEquals( 2 , AllYourBase.getDuplicateNumber("lala"));
		assertEquals( 4 , AllYourBase.getDuplicateNumber("lala12"));

	}

	@Test
	public void testTrans() {
//		fail("Not yet implemented");
		assertEquals( "1010" , AllYourBase.trans("lala" , 2 , AllYourBase.getOrderArray(2) ));
		assertEquals( "1010234" , AllYourBase.trans("lala123", 5 , AllYourBase.getOrderArray(5)));


	}

	@Test
	public void testGetConvertNumber() {
//		fail("Not yet implemented");
		assertEquals( 10 , AllYourBase.getConvertNumber("1010" , 2));
		assertEquals( 16319 , AllYourBase.getConvertNumber("1010234" , 5));

	}
	
	@Test
	public void testB1() {
		assertEquals( 201 , AllYourBase.b("11001001"));
		assertEquals( 75 , AllYourBase.b("cats"));
		assertEquals( 11 , AllYourBase.b("zig"));


	}

}
