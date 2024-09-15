package java;
import java.util.*;

// class MyStack {
//   private Queue<Integer> queue1;
//   private Queue<Integer> queue2;

//   MyStack() {
//     queue1 = new LinkedList<>();
//     queue2 = new LinkedList<>();
//   }
//   // Push element x onto stack.
//   public void push(int x) {
//     queue2.offer(x);

//     while(!queue1.isEmpty()) {
//       queue2.offer(queue1.poll());
//     }

//     Queue<Integer> temp = queue1;
//     queue1 = queue2;
//     queue2 = temp;
//   }

//   public int pop() {
//     return queue1.poll();
//   }

//   // Get the top element.
//   public int top() {
//     return queue1.peek();
//   }

//   // Return whether the stack is empty.
//   public boolean empty() {
//     return queue1.isEmpty();
//   }
// }
class MyStack {
  private Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack() {
      queue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
      queue.offer(x);
      int size = queue.size();
      while (size > 1) {
          queue.offer(queue.poll());
          size--;
      }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
      return queue.poll();
  }

  /** Get the top element. */
  public int top() {
      return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
      return queue.isEmpty();
  }

  public static void main(String[] args) {
      MyStack stack = new MyStack();
      stack.push(1);
      stack.push(2);
      System.out.println(stack.top());   // Output: 2
      System.out.println(stack.pop());   // Output: 2
      System.out.println(stack.empty()); // Output: false
      System.out.println(stack.pop());   // Output: 1
      System.out.println(stack.empty()); // Output: true
  }
}
public class ImplementStackUsingQueues {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
