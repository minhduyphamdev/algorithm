public class SwapNodeInPairs {
  // public ListNode swapList( ListNode first, ListNode second) {
  //   first.next = second.next;
  //   second.next = first;
  //   return second;
  // }
  // public ListNode swapPairs(ListNode head) {
  //   if(head == null) {
  //     return head;
  //   };

  //   ListNode dummy = new ListNode();
  //   dummy.next = head;
  //   ListNode current = dummy;


  //   while(current.next != null && current.next.next != null) {
  //     current.next = swapList(current.next, current.next.next);
  //     current = current.next.next;
  //   }

  //   return dummy.next;
  // }

  public ListNode swapPairs(ListNode head) {
    // Base case: If the list has 0 or 1 node, no need to swap
    if (head == null || head.next == null) {
        return head;
    }

    // Nodes to be swapped
    ListNode firstNode = head;
    ListNode secondNode = head.next;

    // Swap the nodes
    firstNode.next = swapPairs(secondNode.next);
    secondNode.next = firstNode;

    // The new head is the second node after swapping
    return secondNode;
  }
  public static void main(String[] args) {
    ListNode test = new ListNode(1);
    test.next = new ListNode(2);
    test.next.next = new ListNode(3);
    test.next.next.next = new ListNode(4);

    // ListNode test = new ListNode(1);

    ListNode result = new SwapNodeInPairs().swapPairs(test);
    while(result!=null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
