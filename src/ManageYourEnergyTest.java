import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class ManageYourEnergyTest {

	@Test
	public void testMye1() {
//		fail("Not yet implemented");
//		ArrayList<int[]> al = ManageYourEnergy.mye1(3 , 3 , 3 , 4 , 0);
//		int[] arr= {4,1,3,5}; 
//		int max = 0 ;
//		for(int[] r : al){
////			System.out.println(Arrays.toString(r));
//		}
		
		int[] arr = {4,1,3,5};
		assertEquals( 39 , ManageYourEnergy.getMax(3, 3, 4, arr));
		int[] arr1 = {1,2};
		assertEquals( 12 , ManageYourEnergy.getMax(5, 2, 2, arr1));
		int[] arr2 = {2,1};
		assertEquals( 12 , ManageYourEnergy.getMax(5, 2, 2, arr2));

	}
	
	@Test
	public void testMye2() {
//		int[] arr2 = {6,9,2 4 4 6 10 9 3 8};
//		assertEquals( 12 , ManageYourEnergy.getMax(5, 2, 2, arr2));
		ArrayList<int[]> al = ManageYourEnergy.mye1(5,4,5,12,0);
//		int[] arr= {4,1,3,5}; 
//		int max = 0 ;
//		for(int[] r : al){
//			System.out.println(Arrays.toString(r));
//		}
		System.out.println(al.size());

	}


}
