package trees;

public class ConstructBinaryTreeFromInorderPostorder {

	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,3,6};
		int[] postorder = {4,5,2,6,3,1};
		Node n = construct(postorder,inorder);
		// Check Using Inorder
		Inorder(n);
	}
	
	private static void Inorder(Node n) {
		// TODO Auto-generated method stub
		if(n == null)
			return;
		Inorder(n.left);
		System.out.print(n.getData());
		Inorder(n.right);
	}

	public static Node construct(int[] postorder,int[] inorder){
		return constructTree(postorder.length-1,0,inorder.length-1,postorder,inorder);
	}
	
	public static Node constructTree(int pend, int instart,int inend,int[] postorder, int[] inorder){
		if(pend < 0 || instart>inend)
			return null;
		
		Node root = new Node(postorder[pend]);
		int rindex = 0;
		for(int i=0;i<inorder.length;i++){
			if(postorder[pend] == inorder[i]){
				rindex = i;
				break;
			}
		}
		
		root.left = constructTree(pend-(inend-rindex) -1,instart,rindex-1,postorder,inorder);
		root.right = constructTree(pend-1,rindex+1,inend,postorder,inorder);
		return root;
	}
}
