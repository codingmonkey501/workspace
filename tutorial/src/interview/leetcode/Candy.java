package interview.leetcode;

public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 */
	public static void main(String[] args) {
		
		int[] ratings=new int[]{1,6,2,5,4,3};
		Candy c=new Candy();
		System.out.println(c.candy(ratings));
	}
	
	public int candy(int[] ratings) {
		
		int[] increment=new int[ratings.length];
		
		for (int i = 1, inc = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				increment[i] = Math.max(inc++, increment[i]);
			else
				inc = 1;
		}
		
		for (int i = ratings.length - 2, inc = 1; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				increment[i] = Math.max(inc++, increment[i]);
			else
				inc = 1;
		}
		
		int sum=0;
		for(int num:increment){
			sum+=num;
		}
		
		return sum+ratings.length;
	}
	
	//wrong answer {1,6,2,5,4,3}
	public int candy2(int[] ratings) {
		int candy = 0;
		int childnum = ratings.length;
		int max = Integer.MIN_VALUE;
		int lastmax = Integer.MAX_VALUE;
		while (childnum > 0) {

			for (int i = 0; i < ratings.length; i++) {

				int value = ratings[i];
				if (lastmax == value) {
					
					candy++;
					int left = i - 1;
					int right = i + 1;
					while (left > -1) {
						if (ratings[left] > lastmax)
							candy++;
						else
							break;
						left--;
					}
					
					while (right < ratings.length) {
						if (ratings[right] > lastmax)
							candy++;
						else
							break;
						right++;
					}
				}
				if (value > max && value < lastmax) {
					max = value;
				}
				if (lastmax == Integer.MAX_VALUE)
					candy++;
			}
			
			lastmax = max;
			max = Integer.MIN_VALUE;
			childnum--;
		}
		return candy;
	}

}
