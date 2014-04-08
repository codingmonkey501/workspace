package interview.leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram {

	/**
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * 
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */
	//[2,1,5,6,2,3,1,2,1,2,5] should return 11
	public static void main(String[] args) {
		LargestRectangleinHistogram l=new LargestRectangleinHistogram();
		System.out.println(l.largestRectangleArea(new int[]{1}));
		System.out.println(l.largestRectangleArea(new int[]{1,1}));
		System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3}));
		System.out.println(l.largestRectangleArea(new int[]{3,1,5,6,2,3,1,2,1,2,5}));
		System.out.println(l.largestRectangleArea(new int[]{1,2,3,8}));
	}

	
	
	public int largestRectangleArea(int[] height) {
		if(height.length==0) return 0;
		Stack<Integer> s = new Stack<Integer>();
		int result = height[0];
		for (int i = 0; i <= height.length;) {
			if (s.isEmpty() || (i!=height.length && height[i] > height[s.peek()])) {
				s.push(i++);
			} else {
				result = Math.max(result,
						height[s.pop()] * (s.empty() ? i: i - s.peek() - 1));
			}
		}
		return result;
	}

}
