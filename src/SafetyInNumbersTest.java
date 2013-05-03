import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

import org.junit.Test;


public class SafetyInNumbersTest {

	@Test
	public void testGet() {
		int[] arr = { 24, 30 , 21 }; 
//		String r = "";
//		for( double f : SafetyInNumbers.get(arr)){
//			  BigDecimal bd= new BigDecimal(f);   
//			  bd=bd.setScale(6	, BigDecimal.ROUND_HALF_UP);   
//			  r += bd.doubleValue()+" ";
//		}
//		
//		assertEquals( "34.666667 26.666667 38.666667 " , r );
		assertEquals( "34.666667 26.666667 38.666667 " , SafetyInNumbers.getResult(arr) );

	
	}

	@Test
	public void testGet1() {
		int[] arr = { 20 , 10 }; 
//		String r = "";
//		for( double f : SafetyInNumbers.get(arr)){
//			  BigDecimal bd= new BigDecimal(f);   
//			  bd=bd.setScale(6	, BigDecimal.ROUND_HALF_UP);   
//			  r += bd.doubleValue()+" ";
//		}
//		
//		assertEquals( "33.333333 66.666667 " , r );
		assertEquals( "33.333333 66.666667 " , SafetyInNumbers.getResult(arr) );

	}

	
	
	@Test
	public void testGet21() {
		int[] arr = { 10 , 0 , 0  }; 


		assertEquals( "0.000000 50.000000 50.000000 " , SafetyInNumbers.getResult(arr) );
	
	}
	
	@Test
	public void testGet2() {
		int[] arr = { 10 , 0 }; 


		assertEquals( "0.000000 100.000000 " , SafetyInNumbers.getResult(arr) );
	
	}
	
	
	@Test
	public void testGet3() {
		int[] arr = { 25 , 25 , 25 , 25 }; 


		assertEquals( "25.000000 25.000000 25.000000 25.000000 " , SafetyInNumbers.getResult(arr) );
	
	}
	
	@Test
	public void testGet4() {
		int[] arr = { 0 , 0 , 0 , 72 , 0 , 0 }; 


		assertEquals( "20.000000 20.000000 20.000000 0.000000 20.000000 20.000000 " , SafetyInNumbers.getResult(arr) );
	
	}
	
	@Test
	public void testGet5() {
		int[] arr = { 0 , 0 , 0 , 72 , 0 , 10 }; 


		assertEquals( "22.439024 22.439024 22.439024 0.000000 22.439024 10.243902 " , SafetyInNumbers.getResult(arr) );
	
	}
	
}
