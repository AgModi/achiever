package leetcode.binaryTreeGeneral;

public class CreateFromPreOrderInOrder {

    public static void main(String[] args) {
        int []preorder = {3,9,20,15,7};
        int []inorder = {9,3,15,20,7};
        Node root = getTree(preorder, inorder, 0, 0, inorder.length-1);
        Tree.levelOrderTraversal(root);

        System.out.println();
        preorder = new int[]{-1};
        inorder = new int[]{-1};

        root = getTree(preorder, inorder, 0, 0, inorder.length-1);
        Tree.levelOrderTraversal(root);
    }

    private static Node getTree(int []preorder, int []inorder, int preOrderRootIndex,
                                int inOStartIndex, int inOEndIndex) {
        if (inOStartIndex == inOEndIndex) {
            return new Node(preorder[preOrderRootIndex]);
        }

        if (preOrderRootIndex >= preorder.length) {
            return null;
        }


        int root = preorder[preOrderRootIndex];
        Node rootNode = new Node(root);

        int rootIndexInInorder = inOStartIndex;
        for (int i = inOStartIndex; i <= inOEndIndex; i++) {
            if (root == inorder[i]) {
                rootIndexInInorder = i;
                break;
            }
        }

        rootNode.left = getTree(preorder, inorder, preOrderRootIndex+1, inOStartIndex, rootIndexInInorder -1 );
        rootNode.right = getTree(preorder, inorder, preOrderRootIndex+1+(rootIndexInInorder-inOStartIndex), rootIndexInInorder+1, inOEndIndex);
        return rootNode;
    }
}
