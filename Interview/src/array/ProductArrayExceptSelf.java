package array;

import java.util.Arrays;

public class ProductArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,5,6,10};
		System.out.println(Arrays.toString((productExceptSelf(nums))));
	}
	
	public static int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int[] output = new int[n];
		int l =1;
		int r =1;
		for(int i=0;i<n;i++){
			output[i] = l;
			l *= nums[i];
		}
		
		for(int j = n-1;j>=0;j--){
			output[j] *= r;
			r *= nums[j];
		}
		
		return output;
	}

}
