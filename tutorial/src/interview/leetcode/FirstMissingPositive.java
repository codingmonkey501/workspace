package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

	
	/**
	 * Given an unsorted integer array, find the first missing positive integer.

			For example,
			Given [1,2,0] return 3,
			and [3,4,-1,1] return 2.
			
			Your algorithm should run in O(n) time and uses constant space.
	 */
	
	public static void main(String[] args){
		FirstMissingPositive f=new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(new int[]{2,1}));
		System.out.println(f.firstMissingPositive(new int[]{1,0}));
		System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1}));
	}
	
	public int firstMissingPositive(int[] A) {
		bucketSort(A);
        for(int i = 0; i < A.length; ++i)
            if(A[i] != i + 1)
                return i + 1;
        return A.length + 1;
    }
	
	public void bucketSort(int[] A){
		int len=A.length;
		for(int i = 0; i <len; ++i) {
            while(A[i] != i + 1) {
                if(A[i] <= 0 || A[i] > len || A[i] == A[A[i]-1]) //put A[i] into a position and value same
                    break;
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
	}
		
		
		
	//maybe this solution is not constant space
    public int firstMissingPositive2(int[] A) {
        
        if(A==null || A.length==0) return 1;
        Map<Integer, Boolean> hashMap=new HashMap<Integer, Boolean>();
        for(int i:A){
            hashMap.put(i, false); //[4,2,0,1,4]
        }
        
        if(hashMap.get(1)==null) return 1;
        
        int n=-1;
        int lowerlimit=Integer.MAX_VALUE; //wrong here
        int upperlimit=Integer.MAX_VALUE;
        
        for(int i=0;i<A.length;i++){
            
            n=A[i];
            if(hashMap.get(n)) continue;
            hashMap.put(n, true);
            if(n-1<lowerlimit && n-1>0) lowerlimit=n-1;
            if(n+1<upperlimit && n+1>0) upperlimit=n+1;
            
            while(hashMap.get(lowerlimit)!=null || hashMap.get(upperlimit)!=null){
                if(hashMap.get(lowerlimit)!=null) {
                    hashMap.put(lowerlimit, true);
                    lowerlimit--;
                }
                if(hashMap.get(upperlimit)!=null) {
                    hashMap.put(upperlimit, true);
                    upperlimit++;
                }
            }
            
        }
        if(lowerlimit<=0) return upperlimit;
        return Math.min(upperlimit, lowerlimit); //get the smaller one
        
    }
}
