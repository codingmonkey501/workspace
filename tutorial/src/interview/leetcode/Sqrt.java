package interview.leetcode;

public class Sqrt {

	
	
	/**
	 * Implement int sqrt(int x).

		Compute and return the square root of x.
	 */
	public static void main(String[] args) {
		Sqrt s=new Sqrt();
		System.out.println(s.sqrt(0));
		System.out.println(s.sqrt(10));
		System.out.println(s.sqrt2(16));
	}
	
	//even the return change to double it still work
	public double sqrt(int x) {
        if(x==0) return 0;//be careful input 0
        double upper=x; // x+1>=2root(x) is an famous equation
        double lower=0;
        while(lower<=upper-0.001){
        	double mid=lower+(upper-lower)/2;
            if(x/mid>mid){
                lower=mid;
            }else if(x/mid<mid){
                upper=mid;
            }else{
                return mid;
            }
        }
        return (upper+lower)/2;
    }
	

	//integer version
	public int sqrt2(int x) {
        if(x==0) return 0;//be careful input 0
        int upper=x/2; // x/2>root(x) is an famous equation
        int lower=1;
        int result=1; //be careful when input is 1
        while(lower<=upper){
            int mid=lower+(upper-lower)/2;
            if(x/mid>mid){
                lower=mid+1;
                result=mid;
            }else if(x/mid<mid){
                upper=mid-1;
            }else{
                return mid;
            }
        }
        
        return result;
    }
	
}
