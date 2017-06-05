package design.lrucache;

public class Dll {
	int key;
	int val;
	Dll next;
	Dll prev;
	
	Dll(int key, int val){
		this.key = key;
		this.val = val;
	}
	
}
