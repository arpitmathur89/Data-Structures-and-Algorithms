package array;
/*
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * 
 */
import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,0,1,5,0,7};
		moveZero(nums);
		System.out.println(Arrays.toString(nums));
		
	}
	
	public static void moveZero(int[] nums) {
		
		int j=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				nums[j++] = nums[i];
			}
		}
		
		while(j<nums.length){
			nums[j++] = 0;
		}
		
	}

}
