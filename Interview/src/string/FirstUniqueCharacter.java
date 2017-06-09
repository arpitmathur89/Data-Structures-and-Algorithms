package string;

import java.util.HashMap;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("malayalam"));
	}
	
	public static int firstUniqChar(String s) {
		
		if(s.length() == 0)
			return -1;
		
		HashMap<Character,Integer> hmap  = new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(hmap.containsKey(s.charAt(i))){
				hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
			}
			else{
				hmap.put(s.charAt(i), 1);
			}
		}
		
		for(int i=0;i<s.length();i++){
			if(hmap.get(s.charAt(i)) < 2){
				return i;
			}
		}
		
		return -1;
	}
}
