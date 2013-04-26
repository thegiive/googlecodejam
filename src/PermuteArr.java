import java.util.ArrayList;

public class PermuteArr{
    public static ArrayList<int[]> permute(int[] arr, int k , ArrayList<int[]> alist ){
        for(int i = k; i < arr.length ; i++){
           	int t = arr[i] ;
        	arr[i] = arr[k] ;
        	arr[k] = t ; 

        	alist = permute(arr, k+1 , alist );
           	
        	t = arr[i] ;
        	arr[i] = arr[k] ;
        	arr[k] = t ; 
        }
        if (k == arr.length -1){

        	alist.add(arr.clone()); 
        }
        return alist ;
    }
    
    public static void main(String[] args){
    	int[] arr = { 0,1,2 } ;
    	ArrayList<int[]> alist = new ArrayList<int[]>();
        alist = PermuteArr.permute(arr, 0 , alist );
        for(int[] tarr : alist){
          System.out.println(java.util.Arrays.toString(tarr));        	
        }
    }
}