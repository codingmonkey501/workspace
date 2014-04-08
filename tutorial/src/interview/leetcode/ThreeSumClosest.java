package interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {

	
	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	public static void main(String[] args) {
		ThreeSumClosest s = new ThreeSumClosest();
		System.out.println(s.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.out.println(s.threeSumClosest(new int[] { 13, 2, 0, -14, -20,
				19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0,
				20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19,
				17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12,
				-1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15,
				3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17,
				-19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12,
				14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13,
				5, 0, 5, 6 }, -59));
		System.out.println(s.threeSumClosest(
				new int[] { 43, 75, -90, 47, -49, 72, 17, -31, -68, -22, -21,
						-30, 65, 88, -75, 23, 97, -61, 53, 87, -3, 33, 20, 51,
						-79, 43, 80, -9, 34, -89, -7, 93, 43, 55, -94, 29, -32,
						-49, 25, 72, -6, 35, 53, 63, 6, -62, -96, -83, -73, 66,
						-11, 96, -90, -27, 78, -51, 79, 35, -63, 85, -82, -15,
						100, -82, 1, -4, -41, -21, 11, 12, 12, 72, -82, -22,
						37, 47, -18, 61, 60, 55, 22, -6, 26, -60, -42, -92, 68,
						45, -1, -26, 5, -56, -1, 73, 92, -55, -20, -43, -56,
						-15, 7, 52, 35, -90, 63, 41, -55, -58, 46, -84, -92,
						17, -66, -23, 96, -19, -44, 77, 67, -47, -48, 99, 51,
						-25, 19, 0, -13, -88, -10, -67, 14, 7, 89, -69, -83,
						86, -70, -66, -38, -50, 66, 0, -67, -91, -65, 83, 42,
						70, -6, 52, -21, -86, -87, -44, 8, 49, -76, 86, -3, 87,
						-32, 81, -58, 37, -55, 19, -26, 66, -89, -70, -69, 37,
						0, 19, -65, 38, 7, 3, 1, -96, 96, -65, -52, 66, 5, -3,
						-87, -16, -96, 57, -74, 91, 46, -79, 0, -69, 55, 49,
						-96, 80, 83, 73, 56, 22, 58, -44, -40, -45, 95, 99,
						-97, -22, -33, -92, -51, 62, 20, 70, 90 }, -284));
		System.out.println(s.threeSumClosest(new int[] { 23, -57, -16, 2, -22,
				58, -68, -90, 98, 18, -66, 11, 98, 41, 18, 74, -90, 58, 100,
				62, 32, 44, 48, 34, -16, -5, -74, 60, 28, 54, -65, -53, 24, 92,
				4, -10, -39, -68, 88, -65, 86, -18, -87, -64, -44, 94, -77, 95,
				91, -91, -39, 63, -55, 31, -99, 78, -66, 9, 39, 67, 56, 58,
				-73, 67, -39, 23, 91, -89, 83, -86, -81, 64, 25, 99, -12, 14,
				91, -34, 91, -93, -90, -40, -34, -24, -80, 63, 40, 39, -33,
				-62, -1, 46, -14, -22, 12, -67, -29, -15, 67, 46, -49, -72,
				-69, -20, 48, 12, -24, 75, 4, 8, -43, -86, -13, -2, -5, -92,
				-23, -9, 75, 59, -44, -4, -30, -72, -7, 84, 88, -56, -1, -47,
				-72, 28, 68, -19, 33, 98, 50, -10, -13, -12, -60, 70, 31, -14,
				-15, 6, 65, -15 }, -56));
		System.out.println(s.threeSumClosest(new int[] { 84, 58, 16, -6, -34,
				72, 96, 56, -31, 45, -6, 53, -79, -43, -92, -88, 3, 16, -6, 33,
				84, -62, 0, -29, -88, 58, -14, 21, 51, 61, 1, 17, 26, 57, -55,
				39, 95, 50, -16, 25, 85, 65, -25, 23, -82, -85, -99, -20, 34,
				89, 67, 93, 60, -21, -87, 47, 62, -1, 63, -96, 75, 94, 81, -29,
				56, 69, -78, 49, 36, -80, 49, -26, 3, -29, 52, -77, 38, 31,
				-49, -100, -44, -60, 62, -24, 45, -88, 63, -36, 7, -99, 22, 18,
				77, 11, 9, -63, 44, 6, -30, 71, -68, 0, 37, 29, -68, 71, -35,
				83, 4, -3, -3, -100, -88, -19, 3, 92, -47, 33, -61, -96, -23,
				51, 87, 2, 26, 72, 38, -42, 77, -43, 17, 83, -59, 82, 45, -81,
				-41, -58, 30, -85, -67, 51, -27, 63, -54, 83, -6, 68, 81, -17,
				24, -59, 96, 59, -78, 48, -100, -81, 25, -28, -82, 15, -76, 86,
				65, -48, -67, -20, 90, -89, -89, 9, 1, 46, -67, 71, -51, 69,
				-2, 14, 89, -89, -1, 85, -20, -57, 75, 28, 22, -35, 81 }, -48));

	}
	

	
	int threeSumClosest(int[] num, int target) {
		int result = 0;
		int minGap = Integer.MAX_VALUE;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int n:num){
			arr.add(n);
		}
		//sort first
		Collections.sort(arr);
		
		//approching the target by move towards middle
		for (int first=0; first!= arr.size()-2; first++) {
			int mid = first+1;
			int last = arr.size()-1;
			
			while (mid < last) {
				int sum = arr.get(first) + arr.get(mid) + arr.get(last);
				int gap = Math.abs(sum - target);
				if (gap < minGap) {
					result = sum;
					minGap = gap;
				}
				if (sum < target) mid++;
				else last--;
			}
		}
		return result;
	}
	
	
	
	int diff=0;
    int closestSum=0;
    
	public int threeSumClosest2(int[] num, int target) {
        if(num==null || num.length==0) return -1;
        closestSum=num[0] +num[1] +num[2];
        diff=Math.abs(closestSum-target);
        dfs(num, 0, target, 0, 0);
        return closestSum;
    }

    public void dfs(int[] num, int sum, int target, int start, int count){
        if(start==num.length) return;
        dfs(num, sum, target, start+1, count);
        sum+=num[start];
        count++;
        if(count>3) return;
        if(count==3) {
            if(Math.abs(sum-target)<=diff){
            	diff=Math.abs(sum-target);
            	closestSum=sum;
            }
            return;
        }
        dfs(num, sum, target, start+1, count);
        sum-=num[start];
        count--;
    }
    
    
    

}
