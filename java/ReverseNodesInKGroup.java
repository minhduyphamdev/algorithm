package java;
public class ReverseNodesInKGroup {
 
  // public ListNode reverseKGroup(ListNode head, int k) {
  //   if(head == null || k == 1) {
  //     return head;
  //   }
  //   ListNode dummy = new ListNode(0);
  //   dummy.next = head;
  //   ListNode pre = dummy;
  //   int i = 0;
  //   while(head != null) {
  //     i++;
  //     if(i % k == 0) {
  //       pre = reverse(pre, head.next);
  //       head = pre.next;
  //     }
  //     else {
  //       head = head.next;
  //     }
  //   }
  //   return dummy.next;
  // }

  // private ListNode reverse(ListNode pre, ListNode next) {
  //   ListNode last = pre.next;
  //   ListNode cur = last.next;
  //   while(cur != next) {
  //     last.next = cur.next;
  //     cur.next = pre.next;
  //     pre.next = cur;
  //     cur = last.next;
  //   }
  //   return last;
  // }
  
    public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || k == 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    int i=0;
    while(head!= null ) {
      i++;
      if(i%k == 0) {
        prev = reverse(prev,head.next);
        head = prev.next;
      }
      else {
        head = head.next;
      }
    }

    return dummy.next;
  }

  public ListNode reverse(ListNode prev, ListNode next) {
    ListNode tail = prev.next;
    ListNode curr = tail.next;
    while(curr!=next) {
      tail.next = curr.next;
      curr.next = prev.next;
      prev.next = curr;
      curr = tail.next;
    }

    return tail;
  }

  public static void main(String[] args) {
    ReverseNodesInKGroup rng = new ReverseNodesInKGroup();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
  
    ListNode result = rng.reverseKGroup(head, 3);
    while(result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
