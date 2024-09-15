package java;
public class SortLinkedList {
  public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }

    ListNode slow = new ListNode(0), fast = new ListNode(0);
    slow.next = head;
    fast.next = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode temp = slow.next; 
    slow.next = null;
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(temp);

    return merge(l1, l2);
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode newHead = new ListNode(0), temp = newHead;
    while(l1!=null && l2!=null) {
        if(l1.val < l2.val) {
          temp.next = new ListNode(l1.val);
          l1=l1.next;
        } else {
          temp.next = new ListNode(l2.val);
          l2=l2.next;
        }
        
        temp = temp.next;
    }

    while(l1!=null) {
      temp.next = new ListNode(l1.val);
      l1=l1.next;
      temp = temp.next;
    }

    while(l2!=null) {
      temp.next = new ListNode(l2.val);
      l2=l2.next;
      temp = temp.next;
    }

    return newHead.next;
  }

  public static void main(String[] args) {
    SortLinkedList obj = new SortLinkedList();
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);
    ListNode res = obj.sortList(head);
    while(res!=null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
  }
}
