import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ManageYourEnergy {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("inpit_manageyourenergy"));
	    int trynum = 1 ; 
	    String content = "";
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        int numberOfTestCase = Integer.parseInt(line);

	        while (line != null) {
        		line = br.readLine();
        		if( line != null){
//        			System.out.println(line);
        			String[] fl = line.split(" ");
        			int max_j = Integer.parseInt(fl[0]);
        			int regain_j = Integer.parseInt(fl[1]);
        			int arr_len = Integer.parseInt(fl[2]);
            		line = br.readLine();
        			String[] string_arr = line.split(" ");
        			int[] arr = new int[arr_len];
        			for(int i = 0 ; i< arr_len ; i ++){
        				arr[i] = Integer.parseInt(string_arr[i]);
        			}

        		int result = getMax(max_j, regain_j , arr_len , arr );
        		
    			content += "Case #"+(trynum++)+": "+result+"\n" ; 
        		}
	        }
	        
			File file = new File("output_manageyourenergy");
			 
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
	
	public static int mye( int max_joules , int regain_joules , int[] act , int act_index, int current_joules , int current_value){
		for(int i = 0 ; i < current_joules ; i++){
			if( current_joules - i + regain_joules > max_joules ){
				continue ;
			}
			current_value = current_value + act[act_index] * i ;
			current_joules = current_joules -i + regain_joules ;
//			mye()
		}
		return 1 ; 
	}
	
	public static int getMax(int max_joules , int regain_joules , int N , int[] arr){
		ArrayList<int[]> al = ManageYourEnergy.mye1( max_joules , regain_joules , max_joules  , N , 0);
//		int[] arr= {4,1,3,5}; 
		int max = 0 ;
		for(int[] r : al){
			int t = 0 ; 
			for( int i = 0 ; i < r.length ; i++){
				t += r[i] * arr[i]; 
			}
			if( max < t ){
				max = t ; 
			}
		}
		return max ; 
	}
	
	public static ArrayList<int[]> mye1( int max_joules , int regain_joules ,  int current_joules , int N , int cindex){
		
		if( cindex >= N-1){
//			System.out.println(current_joules);

			int[] r = new int[N];
			r[cindex] = current_joules; 
			ArrayList<int[]> al = new ArrayList<int[]>();
			al.add(r);
			return al ; 
		}
		
		ArrayList<int[]> returnal = new ArrayList<int[]>();
		
		
//		int tc_joules = current_joules ; 
		
		int initial = 0 ; 
		if( current_joules + regain_joules > max_joules ){
			initial = current_joules + regain_joules - max_joules ; 
		}
				
		for(int i = initial ; i <= current_joules   ; i++){
//			System.out.println(current_joules);
			int tcj = current_joules ; 
			tcj = tcj - i + regain_joules ; 
			if( tcj > max_joules ){
				tcj = max_joules ; 
			}
			
			ArrayList<int[]> ral = mye1(max_joules , regain_joules , tcj , N , cindex+1);
			for(int[] tr : ral){
				tr[cindex] = i ;
				returnal.add(tr);
			}
		}
		
		return returnal ; 
	}
	
}
