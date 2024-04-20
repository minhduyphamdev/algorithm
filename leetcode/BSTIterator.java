import java.util.*;

// public class BSTIterator {
//   LinkedList<Integer> list;
//   int pointer;
//   public BSTIterator(TreeNode root) {
//     list = new LinkedList<>();
//     initializeTree(root);
    
//   }

//   public void initializeTree(TreeNode root) {
//     if(root == null) {
//       return;
//     }

//     if(root.left != null) initializeTree(root.left);
//     list.add(root.val);
//     if(root.right != null) initializeTree(root.right);
//   }
  

//   public int next() {
//     return list.get(pointer++);
//   }

//   public boolean hasNext() {
//     return pointer != list.size();
//   }

//   public static void main(String[] args) {
//     TreeNode root = new TreeNode(7);
//     root.left = new TreeNode(3);
//     root.right = new TreeNode(15);
//     root.right.left = new TreeNode(9);
//     root.right.right = new TreeNode(20);

//     BSTIterator obj = new BSTIterator(root);
//     while(obj.hasNext()) {
//       System.out.println(obj.next());
//     }
//   }
// }


public class BSTIterator {
  Stack<TreeNode> stack = new Stack<>();

  public BSTIterator(TreeNode root) {
    fillLeftTree(root);
  }

  public int next() {
    TreeNode node = stack.pop();
    fillLeftTree(node.right);
    return node.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public void fillLeftTree(TreeNode root) {
    while(root!=null) {
      stack.push(root);
      root = root.left;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);

    BSTIterator obj = new BSTIterator(root);
    while(obj.hasNext()) {
      System.out.println(obj.next());
    }
  }
}