package java;
// problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }

    if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    else if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }

  public static void main(String[] args) {
    LowestCommonAncestor lca = new LowestCommonAncestor();
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    TreeNode p = new TreeNode(2);
    TreeNode q = new TreeNode(4);
    TreeNode result = lca.lowestCommonAncester(root, p, q);
    System.out.println(result.val);
  }
}
