package interview.leetcode;

public class SearchInsertPosition {

	/**
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples. 
	 * [1,3,5,6], 5 → 2 
	 * [1,3,5,6], 2 → 1 
	 * [1,3,5,6], 7 → 4
	 * [1,3,5,6], 0 → 0
	 */
	
	public int searchInsert(int[] A, int target) {
        if(A==null) return -1;
        int i=0;
        while(target>A[i]){ //wrong here 
            i++;
            if(i==A.length) break;
        }
        return i;
    }
	
	
	public static void main(String[] args) {
		
	}

}
