package java;
public class InsertionOfTwoLinkedLists {
  // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
  //   while(headA != null) {
  //     ListNode res = insertionHelper(headA, headB);
  //     if(res!=null) {
  //       return res;
  //     }
  //     headA= headA.next;
  //   }

  //   return null;
  // }

  // public ListNode insertionHelper(ListNode a, ListNode b ){
  //   while(b!=null) {
  //     if(a==b) {
  //       return a;
  //     }

  //     b=b.next;
  //   }

  //   return null;
  // }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}

  public static void main(String[] args) {
    ListNode headA = new ListNode(4);
    headA.next = new ListNode(1);
    headA.next.next = new ListNode(8);
    headA.next.next.next = new ListNode(4);
    headA.next.next.next.next = new ListNode(5);

    ListNode headB = new ListNode(5);
    headB.next = new ListNode(6);
    headB.next.next = new ListNode(1);
    headB.next.next.next = headA.next.next;

    ListNode res = new InsertionOfTwoLinkedLists().getIntersectionNode(headA, headB);
    System.out.println(res.val);
  }
}
