package string;
/*
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that
 *  the maximum length of s is 1000.
	
	Example:
	
	Input: "babad"
	
	Output: "bab"
	
	Note: "aba" is also a valid answer.
	Example:
	
	Input: "cbbd"
	
	Output: "bb"
 * 
 * 
 */
public class LongestPalindromicSubString {
	
	// Keep a pointer and expand it to left and right simultaneously until the chars
	// are equal.
    // Keep track of starting point and maxlen to get the substring.
    // Use helper function and call it twice. One for odd length palindrome
	// and one for even length with i,i+1
	
	static int lo;
	static int maxlen;
	public static void main(String[] args) {
		String s = "babadbd";
		System.out.println(longestPalindrome(s));	
	}
	
	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0)
			return s;
		for(int i=0;i<s.length();i++){
			helper(s,i,i); // Called once with i,i for odd length string
			helper(s,i,i+1); // Called once with i,i+1 for even length string
		}
		
		return s.substring(lo, lo+maxlen);
	}
	
	public static void helper(String s, int i,int j){
		while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
			i--;
			j++;
		}
		
		if(maxlen < j-i-1){
			maxlen = j-i-1;
			lo = i+1;
		}	
	}

}
