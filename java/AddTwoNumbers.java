package java;
//problem link: https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    int temp = 0;
    ListNode result = null;
    ListNode head = null;
    while(l1!=null || l2!=null) {
        if(l1!=null) {
            sum+=l1.val;
            l1=l1.next;
        }

        if(l2!=null) {
            sum+=l2.val;
            l2=l2.next;
        }

        sum+=temp;
        temp = sum / 10;
        sum = sum % 10;

        if(result == null) {
          result = new ListNode(sum);
          head = result;
        }
        else {
          result.next = new ListNode(sum);
          result = result.next;
        }

        sum = 0;
    }

    if(temp!=0) {
      result.next= new ListNode(1);
    }

    return head;
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next= new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next= new ListNode(4);

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    ListNode result = addTwoNumbers.addTwoNumbers(l1,l2);

  }
}
