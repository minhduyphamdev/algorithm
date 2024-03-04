public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    }
    if( p== null || q==null) {
      return false;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    SameTree st = new SameTree();
    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);
    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(2);
    // q.right = new TreeNode(null);
    q.right = null;
    System.out.println(st.isSameTree(p, q));
  }
}
