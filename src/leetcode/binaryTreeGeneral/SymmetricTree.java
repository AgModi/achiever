package leetcode.binaryTreeGeneral;

public class SymmetricTree {
    public static void main(String[] args) {
        Node left = new Node(2);
        Node right = new Node(2);
        Node root = new Node(1, left, right);

        left.left = new Node(3);
        left.right = new Node(4);

        right.left = new Node(4);
        right.right = new Node(3);

        System.out.println(isTreeSymmetric(root));

        left.left.right = new Node(5);
        right.right.left = new Node(5);
        System.out.println(isTreeSymmetric(root));

        right.right = new Node(6);

        System.out.println(isTreeSymmetric(root));

    }

    public static boolean isTreeSymmetric(Node root) {
        return isTreeSymmetric(root.left, root.right);
    }

    public static boolean isTreeSymmetric(Node rootLeft, Node rootRight) {
        if (rootLeft == null && rootRight == null) {
            return true;
        }
        if (rootLeft != null && rootRight == null) {
            return false;
        }
        if (rootLeft == null && rootRight != null) {
            return false;
        }

        if (rootLeft.val == rootRight.val) {
            boolean isSymmetric =  isTreeSymmetric(rootLeft.left, rootRight.right);
            if (isSymmetric) {
                return isTreeSymmetric(rootLeft.right, rootRight.left);
            }
        }
        return false;
    }
}
