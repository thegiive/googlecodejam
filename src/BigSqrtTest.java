import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class BigSqrtTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		assertEquals( "6" , BigSqrt.sqrt(new BigInteger("40")).toString() );
		assertEquals( "7" , BigSqrt.sqrt(new BigInteger("50")).toString() );
		assertEquals( "7" , BigSqrt.sqrt(new BigInteger("2000000000000000000")).toString() );


	}

}
