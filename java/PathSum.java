package java;
public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root == null) {
      return false;
    }
    if(root.left == null && root.right  == null) {
      if(targetSum == root.val) {
        return true;
      }
      return false;
    }

    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
  }

  public static void main(String[] args) {
    PathSum obj = new PathSum();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);
    System.out.println(obj.hasPathSum(root, 21));
  }
}
