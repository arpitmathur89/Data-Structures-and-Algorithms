package array;
import java.util.*;

public class FindDisappeared {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> res = findDisappearedNumbers(nums);
		System.out.println(res);
	}
	
	
	public static List<Integer> findDisappearedNumbers(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
			for(int i=0;i<nums.length ;i++){
/*Yahan pe while loop hai bcoz jab tak nums[i] pe correct number i.e i+1 nahi aayega wo aage nahi jayega
 and loop chalta rahega. Also, nums[i] != nums[nums[i]-1] bcoz agar pahle se us position pe hai to
 no need to swap. Bcoz nums[i] waala element correct position pe hai i.e nums[nums[i]-1].*/
            while(nums[i] != i+1 && nums[i] != nums[nums[i] - 1]){
                int temp = nums[i];
                int temp2 = nums[i]-1;
                nums[i] = nums[temp2];
                nums[temp2] = temp;
            }
        }
		
		 for(int i=0;i<nums.length;i++){
	            if(nums[i] != i+1){
	                res.add(i+1);
	            }
	        }
		return res;
	}
}
