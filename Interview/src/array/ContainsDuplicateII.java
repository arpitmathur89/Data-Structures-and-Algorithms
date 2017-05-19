package array;

import java.util.*;

/* Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct 
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 * 
 * */


public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = {1,2,5,9,3,5,4}; 
		System.out.println(containsNearbyDuplicate(nums,4));
		System.out.println(containsDuplicate(nums));

	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k){
		
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(hmap.containsKey(nums[i])){
				if((i - hmap.get(nums[i])) <= k)
					return true;
			}else{
				hmap.put(nums[i], i);
			}
		}	
		return false;
	}
	
	// Contains Duplicate I
	/*
	 *Given an array of integers, find if the array contains any duplicates. Your function should 
	 *return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
	 *  
	 */
	
	public static boolean containsDuplicate(int[] nums) {
		
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			if(hset.contains(nums[i]))
				return true;
			hset.add(nums[i]);
		}
		return false;
	}
}
