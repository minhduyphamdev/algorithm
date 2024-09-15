package java;
public class NodeLeftRightNext {
  // Definition for a Node.
  public int val;
  public NodeLeftRightNext left;
  public NodeLeftRightNext right;
  public NodeLeftRightNext next;

  public NodeLeftRightNext() {}
  
  public NodeLeftRightNext(int _val) {
      val = _val;
  }

  public NodeLeftRightNext(int _val, NodeLeftRightNext _left, NodeLeftRightNext _right, NodeLeftRightNext _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
  }
};
