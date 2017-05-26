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
		int[] nums = {-2,-3,-2,4,20};
		System.out.println(maxProduct(nums));

	}
	
	public static int maxProduct(int[] nums) {
	    if(nums.length == 0)
            return 0;
        int posprod = nums[0];
        int negprod = nums[0];
        int maxprod = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int a = posprod * nums[i];
            int b = negprod * nums[i];
            
            posprod = Math.max(Math.max(a,b),nums[i]);
            negprod = Math.min(Math.min(a,b),nums[i]);
            maxprod = Math.max(maxprod,posprod);
        }
        return maxprod;
	}


}
