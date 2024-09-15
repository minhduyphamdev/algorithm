package java;
import java.util.*;

public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    traverseSegment(res, root, 0);
    return res;
  }

  public void traverseSegment(List<Integer> res, TreeNode root, int height) {
    if(root == null) {
      return;
    }

    if(height == res.size()) {
      res.add(root.val);
    }

    traverseSegment(res, root.right, height+1);
    traverseSegment(res, root.left, height+1);
  }


  public static void main(String[] args) {
    BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
    // TreeNode root = new TreeNode(1);
    // root.right = new TreeNode(2);
    // root.right.left = new TreeNode(3);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);
    List<Integer> res = btrsv.rightSideView(root);
    for (Integer i : res) {
      System.out.println(i);
    }
  }
}
