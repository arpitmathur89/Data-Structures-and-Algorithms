package array;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		print(matrix);
		rotate(matrix);
		print(matrix);
		
	}
	
	public static void rotate(int[][] matrix) {
		
		if(matrix.length == 0 || matrix == null)
			return;
		
		// Transpose the Matrix
		
		for(int i=0;i<matrix.length;i++){
			for(int j=i+1;j<matrix[0].length;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;			
			}
		}
		
		//Now swap values columnwise horizontally
		int n = matrix[0].length;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<n/2;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
		
		
	}
	
	public static void print(int[][] matrix){		
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
