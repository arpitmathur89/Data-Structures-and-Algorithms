package array;
/*
 * Find the contiguous subarray within an array (containing at least one number) which 
 * has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * 
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,3,-2,4,-20}
		System.out.println(maxProduct(nums));

	}
	
	public static int maxProduct(int[] nums) {
		if(nums.length<=0)
			return 0;
		int maxsofar = nums[0];
		int max = nums[0];
		for(int i=1;i<nums.length;i++){
				maxsofar = Math.max(maxsofar, maxsofar*nums[i]);
				max = Math.max(max, maxsofar);
			}
		return max;
	}


}
