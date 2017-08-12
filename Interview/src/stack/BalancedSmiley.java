package stack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.util.Stack;

/*

Your friend John uses a lot of emoticons when you talk to him on Messenger. In addition to being a person who likes to express himself through emoticons, he hates unbalanced parenthesis so much that it makes him go :(

Sometimes he puts emoticons within parentheses, and you find it hard to tell if a parenthesis really is a parenthesis or part of an emoticon.

A message has balanced parentheses if it consists of one of the following:

- An empty string ""
- One or more of the following characters: 'a' to 'z', ' ' (a space) or ':' (a colon)
- An open parenthesis '(', followed by a message with balanced parentheses, followed by a close parenthesis ')'.
- A message with balanced parentheses followed by another message with balanced parentheses.
- A smiley face ":)" or a frowny face ":("
Write a program that determines if there is a way to interpret his message while leaving the parentheses balanced.

Input
The first line of the input contains a number T (1 ≤ T ≤ 50), the number of test cases.
The following T lines each contain a message of length s that you got from John.

Output
For each of the test cases numbered in order from 1 to T, output "Case #i: " followed by a string stating whether or not it is possible that the message had balanced parentheses. If it is, the string should be "YES", else it should be "NO" (all quotes for clarity only)

Constraints
1 ≤ length of s ≤ 100

 */
public class BalancedSmiley {

    private static final String FILENAME = "C:\\Users\\arpit\\Downloads\\balanced_smileys.txt";

    public static void main(String[] args) {

        try {

            FileReader fr = new FileReader(FILENAME);
            BufferedReader br = new BufferedReader(fr);
            String currLine = "";
            int numTestCases = 0;
            if((currLine = br.readLine())!=null){
                numTestCases = Integer.parseInt(currLine);
            }

            while((currLine = br.readLine())!=null){
                System.out.println(balanceSmiley(currLine));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static boolean balanceSmiley(String str){
/*
        String s = str.replaceAll ( "[^:\\(\\)]", "" );

        for (int i = 0; i  <  s.length() / 2; i++) {
            String lead = "";
            String trail = "";
            if (s.charAt(i) == '(' && s.charAt(s.length() - i - 1) == ')') {
                if (i > 0) {
                    lead = s.substring(0, i);
                    trail = s.substring (s.length() - i, s.length());
                }
                s = lead + s.substring ( i + 1, s.length() - i - 1 ) + trail;
                --i;
            }
        }
        s = s.replaceAll( ":\\(", "" );
        s = s.replaceAll( ":\\)", "" );

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                return false;
            }
        }

        return true;
*/

   /*     int minOpen = 0, maxOpen = 0;
        for (int i = 0; i < str.length(); i++) {
            char crr = str.charAt(i);
            if (crr == '(') {
                maxOpen++;
                if (i == 0 || str.charAt(i - 1) != ':') {
                    minOpen++;
                }
            } else if (crr == ')') {
                minOpen = Math.max(0, minOpen - 1);
                if (i == 0 || str.charAt(i - 1) != ':') {
                    maxOpen--;
                    if (maxOpen < 0) break;
                }
            }
        }
        return maxOpen >= 0 && minOpen == 0;
*/

        if(str==null || str.length()==0) return true;
        Stack<Character> stk = new Stack<>();
        int sad=0, happy=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                if(i!=0 && str.charAt(i-1)==':'){
                    sad++;
                }else{
                    if(stk.isEmpty()) happy = 0;
                    stk.push(str.charAt(i));
                }
            }
            else if(str.charAt(i)==')'){
                if(i!=0 && str.charAt(i-1)==':'){
                    happy++;
                }
                else{
                    if(stk.isEmpty() && sad>0){
                        sad--;
                    }
                    else if(!stk.isEmpty()){
                        stk.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(!stk.isEmpty() && happy==stk.size()){
            return true;
        }
        return stk.isEmpty();
    }

}
