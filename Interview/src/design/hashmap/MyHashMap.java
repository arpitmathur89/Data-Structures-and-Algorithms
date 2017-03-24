package design.hashmap;
import java.util.*;


public class MyHashMap<K,V> {
	
	//Doubly linked list type structure to store the values
	private static class LinkedListNode<K,V>{
		K key;
		V value;
		LinkedListNode<K,V> next;
		LinkedListNode<K,V> prev;
		
		public LinkedListNode(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	// Table of Array of linked list node to store key, values
	private ArrayList<LinkedListNode<K,V>> table;
	
	//Constructor for myHashMap
	public MyHashMap(int capacity){
		table = new ArrayList<LinkedListNode<K,V>>();		
		for(int i = 0;i<capacity;i++){
			table.add(null);
		}
	}
	
	public void put(K key, V value){
		LinkedListNode<K,V> node = getnode(key);
		//If node is not null than it already exist, We just need to update the value
		if(node!=null){
			node.value = value;
			return;
		}
		
		node = new LinkedListNode<>(key,value);
		int keyindex = getIndex(key);
		
		if(table.get(keyindex)!=null){
			node.next = table.get(keyindex);
			node.next.prev = node;
		}
		
		table.set(keyindex, node);
	}
	
	public V get(K key){
		LinkedListNode<K,V> node = getnode(key);
		return node==null ? null : node.value;
	}
	
	public void remove(K key){
		LinkedListNode<K,V> node = getnode(key);
		// Can remove only if node exist
		if(node!=null){
			// If the node is not the head node
			if(node.prev!=null){
				node.prev.next = node.next;
			}else{
				// If returned node is head node
				int hashkey = getIndex(key);
				table.set(hashkey, node.next);  // Reset the table with hashkey and node.next
			}
			
			// Setting the prev node of next pointer, if node was not last node
	        if(node.next != null) {
	            node.next.prev = node.prev;
	        }
		}		
	}
	
	//  Return the node from the table for the given key value
	private LinkedListNode<K,V> getnode(K key){
		int keyindex = getIndex(key);
		LinkedListNode<K,V> node = table.get(keyindex);
		while(node!=null){
			if(node.key == key){
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	// Method to generate hashcode and prevent collisions
	private int getIndex(K key){
		return Math.abs(key.hashCode() % table.size());
	}
	
	public void displayMap(){
		
		for(int i=0;i<table.size();i++){
			LinkedListNode<K,V> node = table.get(i);
			boolean ispresent = false;
			if(node!=null){
				ispresent = true;
				System.out.print("{ ");
			}
			while(node!=null){
				System.out.print("[" + node.key + ":" + node.value +"] ");
				node = node.next;
			}
			if(ispresent)
				System.out.print("}");
				System.out.println();
		}
		System.out.println();
	}
}
