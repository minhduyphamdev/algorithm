package java;
import java.util.*;

public class SymmetricTree {
  // public boolean isSymmetric(TreeNode root) {
  //   if(root == null) {
  //     return true;
  //   }

  //   return traverseTree(root.left, root.right);
  // }

  // public boolean traverseTree(TreeNode p, TreeNode q) {
  //   if(p== null && q == null) {
  //     return true;
  //   }

  //   if(p==null || q == null) {
  //     return false;
  //   }

  //   return p.val == q.val && traverseTree(p.left, q.right) && traverseTree(p.right, q.left);
  // }

 public boolean isSymmetric(TreeNode root) {
  if(root == null) {
    return true;
  }
  Stack<TreeNode> stack = new Stack<>();
  if(root.left== null && root.right == null) {
    return true;
  }

  if(root.left == null || root.right ==null || root.left.val != root.right.val) {
    return false;
  }

  stack.push(root.right);
  stack.push(root.left);

  while(!stack.isEmpty()) {
    TreeNode p  = stack.pop();
    TreeNode q = stack.pop();

    if(p.val != q.val) {
      return false;
    }

    if(p.left!=null) {
      if(q.right == null) return false;
      stack.push(q.right);
      stack.push(p.left);
    }
    else if(q.right!=null) {
      return false;
    }

    if(p.right!=null) {
      if(q.left == null) return false;
      stack.push(q.left);
      stack.push(p.right);
    }
    else if(q.left != null) {
      return false;
    }
  }

  return true;
 }

 public static void main(String[] args) {
    SymmetricTree st = new SymmetricTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    System.out.println(st.isSymmetric(root));
 }
}
