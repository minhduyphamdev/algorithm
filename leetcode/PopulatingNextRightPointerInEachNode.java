import java.util.*;

public class PopulatingNextRightPointerInEachNode {
  public NodeLeftRightNext connect(NodeLeftRightNext root) {
    if(root == null) {
      return null;
    }

    Queue<NodeLeftRightNext> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int size = queue.size();
      List<NodeLeftRightNext> tempList = new ArrayList<>();
      for(int i=0;i<size;i++) {
        NodeLeftRightNext node = queue.poll();
        tempList.add(node);
        if(node.left != null) queue.add(node.left);
        if(node.right!=null) queue.add(node.right);
      }

      for(int i=0;i<tempList.size()-1;i++) {
        tempList.get(i).next = tempList.get(i+1);
      }
    }

    return root;
  }
 
  public static void main(String[] args) {
    PopulatingNextRightPointerInEachNode obj = new PopulatingNextRightPointerInEachNode();
    NodeLeftRightNext root = new NodeLeftRightNext(1);
    root.left = new NodeLeftRightNext(2);
    root.right = new NodeLeftRightNext(3);
    root.left.left = new NodeLeftRightNext(4);
    root.left.right = new NodeLeftRightNext(5);
    root.right.left = new NodeLeftRightNext(6);
    root.right.right = new NodeLeftRightNext(7);
    NodeLeftRightNext result = obj.connect(root);
    System.out.println(result);
  }
}
