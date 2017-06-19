package design.trie;

/**
 * Created by arpit on 6/18/2017.
 */
public class TrieNode {

    TrieNode[]  arr;
    boolean isLeaf;

    public TrieNode(){
        this.arr = new TrieNode[26];
    }
}
