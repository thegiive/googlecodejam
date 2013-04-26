import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class FileFixIt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/input_filefixit"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		int numberOfExistDir = 0  , numberOfTargetDir= 0  ; 
        		if( line != null){
        			String[] tarr = line.split(" ");
        			numberOfExistDir= Integer.parseInt(tarr[0]);
        			numberOfTargetDir= Integer.parseInt(tarr[1]);
        		}else{
        			break ;
        		}

        		String[] earr = new String[numberOfExistDir];
        		String[] tarr = new String[numberOfTargetDir];

        		for( int i = 0 ; i < numberOfExistDir ; i++){
        			line = br.readLine();
        			earr[i] = line ; 
        		}
        		
        		for( int i = 0 ; i < numberOfTargetDir ; i++){
        			line = br.readLine();
        			tarr[i] = line ; 
        		}

        		
        		int result = getNumber(earr, tarr) ; 
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 

	        }
	        
			File file = new File("src/output_FileFixIt");
			 
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
	
	public static int getNumber(String[] earr , String[] tarr){
		HashMap<String , Boolean> hm = createMap(earr); 
		int result = 0 ; 
		for(String t_dir_string : tarr){
			if( hm.get(t_dir_string) != null){
				continue ; 
			}else{
				String tdir = "";
				for( String ts : t_dir_string.split("/") ){
					if(!ts.equals("")){
						tdir = tdir + "/"+ ts ;
						if( hm.get(tdir) == null){
							result ++ ; 
							hm.put(tdir, true);
						}
					}
					
				}
			}
		}
		return result; 
	}
	
	public static HashMap<String , Boolean> createMap(String[] earr){
		HashMap<String , Boolean> exist_hm = new HashMap<String, Boolean>();
		for(int i = 0 ; i < earr.length ; i++){
			String tdir = "";
			for( String ts : earr[i].split("/")){
				if(!ts.equals("")){
					tdir = tdir + "/"+ ts ;
//					System.out.println(tdir);
					exist_hm.put(tdir, true);
				}
			}
		}
		return exist_hm ; 
	}
}
