import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;


public class ReverseWords {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("src/input_reverse_word"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
	        		line = br.readLine();
		        if( line != null){
		        	content += "Case #"+(trynum++)+": "+ReverseWords.lala(line)+"\n"; 
	        	}
		        
	        }
	        
			File file = new File("src/output_reverse_word");
			 
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
	
	public static String lala(String input){
		String[] arr = input.split(" ");
		String result = "";
		for( int i = arr.length -1 ; i >=0 ; i-- ){
			result += arr[i];
			if(i!=0){
				result += " ";
			}
		}
		return result; 
	}

}
