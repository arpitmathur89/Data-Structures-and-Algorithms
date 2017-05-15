package array;

import java.util.*;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a 
 * specific target.
 * You may assume that each input would have exactly one solution, and you may not use the 
 * same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * 
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {1,2,5,9,3,15,4};
		int[] res= findTwoSum(nums,11);
		System.out.println(res[0] + ", " + res[1]);

	}
	
	public static int[] findTwoSum(int[] nums, int target){
		int[] res = new int[2];
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++){
			if(hmap.containsKey(target-nums[i])){
				res[0] = hmap.get(target-nums[i]);
				res[1] = i;
			}else{
				hmap.put(nums[i], i);
			}
		}			
		return res;
	}
	
}
