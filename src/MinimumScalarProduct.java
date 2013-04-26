import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MinimumScalarProduct {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/input_MinimumScalarProduct"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		int credit = 0  , numberOfItem = 0  ; 
        		if( line != null){
        			numberOfItem= Integer.parseInt(line);
        		}
	        
        		int[] item1 = new int[numberOfItem];
        		int[] item2 = new int[numberOfItem];

	        	
        		line = br.readLine();
        		if( line != null){	        	
        			int i = 0 ;
        			for( String s : line.split(" ") ){
        				item1[i++] = Integer.parseInt(s);
        			}
        		}
        		
        		line = br.readLine();
        		if( line != null){	        	
        			int i = 0 ;
        			for( String s : line.split(" ") ){
        				item2[i++] = Integer.parseInt(s);
        			}
        		}
        		
        		
        		
    			System.out.println("Case #"+(trynum++)+": "+haha(item1,item2)); 

	        }
	        
			File file = new File("src/output_MinimumScalarProduct");
			 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
	    } finally {
	        br.close();
	    }

	}
	
	public static int haha(int[] input1 , int[] input2 ){
		int length = input1.length ; 

		if(length == 1 ){
			return input1[0] * input2[0] ;
		}
		
		if( length == 2){
			int t1 = input1[0] * input2[0] + input1[1] * input2[1]; 
			int t2 = input1[0] * input2[1] + input1[1] * input2[0];
			if( t1 > t2 ){
				return t2 ; 
			}else{
				return t1 ;
			}
		}
		
		if( length == 3){
			int min = input1[0] * input2[0] + input1[1] * input2[1] + input1[2] * input2[2];
			int t = input1[0] * input2[0] + input1[1] * input2[2] + input1[2] * input2[1];
			if( t < min ) min = t ;
			
			t = input1[1] * input2[0] + input1[0] * input2[1] + input1[2] * input2[2];
			if( t < min ) min = t ;
			t = input1[1] * input2[0] + input1[2] * input2[1] + input1[0] * input2[2];
			if( t < min ) min = t ;
			
			t = input1[2] * input2[0] + input1[0] * input2[1] + input1[1] * input2[2];
			if( t < min ) min = t ;
			t = input1[2] * input2[0] + input1[1] * input2[1] + input1[0] * input2[2];
			if( t < min ) min = t ;

			t = input1[0] * input2[1] + input1[1] * input2[0] + input1[2] * input2[2];
			if( t < min ) min = t ;
			t = input1[0] * input2[1] + input1[2] * input2[0] + input1[1] * input2[2];
			if( t < min ) min = t ;

			t = input1[0] * input2[2] + input1[1] * input2[0] + input1[2] * input2[1];
			if( t < min ) min = t ;
			t = input1[0] * input2[2] + input1[2] * input2[0] + input1[1] * input2[1];
			if( t < min ) min = t ;

			return min ; 
			
		}
		
		int min = Integer.MAX_VALUE ;
		
		for(int i = 0 ; i < length ; i++){
			for( int j = 0 ; j < length ; j++){
				int t = input1[i] * input2[j ];
				int[] arr_1 = remove(input1 , i);
				int[] arr_2 = remove(input2 , j);
				int tmin = t + haha(arr_1,arr_2);
				if( min > tmin){
					min = tmin;
				}
			}
		}
		return min ; 
		
	}
	
	public static int[] remove(int[] a, int i)
	{
	            int[] copy = new int[a.length-1];
	            System.arraycopy(a, 0, copy, 0, i);
	            System.arraycopy(a, i+1, copy, i, a.length-i-1);
	            return copy;
	}

	
//	public static int haha1(int[] input1 , )
	
	public static int lala(int[] input1 , int[] input2 ){
		int total = input1.length * input1.length ; 
		node[] result = new node[ total ];		

		int c = 0 ; 
		for(int i = 0 ; i < input1.length ; i++){
			for(int j = 0 ; j < input1.length ; j++){
				node n = new node();
				n.x = i ;
				n.y = j ; 
				n.v = input1[i] * input2[j];
				result[c++] = n ; 
			}
		}
		
		
		
		boolean swap = true ; 
		
		while(swap){
			swap = false; 
			for( int i = 0 ; i < total -1  ; i++){
				node ni = result[i] ;
				node nj = result[i+1] ; 

				if( ni.v > nj.v ){
					node nt = result[i] ; 
					result[i] = result[i+1] ; 
					result[i+1] = nt; 
					swap = true ;
				}
			}
		}
		
		int min = 100 ;
		
		for( int k = 0 ; k < total - input1.length ; k++ ){
		boolean[][] check = new boolean[input1.length][input1.length];
		
		int r = 0 ; 
		int count = 0 ;
		
		for(int i = k ; i < total  ; i++){
			node n = result[i];
			if( check[n.x][n.y] ){
				continue ; 
			}
			r += n.v ; 
			System.out.println(n.v);
			for(int j = 0 ; j < input1.length ; j ++ ){
				check[j][n.y] = true;
				check[n.x][j] = true;
			}
			count ++ ; 
			if( count == input1.length ){
				if( min > r ){
					System.out.println("r "+r);

					min = r ;
				}
				break ; 
			}
		}
		}
		
		return min ; 

	}
	

}
class node{
	int x ; 
	int y ;
	int v ; 
}
