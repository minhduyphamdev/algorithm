package java;
public class SortedArrayToBinarySearchTree {
  // moi phan tu cua height - balanced tree nam o chinh giua cua mang con
  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) {
      return null;
    }

    return buildHeightBalancedTree(nums, 0, nums.length);
  }

  public TreeNode buildHeightBalancedTree(int[] nums, int left, int right) {
    if(left > right) {
      return null;
    }

    int mid = left + (right-left) /2;
    if(mid == nums.length) {
      return null;
    }
    TreeNode node = new TreeNode(nums[mid]);

    node.left = buildHeightBalancedTree(nums, left, mid-1);
    node.right = buildHeightBalancedTree(nums, mid+1, right );

    return node;
  }

  public static void main(String[] args) {
    SortedArrayToBinarySearchTree obj = new SortedArrayToBinarySearchTree();
    TreeNode root = obj.sortedArrayToBST(new int[]{0,1,2,3,4,5});
    System.out.println(root.val);
  }
}
