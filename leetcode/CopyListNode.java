
public class CopyListNode {
  public ListNode copyListNode(ListNode head) {
    if(head==null) {
      return null;
    }

    // root of new ListNode
    ListNode newHead = new ListNode(head.val);

    //Keep track of current node and new Node
    ListNode originalList = head;
    ListNode newList = newHead;

    while(originalList.next!=null) {
      originalList = originalList.next;

      newList.next = new ListNode(originalList.val);

      newList = newList.next;
    }

    return newList;

  }
}
