package java;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(queue.size() != 0) {
      int size = queue.size();
      List<Integer> row = new ArrayList<>();
      for(int i=0;i<size;i++) {
        TreeNode ele = queue.poll();
        row.add(ele.val);
        if(ele.left != null) {
          queue.add(ele.left);
        }

        if(ele.right != null) {
          queue.add(ele.right);
        }
      }
      result.add(row);
    }

    return result;
  }

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> result = btlot.levelOrder(root);
    for(List<Integer> level : result) {
      for(Integer val : level) {
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }
}
