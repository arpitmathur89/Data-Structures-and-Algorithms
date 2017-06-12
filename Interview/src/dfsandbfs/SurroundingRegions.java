package dfsandbfs;
/*
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all 
 * regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.

	For example,
	X X X X
	X O O X
	X X O X
	X O X X
	
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X
 * 
 * 
 * 
 */
public class SurroundingRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'X','O','X','X','O'},
				 {'X','X','X','O','X'},
				 {'X','O','X','O','X'},
				 {'X','O','X','X','X'}};
			
			print(grid);
			solve(grid);
			System.out.println();
			print(grid);
	}
	
	public static void solve(char[][] board) {
        
        if(board.length == 0  || board == null)
            return;
        
        int m = board.length;
        int n = board[0].length;
        
        // first check for the borders of board for O's because they can never be surrounded, and any O's touching
        // this O can also never be surounded. So mark it as some other character, say '#'. DFS will be used to mark those points as #
        
        for(int i=0; i<m;i++){
            if(board[i][0] == 'O'){    // 1st Column
                dfs(board,i,0);
            }
            
            if(board[i][n-1] == 'O'){
                dfs(board,i,n-1);        // Last Column
            }
        }
        
        for(int i=0; i<n;i++){
            if(board[0][i] == 'O'){    // First Row
                dfs(board,0,i);
            }
            
            if(board[m-1][i] == 'O'){   // Last Row
                dfs(board,m-1,i);
            }
        }
        
 
        
        // Now, check for remaining O's, if present mark it as 'X', and if there is a '#' mark it back to O's bcoz it was not surrounded
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    public static void dfs(char[][] board, int i, int j){
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
		    return;
		
        if(board[i][j] != 'O')
            return;
            
        board[i][j] = '#';
        
        if(i>1 && board[i-1][j] == 'O')
            dfs(board,i-1,j);
        if(j>1 && board[i][j-1] == 'O')
            dfs(board,i,j-1);
        if(i < board.length-2 && board[i+1][j] == 'O')    
            dfs(board,i+1,j);
        if(j < board[i].length-2 && board[i][j+1] == 'O')
            dfs(board,i,j+1);
            
    }
    
    public static void print(char[][] matrix){		
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
