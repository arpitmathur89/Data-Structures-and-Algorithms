package design.lfucache;

import java.util.HashMap;
import java.util.*;

public class LFUCache {
	 Node head = null;
	    int capacity = 0;
	    HashMap<Integer,Integer> keyvalmap;
	    HashMap<Integer,Node> nodehash;
	    
	    public LFUCache(int capacity) {
	        this.capacity = capacity;
	        keyvalmap = new HashMap<Integer,Integer>();
	        nodehash = new HashMap<Integer, Node>();
	    }
	    
	    public int get(int key) {
	        if(keyvalmap.containsKey(key)){
	            //increase the count/freq of key
	            increasecount(key);
	            return keyvalmap.get(key);
	        }
	            return -1;
	    }
	    
	    public void increasecount(int key){
	        Node node = nodehash.get(key); // Get the node from nodehash hashmap, where the key node pair is stored
	        node.keyset.remove(key); // Remove the key from the current freq linkedhashset
	        
	        if(node.next == null){
	            node.next = new Node(node.count + 1);
	            node.next.prev = node;
	            node.next.keyset.add(key);
	        }else if(node.next.count == node.count + 1){
	            node.next.keyset.add(key);
	        } else {
	            Node temp = new Node(node.count + 1);
	            temp.keyset.add(key);
	            temp.prev = node;
	            temp.next = node.next;
	            node.next.prev = temp;
	            node.next = temp;
	        }
	        nodehash.put(key,node.next);  // Add the pair in Node hash
	        
	        if(node.keyset.size() == 0){  // Check if the current nodes keyset is now empty, we can delete that node
	            remove(node);
	        }
	    }
	    
	    public void remove(Node node){
	        if(node.prev == null){
	            head = node.next;
	        }
	        else{
	            node.prev.next = node.next;
	        }
	        if(node.next != null){
	            node.next.prev = node.prev;
	        }
	    }
	    
	    
	    public void put(int key, int value) {
	        if(capacity == 0){
	            return;
	        }
	        // Check if it's already present
	         if(keyvalmap.containsKey(key)){
	             keyvalmap.put(key,value);
	         }
	         else{
	             if(keyvalmap.size() < capacity){
	                 keyvalmap.put(key,value);
	             }
	             else{
	                 deleteOld();
	                 keyvalmap.put(key,value);
	             }
	             addToHead(key);
	         }
	        //increase the count/freq of key
	             increasecount(key);
	    }
	    
	    public void addToHead(int key){
	        if(head == null){
	            head = new Node(0);
	            head.keyset.add(key);
	        }
	        else if(head.count > 0){
	            Node node = new Node(0);
	            node.keyset.add(key);
	            node.next = head;
	            head.prev = node;
	            head =  node;
	        }else{
	            head.keyset.add(key);
	        }
	        
	        nodehash.put(key,head);
	    }
	    
	    public void deleteOld(){
	        if(head == null)
	            return;
	        int old = 0;
	        for(int n : head.keyset){
	            old = n;
	            break;
	        }
	        
	        head.keyset.remove(old);
	        
	        if (head.keyset.size() == 0)
	            remove(head);
	            
	        nodehash.remove(old);
	        keyvalmap.remove(old);
	        
	        
	    }
	    
	    // The node will have the count(frequency) and a hashset which contains the keys that have this count/frequency
	    public class Node{
	        public int count;
	        public LinkedHashSet<Integer> keyset;
	        public Node prev;
	        public Node next;
	        
	        public Node(int count){
	            this.count = count;
	            keyset = new LinkedHashSet<Integer>();
	            prev = null;
	            next = null;
	        }
	    
	    }  
}
