import org.w3c.dom.Node;

public class RemoveNthFromEnd {
  // public ListNode removeNthFromEnd(ListNode head, int n) {
    
  //   ListNode first = new ListNode();
  //   first.next = head;
  //   ListNode second = head;
  //   boolean found = false;

  //   for(int i=0; i<n; i++) {
  //     second = second.next;
  //   }

  //   while(second!=null) {
  //       first=first.next;
  //       second = second.next;
  //       found = true;
  //   }
  //   if(!found) return head.next;

  //   first.next = first.next.next;
      
  //   return head;
  // }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = new ListNode(0);
    first.next = head;
    ListNode second = head;

    for(int i=0;i<n;i++) {
      second = second.next;
    }

    boolean isTail = true;
     while(second!=null) {
         first=first.next;
         second= second.next;
         isTail = false;
     }

     if(isTail) {
         return head.next;
     }

     first.next= first.next.next;

     return head;
 }
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
      while(result!=null) {
        System.out.print(result.val + " ");
        result = result.next;
      } 
    }
}
