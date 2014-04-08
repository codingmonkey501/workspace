package interview.leetcode;

public class SearchinRotatedSortedArray {

	
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		You are given a target value to search. If found in the array return its index, otherwise return -1.
		
		You may assume no duplicate exists in the array.
	 */
	
	public int search(int[] A, int target) {
		if(A==null || A.length==0) return -1;
        
        int start=0;
        int end=A.length-1;
        
        while(start<=end){
            int mid=(start+end)/2;
            if(A[mid]==target) {
            	return mid;
            }
            else if(A[mid]<target){
                if(A[start]<A[mid]){
                    start=mid+1;
                }else{
                    //move both end inside
                    if(A[start]==target) return start;
                    else start++;
                    if(A[end]==target) return end;
                    else end--;
                }
                
            }else if(A[mid]>target){
                if(A[end]>A[mid]){
                    end=mid-1;
                }else{
                    //move both end inside
                    if(A[start]==target) return start;
                    else start++;
                    if(A[end]==target) return end;
                    else end--;
                }
            }
        }
        
        return -1;
    }
}
