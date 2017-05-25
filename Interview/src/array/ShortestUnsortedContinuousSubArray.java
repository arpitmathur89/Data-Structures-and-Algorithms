package array;
/*
 * Given an integer array, you need to find one continuous subarray that if you only sort 
 * this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array 
 * sorted in ascending order.
 * 
 * 
 */
public class ShortestUnsortedContinuousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,4,6,5,8,10,12,9,15,21};
		System.out.println(findUnsortedSubarray(nums));
	}
	
	public static int findUnsortedSubarray(int[] nums) {
        int len=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int start=-1, end=-1;
        
        // Check for the start and end in a for loop. If there is a change in order than start and end will be updated with the current
        // position, else let the loop continue without any changes.
        for(int i=0; i<len; i++){
            max = Math.max(max, nums[i]); //from left to right, search the current max
            min = Math.min(min, nums[len-i-1]);  //from right to left, search the current min 
            
            if(nums[i] < max)  
                end = i;
            if(nums[len-i-1] > min)
                start = len-i-1;
        }
        
        if(start==-1) //the entire array is already sorted
            return 0;
        
        return end-start+1;
    }

}
