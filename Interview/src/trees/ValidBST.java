package trees;

public class ValidBST {

	public static void main(String[] args) {
		Node root = new Node(15);
		root.left = new Node(8);
		root.right =new Node(37);
		root.left.left = new Node(5);
		root.left.right = new Node(9);
		root.right.right = new Node(39);
		root.right.right.left = new Node(38);
		
		System.out.println(isValidBST(root));
	}
	
	public static boolean isValidBST(Node root){
		if(root == null)
			return true;
		long maxv = Long.MAX_VALUE;
		long minv = Long.MIN_VALUE;
		return checkValidity(root,minv,maxv);
	}
	
	public static boolean checkValidity(Node node, long minv, long maxv){
		if(node == null)
			return true;
		if(node.val > minv && node.val < maxv){
			return checkValidity(node.left,minv,node.val) && checkValidity(node.right,node.val,maxv);
		}else{
			return false;
		}
	}

}
