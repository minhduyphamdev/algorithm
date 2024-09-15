package java;
public class BinaryTreeMaximumPathSum {
  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumHelper(root);
    return maxSum;
  }
 // max chi tinh tai 1 vi tri
 // left, right dung de trace duong di
  private int maxPathSumHelper(TreeNode root) {
    if(root == null) {
      return 0;
    }

    int left = Math.max(0, maxPathSumHelper(root.left));
    int right = Math.max(0, maxPathSumHelper(root.right));
    maxSum = Math.max(maxSum, left + right + root.val);
    return Math.max(left, right) + root.val;
  }

  public static void main(String[] args) {
    BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
    // TreeNode root = new TreeNode(1);
    // root.left = new TreeNode(-2);
    // root.left.left = new TreeNode(3);
    TreeNode root = new TreeNode(-10);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(btmps.maxPathSum(root));
  }
}
