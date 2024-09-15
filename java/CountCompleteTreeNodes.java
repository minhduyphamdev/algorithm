package java;
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
      if(root == null) {
        return 0;
      }
      return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes obj = new CountCompleteTreeNodes();
        TreeNode root = null;

        System.out.println(obj.countNodes(root));
    }
}
