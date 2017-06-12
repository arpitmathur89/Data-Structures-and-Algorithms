package dfsandbfs;
/*
 * Given a 2d grid map of '1's (land) and '0's (water), 
 * count the number of islands. An island is surrounded by water and is 
 * formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

	Example 1:
	
	11110
	11010
	11000
	00000
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	Answer: 3
 * 
 * 
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','1','1','0'},
						 {'1','1','0','1','0'},
						 {'1','1','0','0','0'},
						 {'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}
	
	 public static int numIslands(char[][] grid) {
	        int count = 0;
	        if(grid.length == 0 || grid == null)
	            return 0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(grid[i][j] == '1'){
	                    dfs(grid,i,j);
	                    count++;
	                }
	            }
	        }
	        
	        return count;
	    }
	    
	    public static void dfs(char[][] grid, int i, int j){
	        if(i<0 || j>=grid[0].length || i>=grid.length || j<0 || grid[i][j]!='1')
	            return;
	        grid[i][j] = '0';    
	        dfs(grid,i-1,j);
	        dfs(grid,i+1,j);
	        dfs(grid,i,j-1);
	        dfs(grid,i,j+1);
	    }
}
