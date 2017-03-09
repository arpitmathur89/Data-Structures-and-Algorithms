package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsWithDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(2);
		
		
		System.out.println(getSubset(set));
	}
	
	 public static List<List<Integer>> getSubset(List<Integer> nums) {
	        List<List<Integer>> allSubsets = new ArrayList<>();
	        Collections.sort(nums);
	        backtrack(allSubsets,nums,new ArrayList<>(),0);
	        return allSubsets;
	    }
	    
	    public static void backtrack(List<List<Integer>> allSubsets, List<Integer> nums, List<Integer> templist, int start){
	        allSubsets.add(new ArrayList<>(templist));
	        for(int i=start;i<nums.size();i++){
	            if(i>start && nums.get(i)==nums.get(i-1))
	                continue;
	            templist.add(nums.get(i));
	            backtrack(allSubsets,nums,templist,i+1);
	            templist.remove(templist.size()-1);
	        }
	    }

}
