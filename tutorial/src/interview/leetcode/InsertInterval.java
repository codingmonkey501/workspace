package interview.leetcode;

import interview.leetcode.MergeIntervals.Interval;

import java.util.ArrayList;


public class InsertInterval {

	
	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

		You may assume that the intervals were initially sorted according to their start times.
		
		Example 1:
		Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		
		Example 2:
		Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		
		This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
	public static void main(String[] args) {
		
	////double for loop cannot cover [[2,3],[4,5],[6,7],[8,9],[1,10]]
		Interval i1=new Interval(1, 5);
		Interval i2=new Interval(1, 7);
		ArrayList<Interval> intervals=new ArrayList<Interval>();
		intervals.add(i1);
		
		InsertInterval m=new InsertInterval();
		m.insert(intervals, i2);
		
	}
	
	
	//we want to keep the sequence by the value order of start value
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		int it=0;
		while (it!=intervals.size()) {
			Interval interval=intervals.get(it);
			if (newInterval.end < interval.start) {
				intervals.add(it, newInterval);
				return intervals;
			} else if (newInterval.start > interval.end) {
				it++;
				continue;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
				intervals.remove(it);
			}
		}
		intervals.add(intervals.size(), newInterval);
		return intervals;
    }
	
	
	
	

}
