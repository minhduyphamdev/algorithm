package java;
public class MaxDepth {
  // public int maxDepth(TreeNode root) {
  //   return findMax(root);
  // }

  // public int findMax(TreeNode node) {
  //   if(node == null ){
  //     return 0;
  //   }

  //   return Math.max(1+findMax(node.left), 1+ findMax(node.right));
  // }

  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public static void main(String[] args) {
    MaxDepth md = new MaxDepth();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(md.maxDepth(root));
  }
}
