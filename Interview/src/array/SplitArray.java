package array;
/*
 * Given an array of numbers (assume the array has three or more values, 
 * and they are indeed numbers), return an index, if one exists, where 
 * the sums of the elements on either side of that index are equal. 
 * eg. [2, 3, 4, 4, 1] given the function this array 
 * should return index 2 (element with value 4) because the sums on 
 * either side are equal (2 + 3 = 4 + 1).
 * 
 */
public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {23,4,1,4,2,3,7,6};
		System.out.println(findSplitIndex(arr));
		
	}
	
	public static int findSplitIndex(int[] arr){
		int left =0;
		int right = arr.length-1;
		int leftsum = 0;
		int rightsum = 0;
		while(left<right){		
			if(leftsum <= rightsum){
				leftsum += arr[left];
				left++;
			}else{
				rightsum +=arr[right];
				right--;
			}
		}
		if(leftsum == rightsum)
			return left;
		
		return -1;
		
	}

}
