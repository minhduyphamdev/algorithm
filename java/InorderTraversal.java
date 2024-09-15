package java;
import java.util.*;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      traverseSegment(res,root);
      
      return res;
    }

    public void traverseSegment(List<Integer> res, TreeNode root) {
      if(root== null) {
        return;
      }

      traverseSegment(res, root.left);
      res.add(root.val);
      traverseSegment(res, root.right);
    }

    public static void main(String[] args) {
      InorderTraversal it = new InorderTraversal();
      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(3);
      List<Integer> res = it.inorderTraversal(root);
      for (Integer i : res) {
        System.out.println(i);
      }
    }
}

