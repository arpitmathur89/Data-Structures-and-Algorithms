package design.lrucache;
import java.util.*;

public class LRUCache {
	int capacity;
	int currcap;
	Dll head;
	Dll tail;
	HashMap<Integer, Dll> hmap;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		currcap = 0;
		head = new Dll(0,0);
		tail = new Dll(0,0);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
		hmap = new HashMap<Integer,Dll>();
		
	}
	public int get(int key){
		if(hmap.containsKey(key)){
			Dll node = hmap.get(key);
			DeleteNode(node);
			AddtoHead(node);
			return node.val;
		}else{
			return -1;
		}
	}
	
	public void put(int key, int val){
		if(hmap.containsKey(key)){
			Dll node = hmap.get(key);
			node.val = val;
			DeleteNode(node);
			AddtoHead(node);
			hmap.put(key, node);
		}else{
			Dll node = new Dll(key,val);
			if(currcap>=capacity){
				Dll temp = tail.prev;
				tail.prev = temp.prev;
				temp.prev.next = tail;
				hmap.remove(temp.key);								
			}else{
				currcap++;
			}
			hmap.put(key, node);
			AddtoHead(node);
		}	
	}
	
	public void AddtoHead(Dll node){
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
		
	}
	
	public void DeleteNode(Dll node){
		node.next.prev = node.prev;
		node.prev.next = node.next;
	}
	
}

