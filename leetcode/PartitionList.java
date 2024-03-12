public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0), slow = dummy, fast = head;
    dummy.next = head;
    boolean findLarger = false;
    ListNode large = null;
    while(fast!=null) {
      if(fast.val>=x && large == null) {
        large = slow;
      } 
      if(fast. val < x && large !=null) {
        slow.next = fast.next;
          fast.next = large.next;
          large.next = fast;
          fast = slow.next;
          large = large.next;
          continue;
      }
      fast = fast.next;
      slow = slow.next;
      
    }
  
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(0);
    head.next.next.next.next = new ListNode(2);
    head.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next = new ListNode(2);
    ListNode res = new PartitionList().partition(head, 3);
    while(res!=null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
