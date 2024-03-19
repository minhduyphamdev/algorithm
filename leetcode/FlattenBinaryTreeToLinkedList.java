public class FlattenBinaryTreeToLinkedList {
  // Function to perform Morris in-order traversal
  // predecessor luon sang phai, curr luon sang trai tru truong hop print
  public static void morrisTraversal(TreeNode root) {
    TreeNode curr = root;
    while(curr != null) {
      if(curr.left == null) {
        System.out.print(curr.val + " ");
        curr = curr.right;
      } else {
        TreeNode predecessor = curr.left;
        while(predecessor.right != null && predecessor.right != curr) {
          predecessor = predecessor.right;
        }

        if(predecessor.right == null) {
          predecessor.right = curr;
          curr = curr.left;
        } else {
          System.out.print(curr.val+ " ");
          predecessor.right  = null;
          curr = curr.right;
        }

      }
    }

  }

  private TreeNode prev = null;

  private void flatten(TreeNode root) {
    if(root == null) {
      return;
    }

    flatten(root.right);
    flatten(root.left);

    root.right = prev;
    root.left = null;
    prev = root;
  }

  public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    obj.flatten(root);
    while(root != null) {
      System.out.print(root.val + " ");
      root = root.right;
    }
  }
}
