package interview.leetcode;

public class SearchinRotatedSortedArrayII {

	
	/**
	 * Follow up for "Search in Rotated Sorted Array":
		What if duplicates are allowed?
		
		Would this affect the run-time complexity? How and why?
		
		Write a function to determine if a given target is in the array.
	 */
	public static void main(String[] args) {

	}
	
	public boolean search(int[] A, int target) {
        return search(A, A.length, target);
    }
    
    public boolean search(int A[], int n, int key) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (A[mid] == key) return true; //return m in Search in Rotated Array I
            if (A[left] < A[mid]) { //left half is sorted
                if (A[left] <= key && key < A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (A[left] > A[mid]) { //right half is sorted
                if (A[mid] < key && key <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else left++;
        }
        return false;
    }

}
