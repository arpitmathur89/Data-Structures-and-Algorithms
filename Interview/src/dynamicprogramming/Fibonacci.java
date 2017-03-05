package dynamicprogramming;
import java.io.InputStream;
import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int num =sc.nextInt();
		System.out.println(fib(num));
	
	}
	
	
	
	
	// Recursive Approach -  Time complexity O(2^n)
	
	public static int fib(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fib(n-1)  + fib(n-2);
	}
}
