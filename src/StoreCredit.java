import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StoreCredit {
	public static void main() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("input"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        System.out.println(everything);
	    } finally {
	        br.close();
	    }
	}
	
	public static String get(int credit , int[] item){
//		Arrays.sort(item);
		int max = 0 ; 
		int[] result = new int[2];
		for(int i = item.length -1 ; i >= 1 ; i -- ){
			for( int j = i -1 ; j >= 0 ; j --){
				if( i <= j){break;}
//				 System.out.println("i j is "+i+" "+j+" r is "+(item[i]+item[j]));
				if( item[i]+item[j] == credit){
					if(i < j){
						return (i+1)+" "+(j+1);
					}else{
						return (j+1)+" "+(i+1);						
					}
				}
				if(( max < item[i]+item[j] )&& ( item[i]+item[j] < credit )){
					max = i  +j ;
					result[0] = i ; 
					result[1] = j ; 
 				}
			}
		}
		if( max != 0 ){
			if(result[0] < result[1]){
				return (result[0]+1)+" "+(result[1]+1);
			}else{
				return (result[1]+1)+" "+(result[0]+1);
			}
		}else{
			return "null" ; 
		}
	}
}
