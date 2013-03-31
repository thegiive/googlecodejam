import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class T9Spelling {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(Math.abs(' ' - 'a'));
//		System.out.println(Math.abs('z' - 'a'));
//		lala("");
		
		BufferedReader br = new BufferedReader(new FileReader("src/input_T9_Spelling"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
	        		line = br.readLine();
		        if( line != null){
		        	content += "Case #"+(trynum++)+": "+lala(line)+"\n"; 
	        	}
		        
	        }
	        
			File file = new File("src/output_T9_spelling");
			 
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
		String[] trans_arr = new String[66];
		int[] trans_index = new int[66];
		for(int i = 0 ; i < 15 ; i++){
			int a = ( i / 3 ) + 2;
			int b = ( i % 3 ) + 1 ;
			String c = "";
			for( int j = 0 ; j < b ; j ++){
				c += a ; 
			}
			trans_arr[i] = c ;				
			trans_index[i] = a ; 
		}
		trans_arr['p' - 'a'] = "7";
		trans_index['p' - 'a'] = 7;
		trans_arr['q' - 'a'] = "77";
		trans_index['q' - 'a'] = 7;
		trans_arr['r' - 'a'] = "777";
		trans_index['r' - 'a'] = 7;
		trans_arr['s' - 'a'] = "7777";
		trans_index['s' - 'a'] = 7;
		trans_arr['t' - 'a'] = "8";
		trans_index['t' - 'a'] = 8;
		trans_arr['u' - 'a'] = "88";
		trans_index['u' - 'a'] = 8;
		trans_arr['v' - 'a'] = "888";
		trans_index['v' - 'a'] = 8;
		trans_arr['w' - 'a'] = "9";
		trans_index['w' - 'a'] = 9;
		trans_arr['x' - 'a'] = "99";
		trans_index['x' - 'a'] = 9 ;
		trans_arr['y' - 'a'] = "999";
		trans_index['y' - 'a'] = 9;
		trans_arr['z' - 'a'] = "9999";
		trans_index['z' - 'a'] = 9;
		trans_arr[65] = "0";
		trans_index[65] = 0 ;

//		System.out.println(Arrays.toString(trans_arr));
//		System.out.println(Arrays.toString(trans_index));

		String result = ""; 
		int previous = -1 ; 
		for(char c : input.toCharArray()){
			int t = Math.abs(c - 'a');
			if( previous == trans_index[t]){
				result += " ";
			}
			result += trans_arr[t];
			previous = trans_index[t];
		}
		
		return result ;
	}

}
