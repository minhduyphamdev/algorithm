import java.util.*;

public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if(root == null) return res;
    buildPaths(res, "", root);

    return res;
  }

  public void buildPaths(List<String> res, String temp, TreeNode node) {
    if(node.left == null && node.right ==null) {
      res.add(temp + node.val);
      return;
    }

    if(node.left != null) buildPaths(res, temp + node.val + "->", node.left);
    if(node.right!=null) buildPaths(res, temp + node.val + "->", node.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    BinaryTreePaths btp = new BinaryTreePaths();
    System.out.println(btp.binaryTreePaths(root));
  }
}
