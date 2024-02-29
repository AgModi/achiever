package leetcode.binaryTreeGeneral;

public class LCA {

    public static void main(String[] args) {
        Node root = createTree1();
        System.out.println(findLCA(root, 5,1));//3
        System.out.println(findLCA(root, 6,2));//5
        System.out.println(findLCA(root, 6,0));//3
        System.out.println(findLCA(root, 7,4));//2
        System.out.println(findLCA(root, 5,4));//5
    }

    public static int findLCA(Node root, int p, int q) {
        if (root == null) {
            return -1;
        }

        if (root.val == p || root.val == q) {
            return root.val;
        }

        boolean isPInLeft = findNode(root.left, p);
        boolean isQInLeft = findNode(root.left, q);

        if (isPInLeft && isQInLeft) {
            return findLCA(root.left, p, q);
        }

        boolean isPInRight = findNode(root.right, p);
        boolean isQInRight = findNode(root.right, q);

        if (isPInRight && isQInRight) {
            return findLCA(root.right, p, q);
        }else {
            return root.val;
        }
    }

    private static boolean findNode(Node root, int num) {
        if (root == null) {
            return false;
        }

        if (root.val == num) {
            return true;
        }

        return findNode(root.left, num) || findNode(root.right, num);
    }

    public static Node createTree1() {
        Node left = new Node(5);
        Node right = new Node(1);
        Node root = new Node(3, left, right);

        left.left = new Node(6);
        left.right = new Node(2);

        left.right.left = new Node(7);
        left.right.right = new Node(4);

        right.left = new Node(0);
        right.right = new Node(8);

        return root;
    }
}
