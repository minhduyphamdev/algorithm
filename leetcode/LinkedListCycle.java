// problem: https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    ListNode first = head;
    ListNode second = head.next;
    while(second!=null && second.next!=null) {
      if(first == second) {
        return true;
      } 

      first=first.next;
      second=second.next.next;
    }

    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = head.next;

    System.out.println(new LinkedListCycle().hasCycle(head));
  }
}
