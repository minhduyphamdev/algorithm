package java;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, inIndex - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + inIndex - inStart + 1, inorder, inIndex + 1, inEnd, inorderMap);

        return root;
    }

    private static void printTree(TreeNode root) {
      if (root == null) {
          return;
      }

      // Inorder traversal to print the tree
      printTree(root.left);
      System.out.print(root.val + " ");
      printTree(root.right);
  }

  public static void main(String[] args) {
    ConstructBTreeFromPreorderandInorderTraversal obj = new ConstructBTreeFromPreorderandInorderTraversal();
    TreeNode root = obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    printTree(root);
  }
}
