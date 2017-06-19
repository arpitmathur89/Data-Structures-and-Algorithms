package design.trie;

/**
 * Created by arpit on 6/18/2017.
 */
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.arr[index] == null){
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }else{
                p = p.arr[index];
            }
        }
        p.isLeaf = true;    // It is a word if isLeaf is set true
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if(p == null)
            return false;
        else{
            if(p.isLeaf)
                return true;
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p =  searchNode(prefix);
        if(p == null)
            return false;
        return true;

    }

    // Function to search the node in Trie
    private TrieNode searchNode(String str){

        TrieNode p  = root;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int index  = c - 'a';
            if(p.arr[index]!= null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
        if(p == root)
            return null;
        return p;
    }

}
