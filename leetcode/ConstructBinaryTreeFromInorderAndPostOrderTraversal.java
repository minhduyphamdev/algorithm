public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0 , inorder.length - 1, postorder, 0, postorder.length-1);
  }

  public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    // node null
    if(inStart > inEnd || postStart > postEnd) {
      return null;
    }

    // get the root from postorder
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    int inPos = 0;
    for(int i=inStart; i <= inEnd; i++) {
      if(inorder[i] == rootVal) {
        inPos = i;
        break;
      }
    }

    // lengthOfLeftTree
    int leftLen = inPos - inStart;
    int rightLen = inEnd - inPos;
    root.left = buildTree(inorder, inStart, inPos -1, postorder, postStart, postStart + leftLen -1);
    root.right = buildTree(inorder, inPos + 1, inEnd,postorder, postEnd - rightLen,postEnd-1);

    return root;
  }

    public static void main(String[] args) {
    ConstructBinaryTreeFromInorderAndPostOrderTraversal obj = new ConstructBinaryTreeFromInorderAndPostOrderTraversal();
    TreeNode root = obj.buildTree(new int[]{2,9,5,3,15,20,7}, new int[]{2,5,9,15,7,20,3});
    obj.printInOrder(root);
  }

  public void printInOrder(TreeNode root) {
    if(root == null) return;
    printInOrder(root.left);
    System.out.println(root.val);
    printInOrder(root.right);
  }
}
