package java;
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0), slow = dummy, fast = head;
    dummy.next = head;
    while(fast!=null) {
      while(fast.next!= null && fast.val == fast.next.val) {
        fast=fast.next;
      }
      slow.next = fast;
      slow = slow.next;
      fast = fast.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(3);
    ListNode res = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
    while(res!=null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
