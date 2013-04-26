import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AllYourBase {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/input_allyourbase"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		if( line != null){
        			System.out.println(line);
        		int result = b(line);
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 
        		}
	        }
	        
			File file = new File("src/output_allyourbase");
			 
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
	
	public static int b(String input){
		int dr = getDuplicateNumber(input);
		String t = trans(input , dr , getOrderArray(dr) );
		return getConvertNumber(t , dr );
	}
	
	public static int getDuplicateNumber(String input){
		int[] hasIndex =  new int[255];
		int r = 0 ; 
		for( int i = 0 ; i < 255 ; i++ ){
			hasIndex[i] = -1 ; 
		}
		for(char c : input.toCharArray() ){
			if( hasIndex[c-0]  == -1 ){
				r++ ; 
				hasIndex[c-0] = -2; 
			}
		}
		return r;
	}
	
	public static int[] getOrderArray(int duplicateNumber){
		int[] order = new int[duplicateNumber];

		order[0] = 1 ; 
		if( duplicateNumber > 1 ){
			order[1] = 0 ;			
		}

		
		for(int i = 2 ; i < duplicateNumber ; i++){
			order[i] = i ;
		}
		return order ; 
	}
	
	public static String trans(String input , int duplicateNumber , int[] order ){
//		int duplicateNumber = getDuplicateNumber(input);
//		int[] order = getOrderArray(duplicateNumber);
		int[] hasIndex =  new int[255];
		for( int i = 0 ; i < 255 ; i++ ){
			hasIndex[i] = -1 ; 
		}

	
		int rindex = 0 ;
		
		String result_string = "";
		
		for(char c : input.toCharArray()){
			int t = 0 ; 
			if( hasIndex[c-0] == -1 ){
				t = order[rindex++];
				hasIndex[c-0] =  t;
			}else{
				t = hasIndex[c-0] ; 
			}
			result_string += t ; 
		}
		return result_string ; 
		
	}
	
	public static int getConvertNumber(String input , int duplicateNumber){
		int r = 0 ;
		char[] input_arr = input.toCharArray();
		int m = 1 ; 
		
		for( int i = input_arr.length-1 ; i >= 0 ; i-- ){
			r = r + ( input_arr[i] - '0' ) * m; 
			m = m * duplicateNumber ; 
		}
		
		return r ; 
	}
}
