package array;

public class BinaryPalindrome {

	public static void main(String[] args) {
	
		System.out.println(convert(Integer.MAX_VALUE));
	}
	
	
	public static int convert(int n){
		
	//	String s = Integer.toString(n,2);
		
		int binary[] = new int[32];
	     int index = 0;
	     while(n > 0){
	       binary[index++] = n%2;
	       n = n/2;
	     }
	     
	     
	     
	     
	     /*
	     int[] nums = new int[index]; 
	     for(int i = index-1;i >= 0;i--){
	         nums[index-i-1] = binary[i];
	       }
	    System.out.println(Arrays.toString(nums));
		*/
		int l = 0;
	    int m = index - 1;
	    int result = 1;
	    while (m > l) {
	        if (binary[l] != binary[m]) {
	            result = 0;
	        }
	        ++l;
	        --m;
	    }
	    return result;
	}
}
