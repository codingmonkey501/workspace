package interview.leetcode;

import java.util.ArrayList;

public class PermutationSequence {

	
	/**
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.

		By listing and labeling all of the permutations in order,
		We get the following sequence (ie, for n = 3):
		
		"123"
		"132"
		"213"
		"231"
		"312"
		"321"
		Given n and k, return the kth permutation sequence.
		
		Note: Given n will be between 1 and 9 inclusive.
	 */
	public static void main(String[] args) {
		PermutationSequence p=new PermutationSequence();
		System.out.println(p.getPermutation(4, 2));
	}
	
	//? hard
	public String getPermutation(int n, int k) {
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
 
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;
 
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result;
	}
		
		
		
	// solution 2
	public String getPermutation2(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < n; ++i)
			num[i] = i+1;
		for (int i = 0; i < k - 1; ++i)
			nextPermutation(num);
		String result="";
		for (int i=0;i<n;i++) // convert array to string
			result+=num[i];
		return result; 
	}
	
	
	public void nextPermutation(int[] num) {
		
		if(num.length==1) return;
		
		// Get a reversed range to simplify reversed traversal.
		int last = num.length-1;
		int pivot = last-1;
		while (pivot!=-1 && num[pivot] >= num[pivot+1])
			pivot--;
		
		if (pivot == -1) {
			reverse(num, 0, num.length-1);
			return;
		}
		
		int change=last;
		while (pivot!=change){
			if(num[change] > num[pivot])
				break;
			change--;
		}
		
		swap(num, change, pivot);
		
		reverse(num, pivot+1, num.length-1);
		
    }
	
	//how to reverse array
	private void reverse(int[] num, int first, int last) {
		int len = last - first + 1;
		for (int i = 0; i < len / 2; i++) {
			int tmp = num[first + i];
			num[first+ i] = num[last - i];
			num[last - i] = tmp;
		}
	}
	
	private void swap(int[] num, int a, int b) {
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
}
