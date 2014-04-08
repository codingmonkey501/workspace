package interview.leetcode;

import java.util.ArrayList;

public class Triangle {

	
	/**
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

		For example, given the following triangle
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
		The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
		
		Note:
		Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 */
	public static void main(String[] args) {
		Triangle t=new Triangle();
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		arr1.add(2);
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(4);
		ArrayList<Integer> arr3=new ArrayList<Integer>();
		arr3.add(6);
		arr3.add(5);
		arr3.add(7);
		ArrayList<Integer> arr4=new ArrayList<Integer>();
		arr4.add(4);
		arr4.add(1);
		arr4.add(8);
		arr4.add(3);
		ArrayList<ArrayList<Integer>> test=new ArrayList<ArrayList<Integer>>();
		test.add(arr1);
		test.add(arr2);
		test.add(arr3);
		test.add(arr4);
		System.out.println(t.minimumTotal(test));
	}
	
	// with O(n^2) time and O(1) space
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	    
        for (int i=triangle.size()-2; i>=0; i--){
            for (int j=0; j<i+1; ++j){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
            
        return triangle.get(0).get(0);
    }
	
	
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0) return 0;
        if(triangle.size()==1) return triangle.get(0).get(0);
        int sum=recusive(0, 0, triangle);
        return sum;
    }
    
    public int recusive(int row, int c, ArrayList<ArrayList<Integer>> triangle){
        if(row==triangle.size()) return 0;
        int curr=triangle.get(row).get(c);
        return Math.min(recusive(row+1, c, triangle)+curr, recusive(row+1, c+1, triangle)+curr);
    }
    
    

}
