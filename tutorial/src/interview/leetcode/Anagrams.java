package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Anagrams {

	
	/**
	 * Given an array of Strings, return all groups of Strings that are anagrams.
		Note: All inputs will be in lower-case.
	 */
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		a.anagrams(new String[]{"", ""});
	}
	//	Input:	["",""]
	//	Output:	[]
	//	Expected:	["",""]

	public ArrayList<String> anagrams(String[] strs) {
		
		HashMap<String, ArrayList<String>> group =new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			//sort string
			char[] chars = s.toCharArray();
	        Arrays.sort(chars);
	        String key = new String(chars);
	        
			if(group.containsKey(key)) { //check key contain, otherwise throw null pointer exception
				group.get(key).add(s);
			} else {
				ArrayList<String> arr=new ArrayList<String>();
				arr.add(s); // do remember add s first
				group.put(key, arr);
			}
		}
		
		
		ArrayList<String> result=new ArrayList<String>();
		//traverse hashmap
		Set<String> groupkeys=group.keySet();
		Iterator<String> it=groupkeys.iterator();
		while(it.hasNext()){
			String key=it.next();
			ArrayList<String> r=group.get(key);
			if(r.size()>1){
				result.addAll(r);
			}
		}
		
		return result;
    }
}
