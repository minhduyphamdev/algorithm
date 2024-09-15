package java;
public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if(head == null || k == 0) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tail = dummy;
    int count =0;
    while(tail.next!=null) {
      tail=tail.next;
      count++;
    }

    if(count == k ) {
      return head;
    }

    ListNode newTail = dummy;
    for(int j=0;j<count-k%count;j++) {
        newTail = newTail.next;
    }

    tail.next = dummy.next;
    dummy.next = newTail.next;
    newTail.next = null;

    return dummy.next;
  }

  public static void main(String[] args) {
    RotateList rl = new RotateList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode result = rl.rotateRight(head, 2);
    while(result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
