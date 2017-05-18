package array;
/*
 * Given a list of words and two words word1 and word2, return the shortest distance between
 *  these two words in the list. 
 *  For example, 
 *  Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *  
 *  Given word1 = “coding”, word2 = “practice”, return 3.
 *  Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(shortestDistance(words,word1,word2));
	}
	
	public static int shortestDistance(String[] words, String word1, String word2) {
		int res=Integer.MAX_VALUE;
		int j=-1;
		int k=-1;
		for(int i=0;i<words.length;i++){
			String str = words[i];
			if(word1.equals(str)){
				j = i;
				if(k!=-1){
					res = Math.min(res, j-k);
				}
			}else if(word2.equals(str)){
				k = i;
				if(j!=-1){
					res = Math.min(res, k-j);
				}
			}
		}
		
		return res;
		
	}

}
