package string;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
substring, "pwke" is a subsequence and not a substring.

 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap  = new HashMap<>();
        int maxlen = 0;

        for(int i=0,j=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hmap.containsKey(c)){
                j = Math.max(j,hmap.get(c) + 1);
            }
            else{
                hmap.put(c,i);
                maxlen = Math.max(maxlen, i-j +1);
            }
        }
        return maxlen;
    }
}
