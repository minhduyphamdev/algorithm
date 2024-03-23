public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
      ListNode dummy = new ListNode(0);
      ListNode prev = dummy;
      while(head!=null) {
        ListNode temp = head.next;

        if(prev.val >= head.val) prev = dummy;

        while(prev.next != null && prev.next.val < head.val) {
          prev = prev.next;
        }

        head.next = prev.next;
        prev.next = head;
        head= temp;
      }

      return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);
    ListNode res = new InsertionSortList().insertionSortList(head);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
