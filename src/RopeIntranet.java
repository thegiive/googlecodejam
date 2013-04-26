import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RopeIntranet {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/ropeintranet"));
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
        		}else{
        			break ;
        		}
        		rope[] rope_arr = new rope[numberOfItem];
	        
        		for( int i = 0 ; i < numberOfItem ; i++){
        			line = br.readLine();
        			String[] rarr = line.split(" ");
        	        int x1 = Integer.parseInt(rarr[0]);
        	        int x2 = Integer.parseInt(rarr[1]);
        			rope r = new rope();
        			r.x1 = x1 ; 
        			r.x2 = x2 ; 
        			rope_arr[i] = r ; 
        		}
        		
        		int result = getIntra(rope_arr) ; 
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 

	        }
	        
			File file = new File("src/output_RopeIntranet");
			 
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
	public static int getIntra(rope[] rarr){
		int result = 0 ; 
		for(int i = 0 ; i < rarr.length ; i++){
			for( int j = i + 1 ; j < rarr.length ; j++){

					if(rarr[i].x1 > rarr[j].x1){
						if( rarr[i].x2 < rarr[j].x2){
							result += 1 ; 
						}
					}
					
					if(rarr[i].x1 < rarr[j].x1){
						if( rarr[i].x2 > rarr[j].x2){
							result += 1 ; 
						}
					}
			}
		}
		return result ; 
	}
}

class rope{
	int x1 ; 
	int x2 ; 
}