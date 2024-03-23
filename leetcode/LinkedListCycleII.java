public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    if(head == null) {
      return null;
    }

    ListNode first = head, second = head;
    while(second!=null && second.next != null) {
      first = first.next;
      second = second.next.next;
      if(first == second) {
        break;
      }
    }
    
    if(second == null || second.next == null) {
      return null;
    }

    while(head!=first) {
      head = head.next;
      first = first.next;
    }

    return head;
  }

  public static void main(String[] args) {
    LinkedListCycleII l = new LinkedListCycleII();
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(-4);
    head.next.next.next.next = head.next;
    System.out.println(l.detectCycle(head).val);
  }
}
