import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class Rotate {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/input_rotate"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		int numberOfMatrix= 0  , numberOfRow= 0  ; 
        		if( line != null){
        			String[] tarr = line.split(" ");
        			numberOfMatrix= Integer.parseInt(tarr[0]);
        			numberOfRow= Integer.parseInt(tarr[1]);
        		}else{
        			break ;
        		}

        		char[][] input = new char[numberOfMatrix][numberOfMatrix];

        		for( int i = 0 ; i < numberOfMatrix ; i++){
        			line = br.readLine();
        			input[i] = line.toCharArray() ; 
        		}
        		
        		
        		String result = r(input , numberOfRow) ; 
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 

	        }
	        
			File file = new File("src/output_Rotate");
			 
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
	
	public static String r(char[][] input , int kpiece){
		for(int i = 0 ; i < input.length ; i++){
			for(int j =0 ; j < input[i].length ; j++){
				input[i] = rline(input[i]); 
			}
		}
		String result = "";
		result = check(input , kpiece);
		return result;
	}
	
	public static String check(char[][] input , int kpiece){
		int xmax = input.length ; 
		int ymax = input[0].length ; 
		boolean rwin = false ;
		boolean bwin = false ; 
		
		for(int i = 0 ; i < xmax ; i++ ){
			for( int j = 0 ; j < ymax ; j++ ){
				char tc = input[i][j];
				
				if( (tc == 'R') || (tc == 'B')){ 
					boolean inarow = false ; 
					
					
					if (i + kpiece <= xmax) {
						inarow = true;
						for (int k = i + 1; k < i + kpiece; k++) {
							if (input[k][j] != tc) {
								System.out.println(input[k][j] + " " + tc);
								inarow = false;
								break;
							}
						}
					}

					if (!inarow) {
						if (j + kpiece <= ymax) {
							inarow = true;
							for (int k = j + 1; k < j + kpiece; k++) {
								if (input[i][k] != tc) {
									inarow = false;
									break;
								}
							}
						}
					}
					
					if (!inarow) {
						if ((i-kpiece+1 >= 0 ) && (j + kpiece <= ymax)) {
							inarow = true;
							for (int k = j + 1 ,  l = i - 1 ; ( k < j + kpiece ) &&  ( l > i - kpiece ); k++ , l -- ) {
								if (input[l][k] != tc) {
									inarow = false;
									break;
								}
							}
						}
					}
					
					if (!inarow) {
						if ((i+kpiece <= xmax ) && (j + kpiece <= ymax)) {
							inarow = true;
							for (int k = j + 1 ,  l = i + 1 ; ( k < j + kpiece ) &&  ( l < i + kpiece ); k++ , l ++ ) {
								if (input[l][k] != tc) {
									inarow = false;
									break;
								}
							}
						}
					}



					if (inarow) {
						if (tc == 'R') {
							rwin = true;
						}
						if (tc == 'B') {
							bwin = true;
						}
					}
				
			}
		}
		}
//		System.out.println("r"+rwin+"b"+bwin);
		if( rwin && bwin){
			return "Both" ; 
		}else if(rwin && !bwin){
			return "Red" ; 
		}else if( !rwin && bwin ){
			return "Blue" ; 
		}else{
			return "Neither" ; 
		}
	}
	
	public static char[] rline(char[] input){
		boolean swap = true;
		while(swap ){
			swap = false ; 
			for( int i = input.length -1 ; i > 0 ; i--){
				if( (input[i-1] == 'R') || (input[i-1] == 'B')){
					if( input[i] == '.' ){
						input[i] = input[i-1] ; 
						input[i-1] = '.' ; 
						swap = true ;
					}
				}
			}
		}
		return input ; 
	}

}
