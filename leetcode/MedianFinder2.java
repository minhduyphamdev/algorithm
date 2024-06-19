
import java.util.*;

public class MedianFinder2 {
  // ref:https://leetcode.com/problems/find-median-from-data-stream/solutions/74047/java-python-two-heap-solution-o-log-n-add-o-1-find/?envType=study-plan-v2&envId=top-interview-150
  // using PriorityQueue
  private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
  private PriorityQueue<Integer> large = new PriorityQueue<>();
  private boolean even = true;

  public double findMedian() {
    if(even) {
      return (small.peek() + large.peek()) / 2.0;
    } else {
      return small.peek();
    }
  }

  public void addNum(int num) {
    if(even) {
      large.offer(num);
      small.offer(large.poll());
    } else {
      small.offer(num);
      large.offer(small.poll());
    }

    even = !even;
  }

  public static void main(String[] args) {
    MedianFinder2 obj = new MedianFinder2();
    obj.addNum(6);
    obj.addNum(10);
    obj.addNum(2);
    obj.addNum(6);
    obj.addNum(5);
    obj.addNum(0);
    System.out.println(obj.findMedian());
  }
}
