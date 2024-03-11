public class ReverseLInkedListII {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if(left>=right) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    for(int i=0;i<left-1;i++) {
      p = p.next;
    }

    ListNode prev = p;
    ListNode tail = prev.next;

    for(int i=0;i<right - left;i++) {
      ListNode tmp = prev.next;
      prev.next = tail.next;
      tail.next = tail.next.next;
      prev.next.next = tmp;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ReverseLInkedListII reverseLInkedListII = new ReverseLInkedListII();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    // head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);
    ListNode result = reverseLInkedListII.reverseBetween(head, 1, 2);
    while(result!=null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
