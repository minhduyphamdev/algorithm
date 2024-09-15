package java;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    ListNode slow = head, fast = head, prev, temp;
    while(fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    prev = slow; // prev is the first node of reverse linked list
    slow = slow.next;
    prev.next = null;
    while(slow!=null) {
       temp = slow.next; // keep temporary the next slow node to reverse
       slow.next = prev;
       prev = slow;
       slow = temp;
    }

    slow = head;
    fast = prev;
    while(fast!=null) {
      if(slow.val!=fast.val) return false;
      fast = fast.next;
      slow = slow.next;
    }

    return true;
  }

  public static void main(String[] args) {
    PalindromeLinkedList obj = new PalindromeLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(1);
    System.out.println(obj.isPalindrome(head));
  }
}
