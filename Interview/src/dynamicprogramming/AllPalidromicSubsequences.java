package dynamicprogramming;
import java.util.*;

public class AllPalidromicSubsequences {
	
	public int findAllPalindromeSubsequences(String str){
		int L[][] = new int[str.length()][str.length()];
		for(int i=0; i < str.length(); i++){
            L[i][i] = 1;
        }
		
		for(int l=2;l<=str.length();l++){
			for(int i = 0; i < str.length()-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str.charAt(i) == str.charAt(j)){
                    L[i][j] = 2;
                }else if(str.charAt(i) == str.charAt(j)){
                	L[i][j] = L[i + 1][j-1] + 2;
                }else{
                    L[i][j] = Math.max(L[i + 1][j], L[i][j - 1]);
                }
            }
		}
		int maxval = 0;
		for(int i=1;i<str.length();i++)
			maxval = Math.max(maxval, L[0][i-1]*L[i][str.length()-1]);
		return maxval;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc = "2 3 5";
		StringBuilder sb = new StringBuilder();
		
		
		String[] sample = {"arpit","anshul","mathur","break"};
		Arrays.sort(sample);
		System.out.println(Arrays.toString(sample));
		String[] inputs =  abc.split("\\s+");
		int[] newinput = new int[inputs.length];
		for(int i=0;i<inputs.length;i++){
			newinput[i] = Integer.parseInt(inputs[i]);
		}
		System.out.println(newinput[0] + " second : "+ newinput[1] + "DSC: " + newinput[2]);
		AllPalidromicSubsequences aps = new AllPalidromicSubsequences();
		String str = "axbawbaseksqke";
		int res = aps.findAllPalindromeSubsequences(str);
		System.out.println(res);
		//System.out.println(Arrays.deepToString(res));
	}

}
