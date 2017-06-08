package stack;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{{}}([])"));
	}
	
	 public static boolean isValid(String s) {
		 
		 Stack<Character> st = new Stack<>();
		 char c;
		 for(int i=0;i<s.length();i++){
			 c = s.charAt(i);
			 if(c == '(' || c == '{' || c == '['){
				 st.push(c);
			 }else if(c == ')' && st.peek() == '('){
				 st.pop();
			 }else if(c == '}' && st.peek() == '{'){
				 st.pop();
			 }else if(c == ']' && st.peek() == '['){
				 st.pop();
			 }else{
				 return false;
			 }
		 }
		 
		 return st.isEmpty();
		 
	 }

}
