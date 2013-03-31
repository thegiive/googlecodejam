import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class lala {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/input"));
	    int trynum = 1 ; 
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
	        		line = br.readLine();
	        		int credit = 0  , numberOfItem = 0  ; 
		        if( line != null){
	        		credit= Integer.parseInt(line);
	        	}
		        
		        line = br.readLine();
		        if( line != null){	        	
		        	numberOfItem = Integer.parseInt(line);
		        }
		        	
		        line = br.readLine();
		        if( line != null){	        	
		        	int[] item = new int[numberOfItem];
		        	int i = 0 ;
		        	for( String s : line.split(" ") ){
		        		item[i++] = Integer.parseInt(s);
		        	}
		        	System.out.println("Case #"+(trynum++)+": "+StoreCredit.get(credit, item)); 
		        }
	        }
	    } finally {
	        br.close();
	    }
	}

}
