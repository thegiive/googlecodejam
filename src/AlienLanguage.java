import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

//http://code.google.com/codejam/contest/90101/dashboard#s=p0
public class AlienLanguage {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("src/input_alienlanguage"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        String[] pattern = line.split(" ");
	        int kword_len = Integer.parseInt(pattern[1]);
	        int pattern_len = Integer.parseInt(pattern[2]);

	        
	        String[] kword_arr = new String[kword_len];
	        String[] pattern_arr = new String[pattern_len];
	        for(int i = 0 ; i< kword_len ; i++){
	        		kword_arr[i] = br.readLine(); 
	        }
	        for(int i = 0 ; i< pattern_len ; i++){
        			pattern_arr[i] = br.readLine(); 
	        }
	        
	        content = get(kword_arr , pattern_arr); 

	        
			File file = new File("src/output_alienlanguage");
			 
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
	
	public static String get(String[] know_word_arr , String[] pattern_arr){
		char[][] kwordarr = new char[know_word_arr.length][know_word_arr[0].length()]; 
		for(int i = 0 ; i < know_word_arr.length ; i++){
			kwordarr[i] = know_word_arr[i].toCharArray() ; 
		}
		char[][][] parr = getPatternArr(pattern_arr);
		
		String result_string = "" ;
		for(int i = 0 ; i< parr.length ; i++	){
			int result = 0 ; 
			for( int j =0 ; j< kwordarr.length ; j++){
				if(match(kwordarr[j] , parr[i])){
					result ++ ; 
				}
			}
			result_string += "Case #"+(i+1)+": "+result+"\n";
		}
			
		return result_string; 
	}
	
	public static boolean match(char[] input , char[][] pattern){
		boolean match = true ; 
		for(int i =0 ; i < input.length ; i++ ){
			boolean isOK = false ;
			for(int j = 0  ; j< pattern[i].length ; j++){
				if( pattern[i][j] == input[i]){
					isOK = true ; 
					break ; 
				}
			}
			if(!isOK){
				match = false ; 
				break ; 
			}
		}
		return match ; 
	}
	
	public static char[][][] getPatternArr(String[] parr){
		char[][][] carr = new char[parr.length][260][100]; 
		for( int j = 0 ; j < parr.length ; j++){
			char[] tcarr = parr[j].toCharArray() ;
			
			char[][] temp_arr = new char[tcarr.length][100]; 
			int k = 0 ; 
			for(int i = 0 ; i < tcarr.length ; i ++){
				String tp = ""; 
				if(tcarr[i] == '('){
					while( tcarr[++i] != ')'){
						tp += tcarr[i] ; 
					}
 				}else{
 					tp += tcarr[i] ; 
 				}
				temp_arr[k++] = tp.toCharArray() ; 
			}
			
			char[][] ttarr = new char[k][100]; 
			for( int i = 0 ; i < ttarr.length ; i ++){
				ttarr[i] = temp_arr[i]; 
			}
			
			carr[j] = ttarr; 
			
		}
				
		return carr ; 
	}

}
