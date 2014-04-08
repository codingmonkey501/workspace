package interview.leetcode;

public class PalindromeNumber {

	
	
	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	
		//The first 30 palindromic numbers (in decimal) are:
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202...


		click to show spoilers.
		
		Some hints:
		Could negative integers be palindromes? (ie, -1)
		
		If you are thinking of converting the integer to string, note the restriction of using extra space.
		
		You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
		
		There is a more generic way of solving this problem.
	 */
	public boolean isPalindrome(int x) {
    
		if(x<0) return false;//it does matter if x is negtive or not
		
		int num=0;
		int remain=x;
		while(remain!=0){
			int digit=remain%10;
			remain/=10;	//put remain in wrong place
			num=num*10+digit;
		}
		return num==x;
		
    }
	
	
}
