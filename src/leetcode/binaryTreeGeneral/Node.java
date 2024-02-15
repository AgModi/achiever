package leetcode.binaryTreeGeneral;

public class Node {
    int val;

    Node left;

    Node right;

    Node() {}

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
