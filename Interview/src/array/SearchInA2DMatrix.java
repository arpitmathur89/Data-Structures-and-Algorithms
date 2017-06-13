package array;

public class SearchInA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
						 };
		
		System.out.println(searchMatrixBSearch(matrix,16));
		System.out.println(searchMatrix(matrix,12));
	}
	
	// O(log n) Binary Search Solution
	    public static boolean searchMatrixBSearch(int[][] matrix, int target) {
	        if(matrix == null || matrix.length == 0)
	            return false;
	        int row = matrix.length;
	        int col = matrix[0].length;
	        
	        int low = 0;
	        int high = row * col -1;
	        
	        while(low <= high){
	            
	            int mid  = (low + high)/2;
	            
	            int midvalue = matrix[mid/col][mid%col];
	            
	            if(midvalue == target){
	                return true;
	            }
	            else if(midvalue < target){
	                low = mid + 1;
	            }
	            else{
	                high = mid - 1;
	            }
	    }
	    return false;
	} 


	// O(n) Solution 

	public static boolean searchMatrix(int[][] matrix, int target) {
	    if(matrix == null || matrix.length == 0)
	            return false;
	    int i = 0;
	    int j = matrix[0].length-1;
	    
	    while(i<matrix.length && j>=0){
	        if(matrix[i][j] == target){
	            return true;
	        }
	        else if(matrix[i][j] < target){
	            i++;
	        }else{
	            j--;
	        }
	    }
	    return false;
	}

}
