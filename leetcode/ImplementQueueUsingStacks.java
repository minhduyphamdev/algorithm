import java.util.*;
class MyQueue {

  Stack<Integer> stack1;
 Stack<Integer> stack2;

 /** Initialize your data structure here. */
 MyQueue() {
   stack1 = new Stack<>();
   stack2 = new Stack<>();
 }

 public void push(int x) {
   while(!stack1.isEmpty()) {
    stack2.push(stack1.pop());
   }

   stack1.push(x);

   while(!stack2.isEmpty()) {
    stack1.push(stack2.pop());
   }
 }

 public int pop() {
  if(!stack1.isEmpty()) {
    return stack1.pop();
  }

  throw new RuntimeException("Queue is empty");
 }

 public int peek() {
   return stack1.peek();
 }

 public boolean empty() {
   return stack1.isEmpty();
 }
}
public class ImplementQueueUsingStacks {

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.push(5);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
  }
}
