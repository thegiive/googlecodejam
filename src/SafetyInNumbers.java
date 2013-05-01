import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;


public class SafetyInNumbers {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("input_safetynumber"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		if( line != null){
        			String[] r = line.split(" ");
        			int arr_length = Integer.parseInt(r[0]);
        			int[] arr = new int[arr_length];
        			for( int i = 0 ; i < arr_length ; i++ ){
        				arr[i] = Integer.parseInt(r[i+1]); 
        			}
        			String result = getResult(arr);
//        			int result = getBulleye(Double.parseDouble(r[0]) , Double.parseDouble(r[1]));
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 
        		}
	        }
	        
			File file = new File("output_safetyinnumbers");
			 
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
	
	public static double[] get1(int[] arr , double total ){
		double ttotal = 0.0 ; 
		for(int i : arr){
			ttotal += i; 
		}
		double min_thread = ( ttotal + total ) / arr.length ; 
		System.out.println(Arrays.toString(arr)) ; 
		System.out.println(min_thread) ; 
		
		int length = 0 ;
		
		for( int r : arr){
			if( r < min_thread ){
				length ++ ;
			}
		}

		double[] result = new double[arr.length] ; 

		if( length == arr.length){
			for( int i = 0 ; i < arr.length ; i++){
				result[i] = ((double)( min_thread- arr[i] )) * 100 / total ;
		}			
		}else{
			int[] tarr = new int[length];
			int ti = 0 ; 
			for(int i =0 ; i < arr.length ; i++){
				if( arr[i] < min_thread ){
					tarr[ti++] = arr[i] ; 
				}
			}
			double[] tresult = get1(tarr, total );

			ti = 0 ; 
			for(int i =0 ; i < arr.length ; i++){
				if( arr[i] < min_thread ){
					result[i] = tresult[ti++]  ; 
				}else{
					result[i] = 0.0 ;
				}
			}
			
		}
		return result ; 
	}
	
	
	public static double[] get(int[] arr){
		double total = 0.000; 
		for( int a : arr){
			total += a ; 
		}
		double min_point = ( total * 2 ) / arr.length ; 
		double[] result = new double[arr.length] ; 
		
		
		for( int i = 0 ; i < arr.length ; i++){
				result[i] = ((double)( min_point - arr[i] )) * 100 / total ;
		}
		
		return result ; 
	}
	
	public static String getResult(int[] arr){
		double total = 0.0 ; 
		for( int i : arr ){
			total += i ; 
		}
		double[] result = get1(arr, total ) ; 
		String r = "";
		for( double f : result){
			  BigDecimal bd= new BigDecimal(f);   
			  bd=bd.setScale(6	, BigDecimal.ROUND_HALF_UP); 
			    DecimalFormat formatter = new DecimalFormat("0.000000");

			  r += formatter.format(bd.doubleValue())+" ";
		}
		return r ; 
	}
}
