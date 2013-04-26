import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class FileFixItTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetNumber() {
//		fail("Not yet implemented");
		String[] a = { "/a/b/c" , "/d/e/f" } ; 
		String[] b = { "/f/e/f" } ; 
		assertEquals( FileFixIt.getNumber(a, b) , 3 ) ; 
	}
	
	@Test
	public void testGetNumber1() {
//		fail("Not yet implemented");
		String[] a = { "/a/b/c" , "/d/e/f" } ; 
		String[] b = { "/d/e/f" } ; 
		assertEquals( FileFixIt.getNumber(a, b) , 0 ) ; 
	}

	
	@Test
	public void testGetNumber2() {
//		fail("Not yet implemented");
		String[] a = {  } ; 
		String[] b = { "/home/gcj/finals" , "/home/gcj/quals"} ; 
		assertEquals( FileFixIt.getNumber(a, b) , 4 ) ; 
	}

	
	@Test
	public void testGetNumber3() {
//		fail("Not yet implemented");
		String[] a = { "/chicken" , "/chicken/egg"} ; 
		String[] b = { "/chicken" } ; 
		assertEquals( FileFixIt.getNumber(a, b) , 0 ) ; 
	}
	
	@Test
	public void testGetNumber4() {
//		fail("Not yet implemented");
		String[] a = { "/a" } ; 
		String[] b = { "/a/b" , "/a/c" , "/b/b" } ; 
		assertEquals( FileFixIt.getNumber(a, b) , 4 ) ; 
	}


	@Test
	public void testCreateMap() {
//		fail("Not yet implemented");
		String[] a = { "/a/b/c" , "/d/e/f" } ; 
		HashMap<String, Boolean> hm = FileFixIt.createMap(a) ; 
		assertEquals( true , hm.get("/a"));
		assertEquals( null , hm.get("/e"));
		assertEquals( true , hm.get("/a/b"));
		assertEquals( true , hm.get("/a/b/c"));
		assertEquals( null , hm.get("/a/b/d"));

	}

}
