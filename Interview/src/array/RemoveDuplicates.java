package array;
/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length. 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 
respectively. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,4,5,89,89};
		System.out.println(removeDups(nums));
	}
	
	
	public static int removeDups(int[] nums){
		if(nums.length == 0)
			return 0;
		int j = 0;
		nums[j++] = nums[0];
		for(int i=1;i<nums.length;i++){
			if(nums[i] != nums[i-1])
				nums[j++] = nums[i];
		}
		
		return j;
	}
}
