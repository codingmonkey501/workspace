package interview.leetcode;

public class SearchforaRange {

	
	
	/**
	 * Given a sorted array of integers, find the starting and ending position of a given target value.

			Your algorithm's runtime complexity must be in the order of O(log n).
			
			If the target is not found in the array, return [-1, -1].
			
			For example,
			Given [5, 7, 7, 8, 8, 10] and target value 8,
			return [3, 4].
	 */
	public static void main(String[] args) {

	}
	
	
	public int[] searchRange(int[] A, int target) {
        int lower = lower_bound(A, target);
        int upper = upper_bound(A, target);
        
        if(lower==A.length || A[lower]!=target)
        	return new int[]{-1,-1};
        else
        	return new int[]{lower, upper-1};
    }
    
    public int lower_bound(int[] A, int target){
        int begin=0;
        int end=A.length;
        
        while(begin!=end){
            int mid=(begin+end)/2;
            if(target > A[mid])
                begin=mid+1;
            else
                end=mid;
        }
        return begin;
    }
    
    
    public int upper_bound(int[] A, int target){
        int begin=0;
        int end=A.length;
        
        while(begin!=end){
            int mid=(begin+end)/2;
            if(target>=A[mid])
                begin=mid+1;
            else
                end=mid;
        }
        return begin;
    }
    
    
    //not O(logn)
    public int[] searchRange2(int[] A, int target) {
        int begin=-1;
        int end=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                if(begin==-1) begin=i;
                if(begin!=-1) {
                    if(i+1!=A.length && A[i+1]!=target)
                        end=i;
                    else if(i+1==A.length) //wrong here : need to cover senario [2,2]
                        end=i;
                }
            }
        }
        return new int[]{begin, end};
    }

}
