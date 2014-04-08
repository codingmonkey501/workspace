package interview.leetcode;

public class ValidParentheses {

	
	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 */
	public static void main(String[] args){
		ValidParentheses v= new ValidParentheses();
		System.out.println(v.isValid("((){}[])"));
		System.out.println(v.isValid("(("));
	}
	
	public boolean isValid(String s) {
        if(s.length()==1) return false;
        else if (s.length()==0) return true; //only 0 return true

        int left=0;
        int right=1;
        
        while(true){
            if((s.charAt(left)=='(' && s.charAt(right)==')')
              || (s.charAt(left)=='[' && s.charAt(right)==']')
              || (s.charAt(left)=='{' && s.charAt(right)=='}')){
            	
            	s = splitAndMerge(s, left, right);
            	return isValid(s);
            }
            left++;
            right++;
            if(right==s.length()) return false; //this line should not in the first line of while loop. "{}" will have problem
        }
    }
	
	 public String splitAndMerge(String s, int left, int right){
    	 //how to remove and merge string
    	String sl=left==0?"":s.substring(0, left);
    	String sr=(right==s.length()-1)?"":s.substring(right+1, s.length()); //should be right+1, s.length()
        return sl + sr; 
    }
}
