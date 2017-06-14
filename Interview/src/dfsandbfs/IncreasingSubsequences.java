package dfsandbfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer array, your task is to find all the different possible increasing 
 * subsequences of the given array, and the length of an increasing subsequence
 * should be at least 2 .
 * 
	Example:
	Input: [4, 6, 7, 7]
	Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
	Note:
	The length of the given array will not exceed 15.
	The range of integer in the given array is [-100,100].
	The given array may contain duplicates, and two equal integers should also be 
	considered as a special case of increasing sequence.
 * 
 * 
 */
public class IncreasingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,6,7,7};
	 System.out.println(findSubsequences(nums));
	}
	
	public static List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(res, temp, 0, nums);
		return res;
	}
	
	public static void dfs(List<List<Integer>> res, List<Integer> temp, int index, int[] nums){
		if(temp.size() >= 2){
			res.add(new ArrayList<>(temp));
		}
		
		for(int i=index;i<nums.length;i++){
			if(temp.size() == 0 || (temp.get(temp.size()-1) <= nums[i])){
				temp.add(nums[i]);
				dfs(res,temp,i+1,nums);
				temp.remove(temp.size()-1);
			}
		}
	}
}
