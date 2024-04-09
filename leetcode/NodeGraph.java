import java.util.*;

public class NodeGraph {

    public int val;
    public List<NodeGraph> neighbors;
    public NodeGraph() {
        val = 0;
        neighbors = new ArrayList<NodeGraph>();
    }
    public NodeGraph(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeGraph>();
    }
    public NodeGraph(int _val, ArrayList<NodeGraph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
