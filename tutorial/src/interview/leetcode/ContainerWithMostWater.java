package interview.leetcode;

public class ContainerWithMostWater {

	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	public static void main(String[] args) {

	}

	// Time limited exceed
	public int maxArea2(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxarea = Math.max(maxarea, Math.min(height[j], height[i])
						* (j - i));
			}
		}
		return maxarea;
	}

	public int maxArea(int[] height) {

		if (height == null || height.length == 0 || height.length == 1)
			return 0;
		int i = 0;
		int j = height.length - 1;
		int maxarea = 0;
		while (i != j) {
			maxarea = Math.max(maxarea,
					(j - i) * Math.min(height[i], height[j]));
			if (height[j] > height[i]) {
				i++;
			} else {
				j--;
			}
		}
		return maxarea;
	}

}
