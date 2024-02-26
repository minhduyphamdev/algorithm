// problem: https://leetcode.com/problems/reorder-list/

public class ReorderList {
  // split a half -> reverse the second half -> merge the two halves
  public void reorderList(ListNode head) {
    ListNode middle = findMiddle(head);
    ListNode secondHalf = reverseList(middle.next);
    middle.next = null;

    mergeList(head, secondHalf);
  }

  public ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode reverseList(ListNode head) {
    if(head == null) {
      return null;
    }

    return findReverse(head,null);
  }

  public ListNode findReverse(ListNode head, ListNode prev) {
    if(head == null) {
      return prev;
    }

    ListNode newNode = head.next;
    head.next = prev;

    return findReverse(newNode, head);
  }

  public void mergeList(ListNode l1, ListNode l2) {
    while(l1!=null && l2!=null) {
      ListNode l1Next = l1.next;
      ListNode l2Next = l2.next;

      l1.next = l2;
      l2.next = l1Next;

      l1 = l1Next;
      l2 = l2Next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    new ReorderList().reorderList(head);
    while(head!=null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }
}
