package dynamicprogramming;
import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int num =sc.nextInt();
		System.out.println(fib(num));
		sc.close();
		System.out.println(fibonacci(num));
		System.out.println(fibo(num));
		System.out.println(fibonacci_nospace(num));
	}
	
	
	
	
	// Recursive Approach -  Time complexity O(2^n)
	
	public static int fib(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fib(n-1)  + fib(n-2);
	}
	
	// Memoization aka Top Down DP - Time Complexity O(n)
	
	public static long fibonacci(int n){
		return fibonacci(n,new long[n+1]);
	}
	
	public static long fibonacci(int n, long[]memo){
		if(n == 1 || n==0 )
			return n;
		if(memo[n] == 0){
			memo[n] = fibonacci(n-1,memo) + fibonacci(n-2,memo);
		}
		return memo[n];
	}
	
	// Bottom-Up DP
	
	public static int fibo(int n){
		if(n==0 || n==1)
			return 0;
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		for(int i=2;i<=n;i++){
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	//Bottom Up without using extra array space
	public static int fibonacci_nospace(int n){
		if(n==0 || n==1)
			return 0;
		
		int a = 0;
		int b = 1;
		for(int i=2;i<=n;i++){
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
}
