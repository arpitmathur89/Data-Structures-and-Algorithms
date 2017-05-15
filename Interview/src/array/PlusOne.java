package array;
import java.util.*;
/* Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] digits = {9,9,9,0};
		int[] res = (GetPlusOne(digits));
		System.out.println(Arrays.toString(res));

	}
	
	public static int[] GetPlusOne(int[] digits) {
		
		// Start the loop from end and At any point if the index value is less than 9 , 
		//then no need to check for remaining digits. Add 1 and return
		int n = digits.length;
		for(int i=n-1;i>=0;i--){		
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			
			digits[i] = 0;
		}
		
		// If All the digits are 9's then just create a new array and initialize the first
		// element as 1, rest all indexes will be 0 by default
		int[] newnum = new int[n+1];
		newnum[0] = 1;
		return newnum;
	}

}
