package array;

/**
 * Created by arpit on 6/24/2017.
 */
/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.


 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {11,2,31,24,1,2,5};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {

        int firstmin = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;

        for(int n: nums){
            if(n <= firstmin){
                firstmin = n;
            }
            else if(n <= secondmin){
                secondmin = n;
            }else{
                return true;
            }
        }
        return false;
    }



}
