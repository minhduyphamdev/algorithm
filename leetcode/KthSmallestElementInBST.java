import java.util.*;

public class KthSmallestElementInBST {
  // public static int count = 0 ;
  // public static int result = 0;
  // public int kthSmallest(TreeNode root, int k) {
  //   count = k;
  //   findK(root);

  //   return result;
  // }

  // public void findK(TreeNode root) {

  //   if(root.left!=null) findK(root.left);
  //   count--;
  //   if(count==0) {
  //     result = root.val;
  //     return;
  //   }
  //   if(root.right!=null) findK(root.right);
  // }
  

  // k = count + 1;
  // public int kthSmallest(TreeNode root, int k) {
  //     int count = countNodes(root.left);
  //   if (k <= count) {
  //       return kthSmallest(root.left, k);
  //   } else if (k > count + 1) {
  //       return kthSmallest(root.right, k - count - 1); // count is num of nodes in node.left and +1 ( root node)
  //   }
    
  //   return root.val;
  // }

  // public int countNodes(TreeNode n) {
  //     if (n == null) return 0;
      
  //     return 1 + countNodes(n.left) + countNodes(n.right);
  // }


  // C3
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();

    while(root!=null) {
      stack.push(root);
      root = root.left;
    }

    while(!stack.isEmpty()) {
      TreeNode node = stack.pop();
      k--;
      if(k==0) {
        return node.val;
      }

      TreeNode right = node.right;
      while(right!=null) {
        stack.push(right);
        right = right.left;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    // TreeNode root = new TreeNode(3);
    // root.left = new TreeNode(1);
    // root.right = new TreeNode(4);
    // root.left.right = new TreeNode(2);
    TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);

    // TreeNode root = new TreeNode(5);
    // root.left = new TreeNode(3);
    // root.right = new TreeNode(6);
    // root.left.left = new TreeNode(2);
    // root.left.right = new TreeNode(4);
    // root.left.left.left = new TreeNode(1);
    KthSmallestElementInBST k = new KthSmallestElementInBST();
    System.out.println(k.kthSmallest(root, 2));
  }
}
