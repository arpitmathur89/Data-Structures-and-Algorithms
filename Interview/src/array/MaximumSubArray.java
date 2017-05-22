package array;
/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		
	}
	
	// O(n) Solution
	public static int maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int max = nums[0];
		
		for(int i=1;i<nums.length;i++){
			maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
			max = Math.max(max, maxSoFar);
		}
		return max;
	}
}
