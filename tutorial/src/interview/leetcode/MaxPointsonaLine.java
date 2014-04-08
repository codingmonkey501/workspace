package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {

	/**
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */
	public static void main(String[] args) {
		MaxPointsonaLine m = new MaxPointsonaLine();
		System.out.println(m.maxPoints(new Point[] { new Point(2, 3),
				new Point(3, 3), new Point(-5, 3) }));
	}

	// why double have -0.0 and +0.0?
	// The IEEE floating point standard says 1/+0 should be +infinity and 1/-0
	// should be -infinity. This makes sense if you interpret +/- 0 as the ghost
	// of a number that underflowed leaving behind only its sign. The reciprocal
	// of a positive (negative) number too small to represent is a positive
	// (negative) number too large to represent.
	public int maxPoints(Point[] points) {
		if (points.length < 3)
			return points.length;
		int result = 0;
		Map<Double, Integer> slopeCount = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length - 1; i++) {
			slopeCount.clear();
			int samePointNum = 0;
			int pointMax = 1;
			for (int j = i + 1; j < points.length; j++) {
				Double slope=0.0;
				if (points[i].x == points[j].x) {
					slope = Double.POSITIVE_INFINITY;
					if (points[i].y == points[j].y) {
						++samePointNum;
						continue;
					}
				} else {
					slope = 1.0 * (points[i].y - points[j].y)
							/ (points[i].x - points[j].x);
				}
				int count = 0;
				if ((slope.isInfinite() && slopeCount.containsKey(Double.POSITIVE_INFINITY))
						|| ((slope.equals(0.0) || slope.equals(-0.0)) && slopeCount.containsKey(0.0))) { // in case -0.0
																// and +0.0 or
																// positive
																// infinity and
																// negative
																// infinity
					count = slopeCount.get(Math.abs(slope)) + 1;
					slopeCount.put(Math.abs(slope), count);
				} else if (slope.isInfinite() && !slopeCount.containsKey(Double.POSITIVE_INFINITY)
						|| (slope.equals(0.0) || slope.equals(-0.0) &&!slopeCount.containsKey(0.0))) { // in case -0.0
									// and +0.0 or
									// positive
									// infinity and
									// negative
									// infinity
					count=2;
					slopeCount.put(Math.abs(slope), 2);
				} else if (slopeCount.containsKey(slope)) { // in case -0.0
					count = slopeCount.get(slope) + 1;
					slopeCount.put(slope, count);
				} else {
					count = 2;
					slopeCount.put(slope, 2);
				}
				if (pointMax < count)
					pointMax = count;
			}
			result = Math.max(result, pointMax + samePointNum);
		}
		return result;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}