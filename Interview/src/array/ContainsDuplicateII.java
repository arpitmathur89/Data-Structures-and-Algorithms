package array;

import java.util.HashMap;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct 
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 * 
 * */


public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = {1,2,5,9,3,5,4}; 
		System.out.println(containsNearbyDuplicate(nums,4));

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

}
