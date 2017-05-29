package array;
import java.util.*;
/*
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * 
 * 
 */
public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res.toString());
	}
	
	// Using Bit Manipulation
	/*
	public static List<List<Integer>> subsets(int[] nums) {
		
		int totalsets = 1<<nums.length;
		List<List<Integer>> res = new ArrayList<>(totalsets);
		
		for(int i=0;i<totalsets;i++){
			List<Integer> subsets = new ArrayList<Integer>();
			for(int j=0;j<nums.length;j++){
				if((i & (1<<j)) != 0){
					subsets.add(nums[j]);
				}
			}
			res.add(subsets);
		}		
		return res;
	}
	*/
	//Using Backtracking
	public static List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res,new ArrayList<>(),nums,0);
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int start){
		
		res.add(new ArrayList<>(templist));
		for(int i=start;i<nums.length;i++){
			templist.add(nums[i]);
			backtrack(res,templist,nums,i+1);
			templist.remove(templist.size()-1);
		}		
	}

}
