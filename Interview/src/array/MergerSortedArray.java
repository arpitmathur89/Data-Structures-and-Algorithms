package array;

import java.util.Arrays;

/*
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. All elements in nums1
 * 
 */
public class MergerSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[30];
		for(int i=0;i<6;i++)
			nums1[i] = i*12 + 1;
		int[] nums2 = {2,4,26,36,49,101,157};
		merge(nums1,6,nums2,7);
		System.out.println(Arrays.toString(nums1));

	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	      
        // Start Adding to array from last(greater element) so that the nums1 values will not be lost while adding.
        int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0)
		{
			if(nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
		while(j>=0)
			nums1[k--] = nums2[j--];
      
    }
}
