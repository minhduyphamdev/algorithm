package java;
import java.util.*;

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public Node(int val, Node random) {
    this.val = val;
    this.next = null;
    this.random = random;
  }
}

public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    if(head==null) {
      return null;
    }

    // root of new ListNode
    Node newHead = new Node(0);

    //Keep track of current node and new Node
    Node originalList = head;
    Node newList = newHead;

    //map contains both next and random Node
    HashMap<Node,Node> map = new HashMap<>();

    while(originalList!=null) {
      // next node
      if(!map.containsKey(originalList)) {
        Node newNode = new Node(originalList.val);
        map.put(originalList, newNode);
        newList.next = newNode;
      }
      else {
        newList.next = map.get(originalList);
      }
    
      // random node
      if(originalList.random !=null) {
        Node originalRandom = originalList.random;

        if(!map.containsKey(originalRandom)) {
          Node newNode = new Node(originalRandom.val);
          map.put(originalRandom, newNode);
          newList.next.random = newNode;
        }
        else {
          newList.next.random = map.get(originalRandom);
        }
      }
    
      originalList = originalList.next;
      newList = newList.next;
    }


    return newHead.next;
  }

  public static void main(String[] args) {
    Node head = new Node(7);
    head.next = new Node(13,head);
    Node tail = new Node(1,head);
    head.next.next = new Node(11,tail);
    head.next.next.next = new Node(10,head.next.next);
    head.next.next.next.next = tail;

    Node newHead = new CopyListWithRandomPointer().copyRandomList(head);
  }
}
