package dynamicprogramming;
import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = new ArrayList<String>();
		
		dict.add("leet");
		dict.add("cope");
		dict.add("co");
		dict.add("e");
		dict.add("d");
		System.out.println(wordBreak("leetcode", dict));
	}
	
	public static boolean wordBreak(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
	  for(int i=1; i <= s.length(); i++){
          for(int j=0; j < i; j++){
              if(f[j] && dict.contains(s.substring(j, i))){
                  f[i] = true;
                  break;
              }
          }
      }
      
      return f[s.length()];
  }
}
