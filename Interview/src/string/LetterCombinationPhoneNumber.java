package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationPhoneNumber {
	
	public static void main(String[] args){
		
	List<String> res = letterCombinations("23");
	System.out.println(res);
	
	System.out.println(letterCombinationsRec("23"));
	
	}
	
	// Recursive Approach
	
	static String [][] charMap = {{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    
    public static List<String> letterCombinationsRec(String digits) {
        
        List<String> str = new ArrayList<String>();
        if(!digits.equals("")){
            combine(str,digits,"");
            return str;
        }
        
        return str;   
 
    }
    
    public static void combine(List<String> str, String digits, String s){
        
        if(digits.length() == 0){
            str.add(s);
            return;
        }
        
        int index = Integer.parseInt(digits.substring(0,1));
        
        for(String k: charMap[index]){
            combine(str,digits.substring(1,digits.length()), s+k);
        }
        
        return;
        
    }
	
	// Iterative Method
	public static List<String> letterCombinations(String digits) {
	
		List<String> str  = new LinkedList<String>();
		if(digits == null || digits.length() == 0)
			return str;
		
		String[] charMap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		str.add("");
		for(int i=0;i<digits.length();i++){
			List<String> tempstr = new LinkedList<String>();
			String digitstr = charMap[digits.charAt(i) - '0'];
			for(int j=0;j<digitstr.length();j++){
				for(int k=0;k<str.size();k++){
					tempstr.add(tempstr.size(),str.get(k) + digitstr.charAt(j));
				}
			}
			str = tempstr;
		}
	
		return str;
	}
}

