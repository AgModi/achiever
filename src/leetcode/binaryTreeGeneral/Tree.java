package leetcode.binaryTreeGeneral;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree {

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    public static Node createTree1() {
        Node left = new Node(2);
        Node right = new Node(2);
        Node root = new Node(1, left, right);

        left.left = new Node(3);
        left.right = new Node(4);

        right.left = new Node(4);
        right.right = new Node(3);

        return root;
    }
}
