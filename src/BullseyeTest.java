import static org.junit.Assert.*;

import org.junit.Test;


public class BullseyeTest {

	@Test
	public void testGetBulleye() {
//		fail("Not yet implemented");
		assertEquals( "1" , Bullseye.getBulleye("1", "9"));
		assertEquals( "2", Bullseye.getBulleye("1", "10"));
		assertEquals( "3", Bullseye.getBulleye("3", "40"));
		
//		double  t = new Double("1000000000000000000") ;
//		String t1 = "10000000000000000"; 
//		String t2 = "1000000000000000000"; 
//		String t = "1000000000000000000";
//		assertEquals( "3", Bullseye.getBulleye("1" , "1000000000000000000"));
//		assertEquals( "49" , Bullseye.getBulleye(t1 , t2));



	}
	
	@Test
	public void testGetBulleye1() {
//		fail("Not yet implemented");
		assertEquals( "1" , Bullseye.gbe("1", "9"));
		assertEquals( "2", Bullseye.gbe("1", "10"));
		assertEquals( "3", Bullseye.gbe("3", "40"));
//		assertEquals( "3", Bullseye.gbe("1" , "1000000000000000000"));
		String t1 = "10000000000000000"; 
		String t2 = "1000000000000000000"; 
		assertEquals( "49" , Bullseye.getBulleye(t1 , t2));
		

	}

	@Test
	public void testGetBulleye2() {
		assertEquals( "10" , Bullseye.gbe12("3", "2" , "4"));
		assertEquals( "21" , Bullseye.gbe12("3", "3" , "4"));
		assertEquals( "2" , Bullseye.gbee("1" , "10") ) ;
		assertEquals( "1" , Bullseye.gbee("1" , "9") ) ;
		Double a = new Double("1000000000000000000"); 
		System.out.println(Math.sqrt(a));
		
	}
	
	@Test
	public void testGetBulleye3() {
		assertEquals( "1" , Bullseye.get(1,9));
		assertEquals( "2" , Bullseye.get(1,10));
		assertEquals( "3" , Bullseye.get(3,40));
		String t1 = "10000000000000000"; 
		String t2 = "1000000000000000000"; 
//		assertEquals( "49" , Bullseye.get(new Double(t1) , new Double(t2)));
		String t3 ="1000000000000000000";
		assertEquals( "707106780" , Bullseye.get(1 , new Double(t3)));

	}
	
	
	@Test
	public void testGetBulleye4() {
		assertEquals( "1" , Bullseye.get1("1" , "9"));
		assertEquals( "2" , Bullseye.get1("1" , "10"));
		assertEquals( "3" , Bullseye.get1("3" , "40"));
		String t1 = "10000000000000000"; 
		String t2 = "1000000000000000000"; 
		assertEquals( "49" , Bullseye.get1(t1 , t2));
		String t3 ="1000000000000000000";
		assertEquals( "707106780" , Bullseye.get1("1" , t3));

//		Double a = new Double("1000000000000000000"); 
//		System.out.println(Math.sqrt(a));
		
	}
	
}
