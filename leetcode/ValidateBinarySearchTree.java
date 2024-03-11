import java.util.*;

public class ValidateBinarySearchTree {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.empty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
        
    }

    return list;
  }

  public boolean isValidBST(TreeNode root) {
    TreeNode prev = null;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    root = root.left;
    while(root!=null || !stack.isEmpty()) {
      while(root!=null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(prev!=null && root.val <= prev.val) {
        return false;
      }
      prev = root;
      root = root.right;
    }

    return true;
  }

  public static void main(String[] args) {
    ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    System.out.println(obj.isValidBST(root));
  }
}
