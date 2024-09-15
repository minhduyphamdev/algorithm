package java;
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return null;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  public static void main(String[] args) {
    InvertBinaryTree ibt = new InvertBinaryTree();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    TreeNode result = ibt.invertTree(root);
    System.out.println(result.val);
  }
}
