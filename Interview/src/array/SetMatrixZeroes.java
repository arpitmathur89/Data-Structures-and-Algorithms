package array;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,7},{7,0,9}};
		print(matrix);
		setZeroes(matrix);
		print(matrix);
	}
	
	 public static void setZeroes(int[][] matrix) {
		 if(matrix == null || matrix.length==0)
			 return;
		 boolean frow =  false;
		 boolean fcol =  false;
		 for(int i=0;i<matrix.length;i++){
			 for(int j=0;j<matrix[0].length;j++){
				 if(matrix[i][j] == 0){
					 if(i==0){
						 frow = true;
					 }
					 if(j==0){
						 fcol = true;
					 }
					 if(i!=0 && j!=0){
						 matrix[0][j] = 0;
						 matrix[i][0] = 0;
					 }
				 }
			 }
		 }
		 
		 for(int i=1;i<matrix.length;i++){
			 for(int j=1;j<matrix.length;j++){
				 if(matrix[i][0] == 0 || matrix[0][j] == 0){
					 matrix[i][j] = 0;
				 }
			 }
		 }
		 
		 if(frow){
			 for(int i=0;i<matrix[0].length;i++){
				 matrix[0][i] = 0;
			 }
		 }
		 
		 if(fcol){
			 for(int i=0;i<matrix.length;i++){
				 matrix[i][0] = 0;
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
