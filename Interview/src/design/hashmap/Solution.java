package design.hashmap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap<Character,Integer> hmap = new MyHashMap<Character,Integer>(10);
		hmap.put('a', 1);
		hmap.put('b', 2);
		hmap.put('c', 3);
		hmap.put('d', 4);
		hmap.put('e', 5);
		hmap.put('f', 6);
		hmap.put('g', 7);
		hmap.put('h', 8);
		hmap.put('i', 9);
		hmap.put('j', 10);
		hmap.put('k', 11);
		hmap.put('l', 12);
		System.out.println(" Current Map structure");
		hmap.displayMap();
		System.out.println(" Value of key 'c'");
		System.out.println(hmap.get('c'));
		hmap.remove('c');
		System.out.println(" Map after removing 'c");
		hmap.displayMap();
	}

}
