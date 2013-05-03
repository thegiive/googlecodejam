import static org.junit.Assert.*;

import org.junit.Test;


public class AlienLanguageTest {

	@Test
	public void test() {
		String[] karr = { "lala" , "haha" , "papa" } ;
		String[] parr = karr ; 
		AlienLanguage.get(karr, parr);
	}
	
	@Test
	public void test1() {
		String[] karr = { "(la)ala" , "(abc)(abc)(abc)" , "papa" } ;
		char[][][] tarr =  AlienLanguage.getPatternArr(karr);
		assertEquals(tarr.length , 3 );
		assertEquals(tarr[0].length , 4 );
		assertEquals(tarr[1].length , 3 );
		assertEquals(tarr[2].length , 4 );
		assertEquals(tarr[0][0].length , 2 );
		assertEquals(tarr[0][1].length , 1 );
		assertEquals(tarr[1][0].length , 3 );

	}
	
	@Test
	public void test2() {
		char[] input = {'a' , 'b' , 'c' } ; 
		char[][] pattern = { 
				{ 'a' },{'b'},{'c'} 
		};
		assertEquals(AlienLanguage.match(input , pattern) , true); 
	}

	
	@Test
	public void test3() {
		char[] input = {'a' , 'b' , 'c' } ; 
		char[][] pattern = { 
				{ 'b' },{'b'},{'c'} 
		};
		assertEquals(AlienLanguage.match(input , pattern) , false); 
	}
	
	@Test
	public void test4() {
		char[] input = {'a' , 'b' , 'c' } ; 
		char[][] pattern = { 
				{ 'a', 'b' },{'b'},{'c'} 
		};
		assertEquals(AlienLanguage.match(input , pattern) , true); 
	}
	
	@Test
	public void test5() {
		char[] input = {'a' , 'b' , 'c' } ; 
		char[][] pattern = { 
				{ 'a', 'b' },{'d'},{'c'} 
		};
		assertEquals(AlienLanguage.match(input , pattern) , false); 
	}
	
	@Test
	public void test6() {
		char[] input = {'a' , 'b' , 'c' } ; 
		char[][] pattern = { 
				{ 'a', 'b' },{'b' , 'c'},{'d'} 
		};
		assertEquals(AlienLanguage.match(input , pattern) , false); 
	}
	
	@Test
	public void test7() {
		String[] karr = { "abc" , "bca" , "dac" , "dbc" , "cba" } ;
		String[] parr = { "(ab)(bc)(ca)" , "abc" , "(abc)(abc)(abc)" , "(zyx)bc" } ; 
		AlienLanguage.get(karr, parr);
	}


}
