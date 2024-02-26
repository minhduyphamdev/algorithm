import java.util.*;

public class MergeKSortedLists {
  // using minHeap
  // public ListNode mergeKLists(ListNode[] lists) {
  //   if(lists == null || lists.length == 0) {
  //     return null;
  //   }

  //   // tang dan
  //   PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

  //   for(ListNode node: lists) {
  //     if(node != null) {
  //       minHeap.add(node);
  //     }
  //   }

  //   ListNode mergeNode = new ListNode(0);
  //   ListNode dummy = mergeNode;

  //   while(!minHeap.isEmpty()) {
  //     ListNode minNode = minHeap.poll();
  //     dummy.next = new ListNode(minNode.val);
  //     dummy = dummy.next;
  //     if(minNode.next != null) {
  //       minHeap.add(minNode.next);
  //     }
  //   }

  //   return mergeNode.next;
  // }

  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }
    
    return mergeKListsHelper(lists, 0 , lists.length-1);
  }

  public ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
    if(start == end) {
      return lists[start];
    }

    int mid = start + (end - start)/2;
    ListNode left = mergeKListsHelper(lists, start, mid);
    ListNode right = mergeKListsHelper(lists, mid+1, end);

    return merge(left, right);
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    if(l1 == l2) {
      return l1;
    }
    ListNode mergeNode = new ListNode(0);
    ListNode dummy = mergeNode;

    while(l1!=null && l2!=null) {
      if(l1.val < l2.val) {
        dummy.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        dummy.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      dummy = dummy.next;
    }

    if(l1!=null) {
      dummy.next = l1;
      l1=l1.next;
      dummy = dummy.next;
    }
    
    if(l2!=null) {
      dummy.next = l2;
      l2=l2.next;
      dummy = dummy.next;
    }

    return mergeNode.next;
  }
  public static void main(String[] args) {
    MergeKSortedLists mk = new MergeKSortedLists();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    ListNode[] lists = {l1,l2,l3};
    ListNode mergeNode = mk.mergeKLists(lists);
    while(mergeNode != null) {
      System.out.println(mergeNode.val);
      mergeNode = mergeNode.next;
    }
  }
}
