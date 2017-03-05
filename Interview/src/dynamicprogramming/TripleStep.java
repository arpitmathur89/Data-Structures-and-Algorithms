package dynamicprogramming;

public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countways(4));
	}
	
	public static int countways(int n){
		if(n<=0)
			return 0;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<=n;i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[n];
	}
}
