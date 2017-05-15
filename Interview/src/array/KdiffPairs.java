package array;
import java.util.*;
/*
 * Given an array of integers and an integer k, you need to find the number of unique 
 * k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 * 
 * Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
 */

public class KdiffPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 5, 4,1};
		int k = 0;
		System.out.println(findPairs(nums,k));
	}
	
	
	public static int findPairs(int[] nums, int k){
		if (nums == null || nums.length == 0 || k < 0)   return 0;
        int count = 0;
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }else{
                hmap.put(nums[i],1);
            }
        }
        
       for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
           if(k==0){
               if(entry.getValue() >=2)
                count++;
           }else{
               if (hmap.containsKey(entry.getKey() + k)) {
                    count++;
                }
           }
       }
        
        return count;
		
	}
}
