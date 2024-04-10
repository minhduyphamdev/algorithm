public class RootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
      return sumToLeaf(root, 0);
  }

  public int sumToLeaf(TreeNode node, int currSum) {
      if (node == null) {
          return 0;
      }
      
      if(node.left == null && node.right == null) return currSum*10 + node.val;

      return sumToLeaf(node.left, currSum) + sumToLeaf(node.right, currSum);
  }

  public static void main(String[] args) {
    RootToLeafNumbers obj = new RootToLeafNumbers();
    // TreeNode root = new TreeNode(1);
    // root.left = new TreeNode(2);
    // root.right = new TreeNode(3);
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);
    System.out.println(Integer.toString(obj.sumNumbers(root)));
  }
}
