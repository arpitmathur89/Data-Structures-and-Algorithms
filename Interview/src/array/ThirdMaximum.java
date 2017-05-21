package array;
import java.util.*;

/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 */
public class ThirdMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3,3,3,3,1};
		System.out.println(thirdMax(nums));
		System.out.println(maxThird(nums));
		if(thirdMax(nums) == maxThird(nums)){
			System.out.println("Dance");
		}
	}
	
	
	// Using Simple Array concepts
	public static int thirdMax(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		
		for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if(max1 == null || n > max1){
				max3 = max2;
				max2 = max1;
				max1 = n;
			}else if(max2 == null || n > max2){
				max3 = max2;
				max2 = n;
			}else if(max3==null || n > max3){
				max3 = n;
				
			}
		}
		
		
		return max3 == null ? max1 : max3;
		
	}
	
	// Using PriorityQueue -  Create a min priority queue (Heap). If the priority queue size exceeds 3 then remove the element from 
	//top. Since we only need the third max element. 
	
	public static int maxThird(int[] nums){
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int n: nums){
			if(!set.contains(n)){
				pq.add(n);
				set.add(n);
			}
			if(pq.size()>3){
				pq.poll();
			}
		}
		if(pq.size() == 2)
			pq.poll();
		
		return pq.peek();
	}
}
