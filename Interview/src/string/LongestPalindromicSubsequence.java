package string;
/*
 * 
 * Given a string s, find the longest palindromic subsequence's length in s. 
 * You may assume that the maximum length of s is 1000.
	
	Example 1:
	Input:
	
	"bbbab"
	Output:
	4
	One possible longest palindromic subsequence is "bbbb".
	Example 2:
	Input:
	
	"cbbd"
	Output:
	2
 * 
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));

	}
	
	public static int longestPalindromeSubseq(String s) {
		
		int len = s.length();
		
		int [][] dp = new int [len][len];
		for(int i=0;i<len;i++){
			dp[i][i] =1;
		}
		
		for(int l = 2; l<=len; l++){
			for(int i=0;i<=len - l;i++ ){
				int j = i + l -1;
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1]  + 2;
				}else{
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[0][len-1];
	}

}
