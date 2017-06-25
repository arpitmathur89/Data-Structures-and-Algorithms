package dynamicprogramming;

/**
 * Created by arpit on 6/25/2017.
 */

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than
one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?


 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9, 2, 5, 3, 7, 101, 189};
        System.out.println(lengthOfLIS(nums));
    }

    // DP solution with O(n^2) time complexity
    public static int lengthOfLIS(int[] nums) {

        if(nums.length==0 || nums == null)
            return -1;
        // Create a new array to store th lengths at each point
        int[] dp = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i] = 1;  // Initialize it by 1 because at that particular point it is the longest sequence of length 1.

            for(int j=0;j<i;j++){   // for loop only till j<i and increment only if nums[j] < nums[i]
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);    // update only if and dp value is not greater already
                }
            }
        }
        // Now find the maximum in the array
        int max = Integer.MIN_VALUE;
        for(int n : dp){
            max = Math.max(n,max);
        }
        return max;
    }
}
