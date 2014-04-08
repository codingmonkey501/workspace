package interview.leetcode;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {

	
	/**
	 * Given an absolute path for a file (Unix-style), simplify it.

		For example,
		path = "/home/", => "/home"
		path = "/a/./b/../../c/", => "/c"
		click to show corner cases.
		
		Corner Cases:
		Did you consider the case where path = "/../"?
		In this case, you should return "/".
		Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
		In this case, you should ignore redundant slashes and return "/home/foo".
	 */
	public static void main(String[] args) {
		SimplifyPath s=new SimplifyPath();
		System.out.println(s.simplifyPath("/a/./b/../../c/"));
		System.out.println(s.simplifyPath("/home//foo/"));
		System.out.println(s.simplifyPath("/../"));
		System.out.println(s.simplifyPath("/..."));
	}
	
	public String simplifyPath(String path) {
		Stack<String> dirs=new Stack<String>(); 
		for (int i=0; i < path.length(); i++) {
			int j = findNextSlash(i, path);
			String dir = path.substring(i, j);
			if (!dir.isEmpty() && !dir.equals(".") && !dir.equals("/")) {
				if ("..".equals(dir)) {
					if(!dirs.isEmpty())
						dirs.pop();
				} else
					dirs.push(dir);
			}
			i = j;
		}
		
		
		String result="";
        if(dirs.isEmpty()) return "/";
        Iterator<String> it=dirs.iterator();	//want to output from bottom to up
        while(it.hasNext()){
        	result+="/" + it.next();
        }
       
        return result;
	}
	
	private int findNextSlash(int start, String path){
		
		for(int i=start;i<path.length();i++){
			if(path.charAt(i)=='/'){
				return i;
			}
		}
		return path.length();
	}
	
	
	//wrong answer can not cover three dots case
	public String simplifyPath2(String path) {
        Stack<String> stack=new Stack<String>();
        int last=0; //0:normal ; 1:slash ; 2: period
        String p="";
        for(int i=0;i<path.length();i++){
        	char c=path.charAt(i);
        	if(c=='/'){
        		if(last==0 && !p.isEmpty()){
        			stack.push(p);
        			p="";
        		}
        		last=1;
        	}else if(c=='.'){
        		if(last==2){
        			if(!stack.isEmpty()) stack.pop();
        			last=0;
        		}
        		last=2;
        	}else{
        		p+=c;
        		last=0;
        	}
        }
        String result="";
        if(stack.isEmpty()) return "/";
        Iterator<String> it=stack.iterator();	//want to output from bottom to up
        while(it.hasNext()){
        	result+="/" + it.next();
        }
       
        return result;
    }

}
