package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:

	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * 
 * 
 * 
 */
public class SubsetsII {

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println(res.toString());

	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(res,new ArrayList<>(),nums,0);		
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int start){
		
		res.add(new ArrayList<>(templist));
		for(int i=start;i<nums.length;i++){
			if(i>start && nums[i]==nums[i-1])
				continue;
			templist.add(nums[i]);
			backtrack(res,templist,nums,i+1);
			templist.remove(templist.size()-1);
		}		
	}
	
	

}
