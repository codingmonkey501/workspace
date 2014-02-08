package interview.leetcode;

public class SortColors {
	/**
	 * 
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 */
	public static void sortColors1(int[] A) {
		int i = 0;
		int j = 0;
		int k = 0;

		for (int l = 0; l < A.length; l++) {
			if (A[l] == 0) {
				i++;
			} else if (A[l] == 1) {
				j++;
			} else if (A[l] == 2) {
				k++;
			}
		}
		int l = 0;
		for (int m = i; m > 0; m--) {
			A[l] = 0;
			l++;
		}
		for (int m = j; m > 0; m--) {
			A[l] = 1;
			l++;
		}
		for (int m = k; m > 0; m--) {
			A[l] = 2;
			l++;
		}
	}

	/**
	 * Follow up: A rather straight forward solution is a two-pass algorithm
	 * using counting sort. First, iterate the array counting number of 0's,
	 * 1's, and 2's, then overwrite array with total number of 0's, then 1's and
	 * followed by 2's.
	 * 
	 * Could you come up with an one-pass algorithm using only constant space?
	 * 
	 */
	public static void sortColors2(int[] A) {
		
		int j = 0;
		int k = A.length-1;
		
		while (A[k]==2){ //remember to initiate the value
			k--;
			if(k==-1) break;
		}
		
		while (A[j]==0){
			j++;
			if(j==A.length) break;
		}
		
		for (int l = 0; l < A.length; l++) {
			if(A[l] == 0){
				if(l>j){ // check l > j condition
					swap(A, l, j);
				}
			}else if(A[l]==2){
				if(k<l) return;
					
				if(A[k] == 1){
					swap(A, l, k);
				}else if (A[k] == 0){
					swap(A, l, k);
					if(l>j){
						swap(A, l, j);
					}
				}
				
			}
			if(k>0){
				while (A[k]==2){
					k--;
					if(k==-1) break;
				}
			}
			
			if(j<A.length){ // do not forget to check out of bound
				while (A[j]==0){
					j++;
					if(j==A.length) break; // do not forget to check out of bound
				}
			}
		}
	}
	
	public static void sortColors3(int[] A){
		int n= A.length;
		if(n <= 1) return;
	    int i = 0;
	    int j = n-1;
	    int cur = i;
	    while(cur <= j) {  //check [1,0]
	        if(A[cur] == 0) {
	            if(cur > i) swap(A, i, cur);
	            else ++cur;
	            i++;
	        } else if (A[cur] == 2) {
	            if(cur < j) swap(A, j--, cur); //swap j and curr and then j--
	            else return; // check[2,2]
	        } else {
	        	++cur;
	        }
	            
	    }
	}
	
	public static void swap(int[] A, int m, int n){
		if(n!=-1 && n <A.length){
			int temp = A[m];
			A[m] = A[n];
			A[n] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 0,1,2,1 };
		sortColors3(arr);
		for (int l = 0; l < arr.length; l++) {
			System.out.print(arr[l]);
		}
	}
}
