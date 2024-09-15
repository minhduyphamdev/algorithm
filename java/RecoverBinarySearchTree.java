package java;
public class RecoverBinarySearchTree {
  private TreeNode first = null;
  private TreeNode second = null;
  private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
  public void recoverTree(TreeNode root) {
    findInvalidNode(root);

    if(first!=null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }


  // in order traversal and find abnormal case node
  public void findInvalidNode(TreeNode root) {
    if(root == null) return;

    findInvalidNode(root.left);

    if(prev.val > root.val) {
      // find the largest invaid node in the left
      if(first == null) {
        first = prev;
      }

      second = root;
    }

    prev = root;

    findInvalidNode(root.right);
  }

  public static void main(String[] args) {
    RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    obj.recoverTree(root);

    System.out.println("");
    //print tree
    printInOrder(root);
    
  }

  private static void printInOrder(TreeNode root) {
    if(root == null) return;
    printInOrder(root.left);
    System.out.println(root.val);
    printInOrder(root.right);
  }
}
