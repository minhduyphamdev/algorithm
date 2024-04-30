import java.util.*;
import org.apache.commons.lang3.tuple.Pair;
// No changes needed for the import statement.

public class SumOfLeftLeaves {

  // dfs
  // public int sumOfLeftLeaves(TreeNode root) {
  //   return dfs(root,false);
  // }

  // public int dfs(TreeNode node, boolean isLeft) {
  //   if(node == null) {
  //     return 0;
  //   }

  //   if(isLeft && node.left == null && node.right == null) {
  //     return node.val;
  //   }

  //   return dfs(node.left,true) + dfs(node.right, false);
  // }

  // bfs
  public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) {
      return 0;
    }

    Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
  }
 
  public static void main(String[] args) {
    SumOfLeftLeaves obj = new SumOfLeftLeaves();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(obj.sumOfLeftLeaves(root)); // 24
  }
}
