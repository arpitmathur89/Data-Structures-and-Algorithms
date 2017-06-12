package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(15);
		root.left = new Node(8);
		root.right =new Node(37);
		root.left.left = new Node(5);
		root.left.right = new Node(9);
		root.right.right = new Node(39);
		root.right.right.left = new Node(38);
		
		System.out.println(rightSideView(root));

	}
	
	public static List<Integer> rightSideView(Node root) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(root);
		
		while(!q.isEmpty()){
			
			int size = q.size();
				
			for(int i=0;i<size;i++){
				Node n = q.poll();
				if(n.left!=null){
					q.offer(n.left);
				}
				
				if(n.right!=null){
					q.offer(n.right);
				}
				
				if(i == size-1){
					res.add(n.val);
				}
			}
			
		}
		
		
		return res;
	}

}
