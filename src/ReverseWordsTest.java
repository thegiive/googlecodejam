import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReverseWordsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLala() {
//		fail("Not yet implemented");
		assertEquals( "test a is this" , ReverseWords.lala("this is a test") ) ; 
		assertEquals( "foobar" , ReverseWords.lala("foobar") ) ; 
		assertEquals( "base your all" , ReverseWords.lala("all your base") ) ; 

	}

}
