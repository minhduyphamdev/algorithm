import java.util.*;

public class UniqueBinarySearchTreesII {
  // g is how many unique BSTs can be formed with n nodes
  // f(i, n) is how many unique BSTs can be formed with i nodes as root
  
  public List<TreeNode> generateTrees(int n) {
    return generateSubtrees(1, n);
  }
  
  private List<TreeNode> generateSubtrees(int s, int e) {
    List<TreeNode> res = new LinkedList<TreeNode>();
    if (s > e) {
      res.add(null); // empty tree
      return res;
    }
  
    for (int i = s; i <= e; ++i) {
      List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
      List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
  
      for (TreeNode left : leftSubtrees) {
        for (TreeNode right : rightSubtrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();
    List<TreeNode> res = obj.generateTrees(3);
    for (TreeNode root : res) {
      System.out.println(root);
    }
  }
}
