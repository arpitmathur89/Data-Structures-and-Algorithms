package dynamicprogramming;
import java.util.*;

/*
 *  Find Path with obstacles(Recursive and  DP)
 *  FindAll Path with obstacles (DP)
 * 
 */
public class RobotInGridFindPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,1,0,1},
		                  {1,1,1,1},
		                  {1,0,1,1},
		                  {1,1,0,1}};
		System.out.println("Recursive Solution :");
		ArrayList<Point> res = findpathrec(matrix);
		for( Point p : res ){
			System.out.println(p.toString());
		}
		
		System.out.println("DP Solutionn : ");
		ArrayList<Point> res1 = findPathDP(matrix);
		for( Point p : res1 ){
			System.out.println(p.toString());
		}
		
		System.out.println("All paths :");
		ArrayList<ArrayList<Point>> res2 = findAllPathDP(matrix);
		for( ArrayList<Point> pts : res2 ){
			for(Point p : pts)
				System.out.println(p.toString());
			System.out.println("------");
		}
		
	}
	
	// Recursive method with Time Complexity O(2^(r+c))
	public static ArrayList<Point> findpathrec(int[][] matrix){
		ArrayList<Point> result = new ArrayList<>();
		if(matrix.length == 0 || matrix == null )
			return result;
		
		findPathRecursive(matrix,matrix.length-1,matrix[0].length-1,result);
		return result;
	}
	
	public static boolean findPathRecursive(int[][]matrix , int row, int col, ArrayList<Point> result){
		if(row < 0 || col < 0)
			return false;
		if(matrix[row][col] == 0)
			return false;
		Point p = new Point(row,col);
		if(row == 0 && col == 0){
			result.add(p);
			return true;
		}
		
		if(findPathRecursive(matrix, row-1,col,result) || findPathRecursive(matrix, row,col-1,result)){
			result.add(p);
			return true;
		}
		return false;
	}
	
	
	// Dynamic Programming With Memoization using Cache i.e HashMap
	
	public static ArrayList<Point> findPathDP(int[][] matrix){
		ArrayList<Point> result = new ArrayList<>();
		HashMap<Point,Boolean> cache = new HashMap<Point,Boolean>();
		if(matrix.length==0 || matrix == null )
			return result;
		findPathDynamic(matrix,matrix.length-1,matrix[0].length-1,cache,result);
		return result;
	}
	
	public static boolean findPathDynamic(int[][]matrix, int row, int col, HashMap<Point,Boolean> cache,ArrayList<Point> result){
		if(col < 0 || row < 0)
			return false;
		if(matrix[row][col]==0)
			return false;
		Point p = new Point(row,col);
		
		if(cache.containsKey(p))
			return cache.get(p);
		
		boolean isAtOrigin = (row==0 && col==0) ? true:false;
		boolean success = false;
		
		if(isAtOrigin || findPathRecursive(matrix, row-1,col,result) || findPathRecursive(matrix, row,col-1,result)){
			result.add(p);
			success = true;
		}
		
		cache.put(p,success);
		return success;
	}
	
	
	// Find All Paths
	
	public static ArrayList<ArrayList<Point>> findAllPathDP(int [][] matrix){
		ArrayList<ArrayList<Point>> result = new ArrayList<>();
		if(matrix.length == 0 || matrix == null)
			return result;
		findAllPathDP(matrix, matrix.length-1,matrix[0].length-1,new ArrayList<Point>(), result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static void findAllPathDP(int[][] matrix, int row,int col,ArrayList<Point> path,ArrayList<ArrayList<Point>> result){
		if(row<0 || col <0)
			return;
		if(matrix[row][col] == 0)
			return;
		Point p = new Point(row,col);
		path.add(0,p);
		if(row == 0 && col==0){
			result.add((ArrayList<Point>) path.clone());
		}
		
		findAllPathDP(matrix,row-1,col,path,result);
		findAllPathDP(matrix,row,col-1,path,result);
		path.remove(p);
	}
	
	
	
	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		 public String toString() {
	            return "(" + x + ", " + y + ")";
	        }
	}
}
