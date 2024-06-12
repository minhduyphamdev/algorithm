public class MinimumAbsoluteDifferentInBST {
    public static int min = Integer.MAX_VALUE;
    public static Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;

        getMinimumDifference(root.left);

        if(prev!=null) {
          min = Math.min(min, root.val - prev);
        }

        prev = root.val;
        getMinimumDifference(root.right);

        return min;
    }

  public static void main(String[] args) {
    MinimumAbsoluteDifferentInBST mab = new MinimumAbsoluteDifferentInBST();
    TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(5);
    root.right.left = new TreeNode(3);
      System.out.println(mab.getMinimumDifference(root));
  }
}
