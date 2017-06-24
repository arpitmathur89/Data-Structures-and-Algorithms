package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by arpit on 6/24/2017.
 */
public class InorderTraversalIterative {

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(8);
        root.right =new Node(37);
        root.left.left = new Node(5);
        root.left.right = new Node(9);
        root.right.right = new Node(39);
        root.right.right.left = new Node(38);

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(Node root) {

        if(root == null)
            return null;

        Stack<Node> st = new Stack<Node>();
        List<Integer> res = new ArrayList<Integer>();
        Node node = root;

        while(node!=null || !st.isEmpty()){
            while(node!=null){
                st.push(node);
                node = node.left;
            }
           node = st.pop();
           res.add(node.val);
           node = node.right;
        }

        return res;
    }


}
