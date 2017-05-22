package array;
/*
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 
 */

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,4,3,3,4,3,3,3,3,3,2};
		System.out.println(majorElement(nums));
	}
	
	 public static int majorElement(int[] nums) {
	        
	      /*  
	       * O(nlogn) Solution -  Not good enough
	       * Arrays.sort(nums);
	       * return nums[nums.length/2];
	       * 
	       * 
	       * */
		 
		 int count = 0;
		 int major = 0;
		 for(int n : nums){
			 if(count == 0){
				 major = n;
				 count++;
			 }
			 else if(major == n){
				 count++;
			 }else{
				 count--;
			 }
		 }
		return major; 
	 }

}
