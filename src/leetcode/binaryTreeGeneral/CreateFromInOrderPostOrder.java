package leetcode.binaryTreeGeneral;

public class CreateFromInOrderPostOrder {

    public static void main(String[] args) {
        int []inorder = {9,3,15,20,7};
        int []postorder = {9,15,7,20,3};
        Node root = getTree(inorder, postorder, 0, postorder.length-1, 0, inorder.length-1);
        Tree.levelOrderTraversal(root);

        System.out.println();
        inorder = new int[]{-1};
        postorder = new int[]{-1};

        root = getTree(inorder, postorder, 0, postorder.length -1, 0, inorder.length-1);
        Tree.levelOrderTraversal(root);
    }

    private static Node getTree(int []inorder, int []postorder, int postOStartIndex, int postOEndIndex,
                                int inOStartIndex, int inOEndIndex) {
        if (inOStartIndex == inOEndIndex) {
            return new Node(inorder[inOEndIndex]);
        }

        if (postOStartIndex >= postorder.length) {
            return null;
        }


        int root = postorder[postOEndIndex];
        Node rootNode = new Node(root);

        int rootIndexInInorder = inOStartIndex;
        for (int i = inOStartIndex; i <= inOEndIndex; i++) {
            if (root == inorder[i]) {
                rootIndexInInorder = i;
                break;
            }
        }

        rootNode.left = getTree(inorder, postorder, postOStartIndex, postOStartIndex+(rootIndexInInorder-inOStartIndex)-1,inOStartIndex, rootIndexInInorder -1 );
        rootNode.right = getTree(inorder, postorder, postOStartIndex+(inOEndIndex-rootIndexInInorder), postOEndIndex-1,rootIndexInInorder+1, inOEndIndex);
        return rootNode;
    }
}
