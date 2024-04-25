public class RunnerTechnique {
    private static ListNode reverseLinkedList(ListNode node) {
      ListNode prev  = null;
      while(node != null) {
        ListNode nextNode = node.next;
        node.next = prev;
        prev = node;
        node = nextNode;
      }

      return prev;
  }

  public ListNode rearrangeLinkedList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }

    ListNode slow = head, fast = head;
    while(fast.next!=null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    

    ListNode firstNode = head,secondNode = slow.next;
    slow.next = null;
    secondNode = reverseLinkedList(secondNode);
    while(secondNode!=null) {
      ListNode nextFirst = firstNode.next;
      ListNode nextSecond = secondNode.next;

      firstNode.next = secondNode;
      secondNode.next = nextFirst;

      firstNode = nextFirst;
      secondNode = nextSecond;
    }
    

    return head;
  }

  public static void main(String[] args) {
    RunnerTechnique obj = new RunnerTechnique();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    // head.next.next.next.next.next.next = new ListNode(7);
    // head.next.next.next.next.next.next.next = new ListNode(8);
    // head.next.next.next.next.next.next.next.next = new ListNode(9);
    // head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    ListNode res = obj.rearrangeLinkedList(head);
    while(res!=null) {
      System.out.print(res.val + " ");
      res = res.next;
    }
  }
}
