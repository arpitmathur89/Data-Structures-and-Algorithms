package array;
/*
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find 
 * the one that is missing from the array. 
 * For example, 
 * Given nums = [0, 1, 3] return 2.
 * 
 * 
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		System.out.println(missingNumber(nums));
	}
	
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = (n * (n+1))/2;
		int givsum = 0;
		for(int num : nums){
			givsum += num;
		}	
		return sum-givsum;
	}
	
	//Alter
	/*
	 public static int missingNumber(int[] nums) {
	        int ret = 0;
	        for(int i=0;i<nums.length;i++){
	            ret = ret ^ i;
	            ret = ret ^ nums[i];
	        }
	        return ret^nums.length;
	    }
	*/
}
