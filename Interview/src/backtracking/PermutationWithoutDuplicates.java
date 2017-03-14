package backtracking;
import java.util.*;

public class PermutationWithoutDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = getPermute("abc");
		System.out.println(res);
	}
	
	public static List<String> getPermute(String str){
		List<String> result = new ArrayList<>();
		permute(result,str,0,str.length()-1);
		return result;
		
	}
	
	public static void permute(List<String> result, String str, int start, int end){
		if(start == end){
			result.add(str);
		}else{
			for(int i=start;i<=end;i++){
				str = swap(str,start,i);
				permute(result,str,start+1,end);
				str =swap(str,start,i);
			}
		}
	}
	
	public static String swap(String str, int i, int j){
		char[] a = str.toCharArray();
		char temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
		
		return String.valueOf(a);
	}
	
}
