package leetcode.binaryTreeGeneral;

public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        Node root = new Node(2);
        Node left = new Node(1);
        Node right = new Node(3);

        root.left = left;
        root.right = right;

        System.out.println(getMaxSumOnPath(root));


        //Test 2
        root = new Node(-10);

        left = new Node(90);
        right = new Node(20);

        root.left = left;
        root.right= right;

        right.left = new Node(15);
        right.right = new Node(7);


        System.out.println(getMaxSumOnPath(root));

    }

    private static int getMaxSumOnPath(Node root) {
        if (root.left == null && root.right == null){
            return root.val;
        }

        if (root == null) {
            return 0;
        }

        int leftChildSum = getMaxSumOnPath(root.left);
        int rightChildSum = getMaxSumOnPath(root.right);


        if (root.val < 0) {
            return leftChildSum > rightChildSum? leftChildSum : rightChildSum;
        } else {
            int maxSumTillNow =  leftChildSum > rightChildSum? leftChildSum : rightChildSum ;

            if (root.left != null && root.left.val < 0) {
                if (root.right != null && root.right.val < 0) {
                    return leftChildSum > rightChildSum? leftChildSum : rightChildSum;
                } else {
                    return rightChildSum+ root.val;
                }
            }

            if (root.right != null && root.right.val < 0) {
                if (root.left != null && root.left.val < 0) {
                    return leftChildSum > rightChildSum? leftChildSum : rightChildSum;
                } else {
                    return leftChildSum+ root.val;
                }
            }
        }

        return leftChildSum + rightChildSum + root.val;
    }
}