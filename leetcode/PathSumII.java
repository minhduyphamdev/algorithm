// 19/03
import java.util.*;

public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> res = new ArrayList<>();
      pathSumHelper(res,new ArrayList<>(),root,targetSum);
      return res;
  }

  public void pathSumHelper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int targetSum) {
    if(root == null) {
      return;
    }

    temp.add(root.val);


    if(root.left == null && root.right == null && targetSum == root.val) {
     res.add(new ArrayList<>(temp));
    } else {
      pathSumHelper(res,temp,root.left,targetSum - root.val);
      pathSumHelper(res,temp,root.right,targetSum - root.val);
    }


  
    temp.remove(temp.size() - 1);
  }

  public static void main(String[] args) {
    PathSumII obj = new PathSumII();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    List<List<Integer>> res = obj.pathSum(root, 22);
    for(List<Integer> list: res) {
      for(int i: list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
