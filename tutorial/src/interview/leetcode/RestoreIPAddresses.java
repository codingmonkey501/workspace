package interview.leetcode;

import java.util.ArrayList;

public class RestoreIPAddresses {

	
	/**
	 * Given a string containing only digits, restore it by returning all possible 
	 * valid IP address combinations.

		For example:
		Given "25525511135",
		
		return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	public static void main(String[] args) {
		RestoreIPAddresses r=new RestoreIPAddresses();
		r.restoreIpAddresses("0000");
		r.restoreIpAddresses("111111111111111111111111111");
		r.restoreIpAddresses("010010");
		r.restoreIpAddresses("00");
		
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		restoreIpAddresses(s, "", 0, result);
		return result;
	}

	public void restoreIpAddresses(String rest, String validip, int num,
			ArrayList<String> result) {
		
		if (num == 4) {
			if(rest.length()>0) return; //illegal if still have string not parsed
			result.add(validip.substring(0, validip.length()-1)); //remove last point
			return;
		}
		
		boolean valid=true;
		for(int i=1; valid && i<=rest.length();i++){
			int code = -1;
			
			String codestr=rest.substring(0, i);
			if(codestr.length()>=2 && codestr.startsWith("0"))  //"010" is illegal
				return;
			try{
			    code=Integer.parseInt(codestr); //parse "0000" has exception
			}catch(Exception e){}
			
			if (code <= 255 && code >= 0) {
				valid = true;
				String ip = validip + code+ "."; //wrong here : should not be vlidip+=code +"." --> 0.1.0.0.1.10
				restoreIpAddresses(rest.substring(i, rest.length()), ip, num+1, result); //either num++ , ++num won't work
			} else {
				valid = false;
			}
		}
	}

}
