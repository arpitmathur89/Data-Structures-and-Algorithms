package array;

import java.util.ArrayList;
import java.util.List;

/*
 *Given a collection of distinct numbers, return all possible permutations.
 *For example,
 *[1,2,3] have the following permutations:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	] 
 * 
 * 
 */
public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = permute(nums);
		System.out.println(res.toString());

	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res,new ArrayList<>(),nums);
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums){
		if(nums.length == tempList.size()){
			res.add(new ArrayList<>(tempList));
		}
		else{
			for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) 
		        	 continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(res, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		}
		
	}
}
