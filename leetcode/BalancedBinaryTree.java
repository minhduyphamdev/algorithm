public class BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    // If the tree is empty, we can say it’s balanced...
    if(root == null) return true;
    
    if(height(root) == -1) return false;
    return true;
  }

  public int height(TreeNode root) {
    if(root == null) return 0;
    int left = height(root.left);
    int right = height(root.right);

    if(left == -1 || right == -1 || Math.abs(left-right) >1 ) return -1;

    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {  
    // Create a new instance of the class...
    BalancedBinaryTree bbt = new BalancedBinaryTree();
    // Create a new instance of the TreeNode class...
    TreeNode root = new TreeNode(1);
    // Set the left node of the root...
    root.left = new TreeNode(2);
    // Set the right node of the root...
    root.right = new TreeNode(2);
    // Set the left node of the left node of the root...
    root.left.left = new TreeNode(3);
    // Set the right node of the left node of the root...
    root.left.right = new TreeNode(3);
    // Set the left node of the right node of the root...
    root.left.left.left = new TreeNode(4);
    // Set the right node of the right node of the root...
    root.left.left.right = new TreeNode(4);
    // Print the result...
    System.out.println(bbt.isBalanced(root));
  }
}
