import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;


public class Bullseye {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("input_bullseye"));
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
        			String[] r = line.split(" ");
//        			int result = getBulleye(Double.parseDouble(r[0]) , Double.parseDouble(r[1]));
        		
//    			content += "Case #"+(trynum++)+": "+result+"\n" ; 
        		}
	        }
	        
			File file = new File("output_bullseye");
			 
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
	
	public static String getBulleye(String initial_r , String millilitres){
		BigInteger result = BigInteger.ZERO ; 
		BigInteger current_r = new BigInteger(initial_r) ; 
		
		BigInteger remain_m = new BigInteger(millilitres) ; 
		
		while( remain_m.compareTo(BigInteger.ZERO) > 0 ){
	        BigInteger c = new BigInteger(current_r.toString());
	        BigInteger c1 = new BigInteger(current_r.add(BigInteger.ONE).toString());
	        c1 = c1.multiply(c1) ;
	        
	        BigInteger c2 = c.multiply(c) ;

	
	        BigInteger consume_m = c1.subtract(c2);
	        
//			double consume_m = ( current_r +1 ) * ( current_r +1 ) - ( current_r  ) * ( current_r );
//			System.out.println( c1.toString()  );
//			System.out.println( c2.toString()  );
//			System.out.println( consume_m.toString()  );
//
//	        System.out.println( remain_m.toString()  );
//			System.out.println( "" );

			if( consume_m.compareTo(remain_m) <= 0 ){
				result = result.add(BigInteger.ONE); 
				current_r = current_r.add(BigInteger.ONE) ; 
				current_r = current_r.add(BigInteger.ONE) ; 
				remain_m  = remain_m.subtract(consume_m) ; 
			}else{
				break ; 
			}
		}
		return result.toString() ;  
	}
	
	public static String gbe(String initial_r , String millilitres){
		BigInteger ir1 = new BigInteger(initial_r) ;
		BigInteger ir2 = ir1.add(BigInteger.ONE);
		ir1 = ir1.multiply(ir1);

		ir2 = ir2.multiply(ir2);
		BigInteger ir = ir2.subtract(ir1); 
		BigInteger four = new BigInteger("4");
		BigInteger remain = new BigInteger(millilitres);
		if( ir.compareTo(remain) > 0 ){
//	        System.out.println( ir1.toString() );
//	        System.out.println( ir2.toString() );
//
//	        System.out.println( ir.toString() );
//	        System.out.println( remain.toString() );

			return "0";
		}else{
			remain = remain.subtract(ir);
		}
		
		BigInteger result = BigInteger.ONE;
		
		while(remain.compareTo(BigInteger.ZERO) > 0 ){
			ir = ir.add(four);
			if( ir.compareTo(remain) > 0){
				return result.toString(); 
			}else if(ir.compareTo(remain) == 0 ){
				result = result.add(BigInteger.ONE);
				return result.toString(); 
			}else{
				remain = remain.subtract(ir);
				result = result.add(BigInteger.ONE);
			}
		}
		
		return result.toString(); 
	}
	
	public static String gbe12(String sa1, String sn, String sd){
		BigInteger a1 = new BigInteger(sa1);
		BigInteger n = new BigInteger(sn);
		BigInteger d = new BigInteger(sd);
		
		BigInteger two = new BigInteger("2");
		a1 = a1.multiply(new BigInteger("2"));
		BigInteger tn = n.subtract(BigInteger.ONE).multiply(d) ; 
		tn = a1.add(tn).multiply(n).divide(two);
		return tn.toString();
	}
	
	public static String  gbee(String sa1 , String tar){
		BigInteger a = new BigInteger("100");
		BigInteger target = new BigInteger(tar);
		
		BigInteger ir1 = new BigInteger(sa1) ;
		BigInteger ir2 = ir1.add(BigInteger.ONE);
		ir1 = ir1.multiply(ir1);
		ir2 = ir2.multiply(ir2);
		BigInteger ir = ir2.subtract(ir1); 
		
		while(a.compareTo(BigInteger.ZERO) > 0 ){
			BigInteger temp = new BigInteger(gbe12(ir.toString()  , a.toString() , "4" ));
			if(temp.compareTo(target) <= 0){
				return a.toString() ;
			}
			a = a.subtract(BigInteger.ONE) ; 
		}
		
		return "" ;
	}
	
	public static String doubleBE(String sa1 , String star){
		double ta1 = new Double(sa1);
		
		BigInteger ir1 = new BigInteger(sa1) ;
		BigInteger ir2 = ir1.add(BigInteger.ONE);
		ir1 = ir1.multiply(ir1);
		ir2 = ir2.multiply(ir2);
		BigInteger ir = ir2.subtract(ir1); 
		
		double a1 = ir.doubleValue();
//		System.out.println(a1);

		double tar = new Double(star);
		
		double tar_sqrt = Math.sqrt(tar);
		double n = 1 ; 
		if( tar_sqrt > ta1 ){
			n = new Double(tar_sqrt).intValue() ;
			System.out.println(n);

		}
		
		if( n == 1){
			while(true){
				
				double temp = n * ( 2* (a1) +(n-1)*4 ) / 2  ;
//				System.out.println(a1+" "+temp+" "+tar);
				if(temp >= tar ){
					n -- ;
					break ; 
				}else{
					n++ ; 
				}
			}
		}else{
			while(n >= 0 ){

				double temp = n * ( 2* a1 +(n-1)*4 ) / 2  ;
				System.out.println(n+" "+temp+" "+tar);

				if(temp <= tar ){
					break ; 
				}else{
					n-- ; 
				}
			}
		}
		
		return ""+(new Double(n).intValue()) ; 
	}
	
	
	public static String get1(String r , String t){
		BigInteger b = (new BigInteger(r)).multiply(new BigInteger("2")).subtract(BigInteger.ONE);
		BigInteger c = new BigInteger(t);
		return sqrt(b.multiply(b).add(c.multiply(new BigInteger("8")))).subtract(b).divide(new BigInteger("4")).toString() ; 
	}
	
	public static String get(double r , double t ){
		double a = 2 ; 
		double b = 2 * r - 1 ; 
		double c = - t ; 
		
		System.out.println("b is"+(b*b));
		
		double ans = ( (0 - b) + Math.sqrt((b*b)-(4*a*c)) ) / (2 * a);
		return (new Double(ans).intValue())+"" ;
	}
	
		public static BigInteger sqrt(BigInteger n) {
			  BigInteger a = BigInteger.ONE;
			  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
			  while(b.compareTo(a) >= 0) {
			    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
			    else a = mid.add(BigInteger.ONE);
			  }
			  return a.subtract(BigInteger.ONE);
		}

}
