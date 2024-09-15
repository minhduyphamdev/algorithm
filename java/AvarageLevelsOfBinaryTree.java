package java;
import java.util.*;

public class AvarageLevelsOfBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while(!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for(int i=0;i<size;i++) {
        TreeNode node = queue.poll();
        if(node.left!=null) queue.add(node.left);
        if(node.right!=null) queue.add(node.right);
        sum += node.val;
      }

      res.add((double) (sum/size));
    }

    return res;
  }

  public static void main(String[] args) {
    AvarageLevelsOfBinaryTree obj = new AvarageLevelsOfBinaryTree();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(obj.averageOfLevels(root));
  }
}
