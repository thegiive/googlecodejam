
public class MinimumScalarProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,2};
		int[] b = {4,5,6} ;
		lala(a , b);

	}
	
	public static int lala(int[] input1 , int[] input2 ){
		int total = input1.length * input1.length ; 
		node[] result = new node[ total ];		

		int c = 0 ; 
		for(int i = 0 ; i < input1.length ; i++){
			for(int j = 0 ; j < input1.length ; j++){
				node n = new node();
				n.x = i ;
				n.y = j ; 
				n.v = input1[i] * input2[j];
				result[c++] = n ; 
			}
		}
		
		
		
		boolean swap = true ; 
		
		while(swap){
			swap = false; 
			for( int i = 0 ; i < total -1  ; i++){
				node ni = result[i] ;
				node nj = result[i+1] ; 

				if( ni.v > nj.v ){
					node nt = result[i] ; 
					result[i] = result[i+1] ; 
					result[i+1] = nt; 
					swap = true ;
				}
			}
		}
		
		return 1 ; 

	}
	

}
class node{
	int x ; 
	int y ;
	int v ; 
}
