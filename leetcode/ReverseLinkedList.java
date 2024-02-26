import java.util.*;

public class ReverseLinkedList {

  // iterate runtime O(n), space O(3n)
  // public ListNode reverseList(ListNode head) {
  //   if(head == null) {
  //     return null;
  //   }
  //   List<Integer> list = new ArrayList<>();

  //   while(head!=null) {
  //     list.add(head.val);
  //     head = head.next;
  //   }

  //   ListNode reverseHead = new ListNode(list.get(list.size()-1));

  //   ListNode temp = reverseHead;
  //   for(int i = list.size() - 2;i >= 0; i--) {
  //     temp.next = new ListNode(list.get(i));
  //     temp = temp.next;
  //   }

  //   return reverseHead;
  // }

  // iterate runtime O(n), space O(n)
  // public ListNode reverseList(ListNode head){
  //     ListNode p = null;
  //     ListNode q = null;

  //     while(head!=null) {
  //       p = q;
  //       q = head;
  //       head = head.next;
  //       q.next = p;
  //     }

  //     return q;
  // }

  //reverse runtimeO(n), space O(n)
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

  public static void main(String[] args) {
    ReverseLinkedList rl = new ReverseLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode reverse = rl.reverseList(head);
    while(reverse!=null) {
      System.out.println(reverse.val);
      reverse = reverse.next;
    }
  }

}
