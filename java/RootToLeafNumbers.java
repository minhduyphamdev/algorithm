package java;
public class RootToLeafNumbers {
   int totalSum = 0;
  public int sumNumbers(TreeNode root) {
    
    sumToLeaf(root, "");
    return totalSum;
  }

  public void sumToLeaf(TreeNode node, String currSum) {
    if(node.left == null && node.right == null) {
      totalSum += Integer.parseInt(currSum+ node.val);
      return;
    }
    if(node.left != null) {
      sumToLeaf(node.left, currSum + node.val);
    }
    if(node.right != null) {
      sumToLeaf(node.right, currSum + node.val);
    }
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
    System.out.println(obj.sumNumbers(root));
  }
}
