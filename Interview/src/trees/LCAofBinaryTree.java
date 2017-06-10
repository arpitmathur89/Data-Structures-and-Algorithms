package trees;

public class LCAofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(15);
		root.left = new Node(8);
		root.right =new Node(37);
		root.left.left = new Node(5);
		root.left.right = new Node(9);
		root.right.right = new Node(39);
		root.right.right.left = new Node(38);
		Node p = root.left.left;
		Node q = root.left.right;
		Node lca = lowestCommonAncestor(root,p,q);
		System.out.println(lca.val);
	}
	
	
	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(root == null || root == p || root == q)
			return root;
		Node left = lowestCommonAncestor(root.left,p,q);
		Node right = lowestCommonAncestor(root.right,p,q);
		if(left == null){
			return right;
		}
		else if(right == null){
			return left;
		}else{
			return root;
		}
		
	}
}
