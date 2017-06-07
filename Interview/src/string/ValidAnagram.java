package string;
/*
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.
	Note:
	You may assume the string contains only lowercase alphabets.
 * 
 * 
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("paratha","thapraa"));
	}
	
	 public static boolean isAnagram(String s, String t) {
		 if(s.length()!=t.length())
			 return false;
		 
		 int[] freq = new int[26];
		 
		 for(int i=0;i<s.length();i++){
			 char c = s.charAt(i);
			 freq[c - 'a']++;
		 }
		 
		 for(int i=0;i<t.length();i++){
			 char c = t.charAt(i);
			 freq[c - 'a']--;
		 }
		 
		 for(int i=0;i<26;i++){
			 if(freq[i]!=0)
				 return false;
		 }
		 return true;
	}

}
