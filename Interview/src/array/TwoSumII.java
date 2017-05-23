package array;

/*
 * Given an array of integers that is already sorted in ascending order, find two numbers 
 * such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to 
 * the target, where index1 must be less than index2. Please note that your returned answers 
 * (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may not use the 
 * same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * 
 * 
 */
public class TwoSumII {

	public static void main(String[] args) {
	
		int[] nums = {2,5,7,11,15,27};
		int[] res = twoSum(nums,13);
		System.out.println(res[0] + ", " + res[1]);
	}
	
	 public static int[] twoSum(int[] nums, int target) {
		 int[] res = new int[2];
		 int i=0;
		 int j=nums.length -1;
		 while(i<j){
			 if(nums[i] + nums[j] == target ){
				 res[0] = i+1;
				 res[1] = j+1;				 
				 return res;
			 }else if(nums[i] + nums[j] > target){
				 j--;
			 }else{
				 i++;
			 }				 
		 }
		 return res;
	 }

}
