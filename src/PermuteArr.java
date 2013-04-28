import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class PermuteArr{
    public static ArrayList<int[]> permute(int[] arr, int k , ArrayList<int[]> alist ){
        for(int i = k; i < arr.length ; i++){
           	int t = arr[i] ;
        	arr[i] = arr[k] ;
        	arr[k] = t ; 

        	alist = permute(arr, k+1 , alist );
           	
        	t = arr[i] ;
        	arr[i] = arr[k] ;
        	arr[k] = t ; 
        }
        if (k == arr.length -1){

        	alist.add(arr.clone()); 
        }
        return alist ;
    }
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new FileReader("input_MinimumScalarProduct"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		if( line != null){
            		int arr_len = Integer.parseInt(line);
            		line = br.readLine();
        			String[] r = line.split(" ");
        			int[] arr = new int[arr_len];
        			for(int i = 0 ; i < r.length ; i++){
        				arr[i] = Integer.parseInt(r[i]);
        			}
            		line = br.readLine();
        			r = line.split(" ");
        			int[] arr1 = new int[arr_len];
        			for(int i = 0 ; i < r.length ; i++){
        				arr1[i] = Integer.parseInt(r[i]);
        			}
        	    	BigInteger min = getMinScalrProduct1(arr,arr1);
        		
        			content += "Case #"+(trynum++)+": "+min.toString()+"\n" ;
//        	    	System.out.println("Case #"+(trynum)+": "+min+"\n");
        		}
	        }
	        
			File file = new File("output_MinimumScalarProduct");
			 
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

		
    	
    	
//    	int[] arr = { 1,2,3,4,5,6,7,8 } ;
//    	int[] arr1 = { 1,0,1,0,1,0,1,0 } ;
//    	int min = getMinScalrProduct(arr,arr1);
//    	System.out.println(min);
    }

    public static BigInteger getMinScalrProduct1(int[] arr , int[] arr1){
    	Arrays.sort(arr);
    	Arrays.sort(arr1);
        BigInteger min= new BigInteger("0");
    	for(int i = 0 ; i < arr.length ; i++){
    		long t = (long)arr[i] * (long)arr1[arr.length - 1 - i ];
    		min = min.add(new BigInteger(Long.toString(t)));
//    		min = min + arr[i] * arr1[arr.length - 1 - i ];
    	}
    	return min ; 
    }
    
    public static int getMinScalrProduct(int[] arr , int[] arr1){
//    	int[] arr = { 1,2,3,4,5 } ;
    	ArrayList<int[]> alist = new ArrayList<int[]>();
        alist = PermuteArr.permute(arr, 0 , alist );
        
//    	int[] arr1 = { 1,0,1,0,1 } ;
    	ArrayList<int[]> a1list = new ArrayList<int[]>();
        a1list = PermuteArr.permute(arr1, 0 , a1list );
        
        int min = 100000;

 


        for(int i =0 ; i < alist.size() ; i++){
            for(int ii =0 ; ii < alist.size() ; ii++){

        	int[] t1 = alist.get(i);
        	int[] t2 = a1list.get(ii);
        	int t = 0 ;
        	
        	for( int j = 0 ; j < t1.length ; j++){
            	t = t + (t1[j] * t2[j]) ;
        	}
        	
        	if( t < min ){
        		
        		min = t ; 
        	}
        	

            }

        }
        // -5 1 3
        // -2 1 4
//        System.out.println(min);
        return min ;

        

//        for(int[] tarr : alist){
//          System.out.println(java.util.Arrays.toString(tarr));        	
//        }
//        System.out.println(alist.size());        	

    }
}