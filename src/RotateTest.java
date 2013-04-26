import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RotateTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testR() {
//		fail("Not yet implemented");
		char[][] r = new char[4][4];
		r[0] = "...R".toCharArray();
		r[1] = ".R..".toCharArray();
		r[2] = "R...".toCharArray();
		r[3] = ".R..".toCharArray();
		assertEquals( "Red" , Rotate.r(r , 4));

	}
	
	@Test
	public void testR1() {
		char[][] r = new char[3][3];
		r[0] = "B..".toCharArray();
		r[1] = "RB.".toCharArray();
		r[2] = "RB.".toCharArray();
		assertEquals( "Blue" , Rotate.r(r , 3));

	}
	
	@Test
	public void testR2() {
		char[][] r = new char[4][4];
		r[0] = "R...".toCharArray();
		r[1] = "BR..".toCharArray();
		r[2] = "BR..".toCharArray();
		r[3] = "BR..".toCharArray();

		assertEquals( "Red" , Rotate.r(r , 4));

	}
	
	@Test
	public void testR3() {
		char[][] r = new char[6][6];
		r[0] = "......".toCharArray();
		r[1] = "......".toCharArray();
		r[2] = ".R...R".toCharArray();
		r[3] = ".R..BB".toCharArray();
		r[4] = ".R.RBR".toCharArray();
		r[5] = "RB.BBB".toCharArray();

		assertEquals( "Both" , Rotate.r(r , 4));

	}
	
	@Test
	public void testR4() {
		char[][] r = new char[7][7];
		r[0] = ".......".toCharArray();
		r[1] = ".......".toCharArray();
		r[2] = ".......".toCharArray();
		r[3] = "...R...".toCharArray();
		r[3] = "...BB..".toCharArray();
		r[4] = "..BRB..".toCharArray();
		r[5] = ".RRBR..".toCharArray();

		assertEquals( "Neither" , Rotate.r(r , 3));

	}
	
	
	@Test
	public void testCheck() {
//		fail("Not yet implemented");
		char[][] r = new char[4][4];
		r[0] = ".R..".toCharArray();
		r[1] = ".R..".toCharArray();
		r[2] = ".R..".toCharArray();
		r[3] = ".R..".toCharArray();
		assertEquals( "Red" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck1() {
//		fail("Not yet implemented");
		char[][] r = new char[4][4];
		r[0] = "RRRR".toCharArray();
		r[1] = "....".toCharArray();
		r[2] = "....".toCharArray();
		r[3] = "....".toCharArray();
		assertEquals( "Red" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck2() {
//		fail("Not yet implemented");
		char[][] r = new char[4][4];
		r[0] = "R.RR".toCharArray();
		r[1] = "....".toCharArray();
		r[2] = "....".toCharArray();
		r[3] = "....".toCharArray();
		assertEquals( "Neither" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck3() {
		char[][] r = new char[4][4];
		r[0] = "RBRR".toCharArray();
		r[1] = "....".toCharArray();
		r[2] = "....".toCharArray();
		r[3] = "....".toCharArray();
		assertEquals( "Neither" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck4() {
		char[][] r = new char[4][4];
		r[0] = "R.RR".toCharArray();
		r[1] = "..R.".toCharArray();
		r[2] = "..B.".toCharArray();
		r[3] = "..R.".toCharArray();
		assertEquals( "Neither" , Rotate.check(r , 4 ));

	}
	
	
	@Test
	public void testCheck5() {
		char[][] r = new char[4][4];
		r[0] = "R.RR".toCharArray();
		r[1] = "..R.".toCharArray();
		r[2] = ".RB.".toCharArray();
		r[3] = "R.R.".toCharArray();
		assertEquals( "Red" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck6() {
		char[][] r = new char[4][4];
		r[0] = "R.RR".toCharArray();
		r[1] = ".RB.".toCharArray();
		r[2] = "..R.".toCharArray();
		r[3] = "R..R".toCharArray();
		assertEquals( "Red" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck7() {
		char[][] r = new char[5][5];
		r[0] = "R.RR.".toCharArray();
		r[1] = ".RB..".toCharArray();
		r[2] = "..R..".toCharArray();
		r[3] = "R..R.".toCharArray();
		r[4] = "R..R.".toCharArray();

		assertEquals( "Red" , Rotate.check(r , 4 ));

	}
	
	@Test
	public void testCheck8() {
		char[][] r = new char[4][4];
		r[0] = "RRR.".toCharArray();
		r[1] = "BBBR".toCharArray();
		r[2] = "..R.".toCharArray();
		r[3] = "R..R".toCharArray();
		assertEquals( "Both" , Rotate.check(r , 3 ));

	}
	
	@Test
	public void testRline() {
		assertEquals("....RBRB" , new String(Rotate.rline(".R.BR.B.".toCharArray())));
		assertEquals("....RBRB" , new String(Rotate.rline("RBRB....".toCharArray())));
		assertEquals("....RBRB" , new String(Rotate.rline(".RBRB...".toCharArray())));
		assertEquals("....RBRB" , new String(Rotate.rline("....RBRB".toCharArray())));

	}


}
