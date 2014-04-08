package interview.leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {

	
	/**
	 * Given an index k, return the kth row of the Pascal's triangle.

		For example, given k = 3,
		Return [1,3,3,1].
		
		Note:
		Could you optimize your algorithm to use only O(k) extra space?
	 */
	
	public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        if(rowIndex<1) return temp;
        temp.add(1);
        
        for(int k=1;k<rowIndex;k++){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(1);
            for(int i=1;i<temp.size();i++){
                result.add(temp.get(i) + temp.get(i-1));
            }
            result.add(1);
            temp=result;
        }
        return temp;
    }
}
