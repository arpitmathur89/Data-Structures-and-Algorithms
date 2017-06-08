package stack;

import java.util.Stack;

/*
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest 
 * valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which
 * has length = 4.
 * 
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses(")(((())"));
	}
	// Stack Solution O(n) 
	public static int longestValidParentheses(String s) {
		
		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==')' && st.size()>1 && s.charAt(st.peek())== '('){
				st.pop();
				max = Math.max(max, i-st.peek());
			}else{
				st.push(i);
			}
		}

		return max;
	}

}
