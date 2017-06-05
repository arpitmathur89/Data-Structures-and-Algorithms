package string;
/*
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
 * 
 * 
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		//String s2 = "race A car";
		System.out.println(isPalindrome(s));
	}
	
	
	public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char front;
        char last;
        while(i<j){
            front = s.charAt(i);
            last = s.charAt(j);
            if(!Character.isLetterOrDigit(front)){
                i++;
            }else if(!Character.isLetterOrDigit(last)){
                j--;
            }else{
                if(Character.toLowerCase(front)!=Character.toLowerCase(last)){
                    return false;
                }
                i++;
                j--;
            }
        }
        
        return true;
    }

}
