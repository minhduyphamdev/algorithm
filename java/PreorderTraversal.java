package java;
import java.util.*;

public class PreorderTraversal {
  List<Integer> res = new ArrayList<>();
  public List<Integer> preorderTraversal(TreeNode root) {
    traverseTree(root);
    return res;
  }

  public void traverseTree(TreeNode root) {
    res.add(root.val);
    traverseTree(root.left);
    traverseTree(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
  }
}
