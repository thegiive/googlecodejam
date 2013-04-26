public class Permute{
	public static int total_num = 0 ; 

    static void permute(java.util.List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	total_num ++ ; 
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }
    public static void main(String[] args){
        Permute.permute(java.util.Arrays.asList(3,4,6), 0);
        System.out.println(total_num);

    }
}