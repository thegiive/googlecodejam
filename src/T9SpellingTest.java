import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class T9SpellingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLala() {
//		fail("Not yet implemented");
		assertEquals( "44 444" , T9Spelling.lala("hi") );
		assertEquals( "999337777" , T9Spelling.lala("yes") );
		assertEquals( "333666 6660 022 2777" , T9Spelling.lala("foo  bar") );
		assertEquals( "4433555 555666096667775553" , T9Spelling.lala("hello world") );

	}

}
