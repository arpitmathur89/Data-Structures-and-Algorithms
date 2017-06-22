package design.trie;

import java.util.PriorityQueue;

/**
 * Created by arpit on 6/18/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("arpit");
        obj.insert("anshul");
        obj.insert("akanksha");
        obj.insert("anjali");
        System.out.println(obj.startsWith("ans"));
        System.out.println(obj.search("akanksha"));
        System.out.println(obj.search("anj"));

    }
}
