package array;

import java.util.*;
/*
 * 
 * Both Pascal's Triangle I and II
 * 
 * 
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));
		System.out.println(getRow(4));
	}

	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> sublst = new ArrayList<Integer>();
            if(i==1){
                sublst.add(1);
                res.add(sublst);
            }else{
                List<Integer> lastlst = res.get(i-2);
                sublst.add(1);
                for(int j=1;j<lastlst.size();j++){
                    sublst.add(lastlst.get(j-1) + lastlst.get(j));
                }
                sublst.add(1);
                res.add(sublst);
            }
            
        }
        return res;
    }
	
	// Pascal's Triangle II
	 public static List<Integer> getRow(int rowIndex) {
	        List<Integer> res = new ArrayList<>();
	        for(int i=0;i<=rowIndex;i++){
	            res.add(1);
	            for(int j=i-1;j>0;j--){
	                res.set(j,res.get(j-1) + res.get(j));
	            }
	        }
	        return res;
	    }
}
