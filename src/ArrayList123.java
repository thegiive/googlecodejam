import java.util.ArrayList;
import java.util.List;


public class ArrayList123 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ArrayList<ArrayList<String>> alist = new ArrayList<ArrayList<String>>();
//		ArrayList<String> al = new ArrayList<String>();
//		al.add("aa");
//		al.add("bb");
//		alist.add(al);
//		System.out.println(alist.get(0).get(0));
		ArrayList<int[]> alist = new ArrayList<int[]>();
		int[] a = new int[10];
		a[0] = 1 ; 
		alist.add(a);
		System.out.println(alist.get(0)[0]);
		
	}

}
