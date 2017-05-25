package trees;

public class Node {
	int val;
	Node left,right;
	
	public Node(int val) {
		this.val = val;
	}
	
	public Node(){
		left = null;
		right = null;
	}
	
	public int getData() {
		return val;
	}
	public void setData(int val) {
		this.val = val;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
}
