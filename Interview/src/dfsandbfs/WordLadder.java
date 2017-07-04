package dfsandbfs;

import java.util.*;

/**
 * Created by arpit on 7/3/2017.
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord,endWord,wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList){

        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len =1;

        while(!q.isEmpty()){

            int size =  q.size();

            for(int i=0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord))
                    return len;
                for(int j=0;j<word.length();j++){
                    char[] carr = word.toCharArray();
                    int ch  = carr[j] - 'a';

                    for(char k='a'; k<='z'; k++) {
                        if (ch == k)
                            continue;
                        carr[j] = k;
                        String newstr = new String(carr);
                        if (dict.contains(newstr) && visited.add(newstr)) {
                            q.offer(newstr);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }

}
