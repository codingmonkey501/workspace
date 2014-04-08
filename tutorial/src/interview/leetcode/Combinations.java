package interview.leetcode;

import java.util.ArrayList;

public class Combinations {

	
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

		For example,
		If n = 4 and k = 2, a solution is:
		
		[
		  [2,4],
		  [3,4],
		  [2,3],
		  [1,2],
		  [1,3],
		  [1,4],
		]
	 */
	
	//permutation
    public ArrayList<ArrayList<Integer>> permutation(int n, int k) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<n;i++) arr.add(i+1);
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(n==0 || k>n || k==0) return result;
        recusive(result, arr, 0, k);
        return result;
    }
    
    public void recusive(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr, int repl, int k){
        if(k==1){
            for(int j=repl;j<arr.size();j++){
                ArrayList<Integer> r=new ArrayList<Integer>();
                for(int i=0;i<repl+1;i++){
                    swap(arr, repl, j);
                    r.add(arr.get(i));
                    swap(arr, repl, j);
                }
                result.add(r);
            }
        }
        for(int j=repl;j<arr.size();j++){
            swap(arr, repl, j); //everytime swap with the first element
            recusive(result, arr, repl+1, k-1);
            swap(arr, repl, j);
        }
    }
    
    public void swap(ArrayList<Integer> arr, int i, int j){
        int temp=arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    
    
    //combination
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(n==0 || k==0 || n<k) return result;
        int[] prototype=new int[n];
        for(int i=0;i<n;i++) prototype[i]=i+1;
        int[] row=new int[k];
        
        recusive2(result, prototype, row, 0, 0);
        return result;
    }
    
    public void recusive2(ArrayList<ArrayList<Integer>> result, int[] prototype, int[] row, int nextLimit, int indexofres){
        
        if(indexofres==row.length) {
            ArrayList<Integer> resrow=new ArrayList<Integer>();
            for(int j=0;j<row.length;j++){
                resrow.add(row[j]);
            }
            result.add(resrow);
            return;
        }
        if(nextLimit==prototype.length) return;//wrong here : should not put in the first line , (1,1) will have issue here
        
        for(int pick=nextLimit; pick<prototype.length; pick++){
            row[indexofres]=prototype[pick];
            recusive2(result, prototype, row, pick+1, indexofres+1);//wrong here: should be pick+1
        }
    }
}
