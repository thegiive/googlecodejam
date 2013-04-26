import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class MinimumScalarProductTest {

	@Test
	public void testLala() {
		int[] a = {1,3,2};
		int[] b = {4,5,6} ;
		assertEquals( 28 , MinimumScalarProduct.haha(a, b) ); 
	}
	
	@Test
	public void testLala1() {
		int[] a = {1,3,-5};
		int[] b = {-2,4,1} ;
		assertEquals( -25 , MinimumScalarProduct.haha(a, b) ); 
	}

	
	
	
	
	@Test
	public void testLala2() {
		int[] a = {1,2,3,4,5};
		int[] b = {1,0,1,0,1} ;
		assertEquals( 6 , MinimumScalarProduct.haha(a, b) ); 
	}

	@Test
	public void testLala3() {
		int[] a = {1 , -10, 128, -123, 100, -93, 600 , -1000 };
		int[] b = { 9 , 10 , -11, 12, -13, 14, -15, 16} ;
		assertEquals( -30693 , MinimumScalarProduct.haha(a, b) ); 
	}

	
	@Test 
	public void testRemove(){
		int[] a = {1,2,3,4,5 } ; 
		int[] r = MinimumScalarProduct.remove(a , 2 ) ; 
		assertEquals( "[1, 2, 4, 5]" , Arrays.toString(r)  );
	}

}
