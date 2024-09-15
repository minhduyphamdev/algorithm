package java;
import java.util.*;

public class ZigZagLevelOrder {
  // public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
  //   List<List<Integer>> res = new ArrayList<>();
  //   if(root == null) {
  //     return res;
  //   }

  //   Queue<TreeNode> queue = new LinkedList<>();
  //   queue.add(root);
  //   boolean isReverse = false;
  //   while(!queue.isEmpty()) {
  //     int size = queue.size();
  //     List<Integer> temp = new ArrayList<>();
  //     for(int i=0;i<size;i++) {
  //       TreeNode node = queue.poll();
  //       if(node.left!=null) queue.add(node.left);
  //       if(node.right!=null) queue.add(node.right);
  //       temp.add(node.val);
  //     }
  //     if(!isReverse) {
  //       res.add(new ArrayList<>(temp));
  //     }else {
  //       Collections.reverse(temp); 
  //       res.add(new ArrayList<>(temp));
  //     }

  //     isReverse = !isReverse;

  //   }

  //   return res;
  // }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if(root ==null) {
        return res;
      }

      Stack<TreeNode> s1 = new Stack<TreeNode> ();
      Stack<TreeNode> s2 = new Stack<TreeNode> ();
      s1.push(root);

      while(!s1.isEmpty() || !s2.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        while(!s1.isEmpty()) {
          TreeNode node = s1.pop();
          if(node.left!=null) s2.push(node.left);
          if(node.right!=null) s2.push(node.right);
          tmp.add(node.val);
        } 
        res.add(new ArrayList<>(tmp));
        tmp.clear();
        while(!s2.isEmpty()) {
          TreeNode node = s2.pop();
          if(node.right!=null) s1.push(node.right);
          if(node.left!=null) s1.push(node.left);
          tmp.add(node.val);
        }
        if(!tmp.isEmpty()) res.add(tmp);

      }

      return res;
    }

  public static void main(String[] args) {
    ZigZagLevelOrder obj = new ZigZagLevelOrder();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(obj.zigzagLevelOrder(root));
  }
}
