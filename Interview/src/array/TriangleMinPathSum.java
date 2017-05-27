package array;

import java.util.LinkedList;
import java.util.List;

/*
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may 
 * move to adjacent numbers on the row below.
 * For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * 
 * 
 */
public class TriangleMinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new LinkedList<>();
		List<Integer> lst1 = new LinkedList<>();
		lst1.add(2);
		triangle.add(lst1);
		List<Integer> lst2 = new LinkedList<>();
		lst2.add(3);
		lst2.add(4);
		triangle.add(lst2);
		List<Integer> lst3 = new LinkedList<>();
		lst3.add(6);
		lst3.add(5);
		lst3.add(7);
		triangle.add(lst3);
		List<Integer> lst4 = new LinkedList<>();
		lst4.add(4);
		lst4.add(1);
		lst4.add(8);
		lst4.add(3);
		triangle.add(lst4);
		System.out.println(minimumTotal(triangle));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		
		int[] res = new int[triangle.size()+1];
		
		for(int i=triangle.size()-1; i>=0;i--){
			for(int j=0;j<i+1;j++){
				res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
			}
		}		
		return res[0];		
	}
}
