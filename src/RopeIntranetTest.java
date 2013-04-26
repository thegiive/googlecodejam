import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RopeIntranetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetIntra() {
//		fail("Not yet implemented");
		rope a = new rope();
		a.x1 = 1 ; 
		a.x2 = 1 ; 
		rope b = new rope();
		b.x1 = 2 ; 
		b.x2 = 2 ; 
		rope c = new rope();
		c.x1 = 3 ; 
		c.x2 = 3 ; 

		rope[] arr = { a , b , c } ; 
		assertEquals( 0 , RopeIntranet.getIntra(arr));
	}
	
	@Test
	public void testGetIntra2() {
//		fail("Not yet implemented");
		System.out.println("   ");
		rope a = new rope();
		a.x1 = 1 ; 
		a.x2 = 3 ; 
		rope b = new rope();
		b.x1 = 2 ; 
		b.x2 = 2 ; 
		rope c = new rope();
		c.x1 = 3 ; 
		c.x2 = 1 ; 

		rope[] arr = { a , b , c } ; 
		assertEquals( 3 , RopeIntranet.getIntra(arr));
	}
	
	@Test
	public void testGetIntra3() {
//		fail("Not yet implemented");
		System.out.println("   ");
		rope a = new rope();
		a.x1 = 1 ; 
		a.x2 = 10 ; 
		rope b = new rope();
		b.x1 = 5 ; 
		b.x2 = 5 ; 
		rope c = new rope();
		c.x1 = 7 ; 
		c.x2 = 7 ; 

		rope[] arr = { a , b , c } ; 
		assertEquals( 2 , RopeIntranet.getIntra(arr));
	}

}
