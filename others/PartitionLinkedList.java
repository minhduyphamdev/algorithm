public class PartitionLinkedList {


  // Function to print the linked list
  static ListNode partition(ListNode head, int x)
  {

      /* Let us initialize first and last nodes of
      three linked lists
          1) Linked list of values smaller than x.
          2) Linked list of values equal to x.
          3) Linked list of values greater than x.*/
      ListNode smallerHead = null, smallerLast = null;
      ListNode greaterLast = null, greaterHead = null;
      ListNode equalHead = null, equalLast = null;

      // Now iterate original list and connect nodes
      // of appropriate linked lists.
      while (head != null) {
          // If current node is equal to x, append it
          // to the list of x values
          if (head.val == x) {
              if (equalHead == null)
                  equalHead = equalLast = head;
              else {
                  equalLast.next = head;
                  equalLast = equalLast.next;
              }
          }

          // If current node is less than X, append
          // it to the list of smaller values
          else if (head.val < x) {
              if (smallerHead == null)
                  smallerLast = smallerHead = head;
              else {
                  smallerLast.next = head;
                  smallerLast = head;
              }
          }
          else // Append to the list of greater values
          {
              if (greaterHead == null)
                  greaterLast = greaterHead = head;
              else {
                  greaterLast.next = head;
                  greaterLast = head;
              }
          }
          head = head.next;
      }

      // Fix end of greater linked list to NULL if this
      // list has some nodes
      if (greaterLast != null)
          greaterLast.next = null;

      // Connect three lists

      // If smaller list is empty
      if (smallerHead == null) {
          if (equalHead == null)
              return greaterHead;
          equalLast.next = greaterHead;
          return equalHead;
      }

      // If smaller list is not empty
      // and equal list is empty
      if (equalHead == null) {
          smallerLast.next = greaterHead;
          return smallerHead;
      }

      // If both smaller and equal list
      // are non-empty
      smallerLast.next = equalHead;
      equalLast.next = greaterHead;
      return smallerHead;
  }

  /* Function to print linked list */
  static void printList(ListNode head)
  {
      ListNode temp = head;
      while (temp != null) {
          System.out.print(temp.val + " ");
          temp = temp.next;
      }
  }

  // Driver code
  public static void main(String[] args)
  {
      /* Start with the empty list */
      ListNode head = new ListNode(10);
      head.next = new ListNode(4);
      head.next.next = new ListNode(5);
      head.next.next.next = new ListNode(30);
      head.next.next.next.next = new ListNode(2);
      head.next.next.next.next.next = new ListNode(50);

      int x = 3;
      head = partition(head, x);
      printList(head);
  }
  }
