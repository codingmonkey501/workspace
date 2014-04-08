package interview.leetcode;


import java.util.ArrayList;

public class MergeIntervals {
	/**
	 * Given a collection of intervals, merge all overlapping intervals.
		
		For example,
		Given [1,3],[2,6],[8,10],[15,18],
		return [1,6],[8,10],[15,18].
	 */
	public static void main(String[] args) {

		////double for loop cannot cover [[2,3],[4,5],[6,7],[8,9],[1,10]]
		Interval i1=new Interval(2, 3);
		Interval i2=new Interval(4, 5);
		Interval i3=new Interval(6, 7);
		Interval i4=new Interval(8, 9);
		Interval i5=new Interval(1, 10);
		ArrayList<Interval> intervals=new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		
		MergeIntervals m=new MergeIntervals();
		m.merge(intervals);
	}

	// time complexity O(n1+n2+...)
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result=new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++) {
			new InsertInterval().insert(result, intervals.get(i));
		}
		return result;
	}
	
	
	public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
		for (int i = 0; i < intervals.size(); ) {
			int start1 = intervals.get(i).start;
			int end1 = intervals.get(i).end;
			boolean merged = false;
			for (int j = i + 1; j < intervals.size();) {
				int start2 = intervals.get(j).start;
				int end2 = intervals.get(j).end;

				//if (end2 >= start1 && end2 <= end1 || start2 >= start1
				//		&& start2 <= end1 || start1 >= start2 && end1 <= end2) {
				
				if(!(end2<start1 || start2>end1)){ //better
					start1 = Math.min(start1, start2);
					end1 = Math.max(end1, end2);
					intervals.remove(j);
					merged = true;
				} else {
					j++;
				}
			}
			if (merged) {
				intervals.get(i).start = start1;
				intervals.get(i).end = end1; //no i++ here
			}else{
				i++; //without this : double for loop cannot cover [[2,3],[4,5],[6,7],[8,9],[1,10]]
			}
		}
		return intervals;
    }
	
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
