package java;
import java.util.*;

public class CloneGraph {
    private HashMap<Integer, NodeGraph> map = new HashMap<>();
    public NodeGraph cloneGraph(NodeGraph node) {
      if(node == null) {
        return node;
      }
      return cloneNewGraph(node);
    }

    public NodeGraph cloneNewGraph(NodeGraph node) {
      if(map.containsKey(node.val)) {
        return map.get(node.val);
      }

      NodeGraph newNode = new NodeGraph(node.val);
      map.put(node.val, newNode);
      for(NodeGraph neighbor: node.neighbors) {
        newNode.neighbors.add(cloneNewGraph(neighbor));
      }

      return newNode;
    }


    public static void main(String[] args) {
        NodeGraph node1 = new NodeGraph(1);
        NodeGraph node2 = new NodeGraph(2);
        NodeGraph node3 = new NodeGraph(3);
        NodeGraph node4 = new NodeGraph(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        CloneGraph cg = new CloneGraph();
        NodeGraph clone = cg.cloneGraph(node1);
        System.out.println(clone.val);
    }
}

