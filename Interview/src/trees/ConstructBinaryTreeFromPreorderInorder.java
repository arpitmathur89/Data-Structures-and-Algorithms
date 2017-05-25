package trees;

public class ConstructBinaryTreeFromPreorderInorder {


	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,3,6};
		int[] preorder = {1,2,4,5,3,6};
		Node n = construct(preorder,inorder);
		// Check Using Inorder
		Inorder(n);
	}
	
	private static void Inorder(Node n) {
	
		if(n == null)
			return;
		Inorder(n.left);
		System.out.print(n.getData());
		Inorder(n.right);
	}

	public static Node construct(int[] preorder,int[] inorder){
		return constructTree(0,0,inorder.length-1,preorder,inorder);
	}
	
	public static Node constructTree(int pstart, int instart,int inend,int[] preorder, int[] inorder){
		if(pstart > preorder.length-1 || instart>inend)
			return null;
		
		Node root = new Node(preorder[pstart]);
		int rindex = 0;
		for(int i=0;i<inorder.length;i++){
			if(preorder[pstart] == inorder[i]){
				rindex = i;
				break;
			}
		}
		
		root.left = constructTree(pstart+1,instart,rindex-1,preorder,inorder);
		root.right = constructTree(pstart + (rindex - instart) +1,rindex+1,inend,preorder,inorder);
		return root;
	}
}
