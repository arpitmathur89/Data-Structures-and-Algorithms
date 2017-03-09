package recursion;

import java.util.ArrayList;

/*
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],y
  []
]
 * 
 * */
public class Powersets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		
		System.out.println(getSubset(set,0));
		
	}
	
	// Recursive Solution - Time Complexity O(n.2^n)
	public static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(index == set.size()){
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		}else{
		allSubsets = getSubset(set, index+1);
		int item =  set.get(index);
		ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subset : allSubsets){
			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.add(item);
            newSubset.addAll(subset);
            moreSubsets.add(newSubset);
        }
        allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
	}
}
