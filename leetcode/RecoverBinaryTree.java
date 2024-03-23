import java.util.*;

public class RecoverBinaryTree {

  public void recoverTree(TreeNode root) {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    TreeNode cur = root;
    Stack<TreeNode> stack = new Stack<>();
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (prev != null && prev.val > cur.val) {
        if (first == null) {
          first = prev;
          second = cur;
        } else {
          second = cur;
        }
      }
      prev = cur;
      cur = cur.right;
    }
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    new RecoverBinaryTree().recoverTree(root);
  }
}