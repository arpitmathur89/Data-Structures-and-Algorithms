package array;
/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 * 
 * 
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,0,1,1,0,0};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxones = 0;
		int curones = 0;
		
		for(int i=1;i<nums.length;i++){
			if(nums[i] == 1){
				curones+=1;
				maxones = Math.max(maxones, curones);
			}else{
				curones = 0;
			}
		}
		
		return maxones;
		
		
		
	}

}
