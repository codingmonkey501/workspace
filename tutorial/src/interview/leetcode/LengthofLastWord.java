package interview.leetcode;

public class LengthofLastWord {

	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

		If the last word does not exist, return 0.
		
		Note: A word is defined as a character sequence consists of non-space characters only.
		
		For example, 
		Given s = "Hello World",
		return 5.
	 */
	
    public int lengthOfLastWord(String s) {
    	String[] arr=s.split(" ");
        if(arr.length<=0) return 0;
        return arr[arr.length-1].length();
        //"a " should return 1
        //"  " two empty space should return 0
        //" " should return 0;
        //"" should return 0;
        //"abc" should return 3
        //" abc" should return 3
        //" a " should return 1
    }
}
