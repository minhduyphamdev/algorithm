public class RemoveDuplicatesFromSortedListii {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null) {
      return null;
    }
    //use two pointers
    ListNode dummy = new ListNode(0), slow = dummy, fast = head;
    dummy.next = head;
    while(fast!=null) {
      while(fast.next!=null && fast.val == fast.next.val) {
        fast = fast.next;
      }
      if(slow.next!= fast) {
        slow.next = fast.next;
        fast = slow.next;
      } else {
        slow = slow.next;
        fast = fast.next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedListii obj = new RemoveDuplicatesFromSortedListii();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(2);
    // head.next.next.next.next = new ListNode(3);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next = new ListNode(5);
    ListNode result = obj.deleteDuplicates(head);
    while(result!=null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
