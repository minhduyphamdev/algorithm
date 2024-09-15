package java;
// problem: https://leetcode.com/problems/design-circular-queue/

public class MyCircularQueue {
  private int[] queue;
  private int front;
  private int rear;
  private int size;
  private int capacity;

  public MyCircularQueue(int k) {
    queue = new int[k];
    front = 0;
    rear = -1;
    size = 0;
    capacity = k;
  }

  public boolean enQueue(int value) {
    if(isFull()) {
      return false;
    }

    rear+=1;
    if(rear >= capacity) {
      rear-=capacity;
    }

    queue[rear] = value;
    size+=1;
    return true;
  }

  public boolean deQueue() {
    if(isEmpty()) {
      return false;
    }

    front+=1;
    if(front >= capacity) {
      front-=capacity;
    }
    size--;
    return true;
  }

  public int Front() {
    if(isEmpty()) {
      return -1;
    }

    return queue[front];
  }

  public int Rear() {
    if(isEmpty()) {
      return -1;
    }

    return queue[rear];
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {
    MyCircularQueue queue = new MyCircularQueue(3);
    System.out.println(queue.enQueue(1));  // Output: true
    System.out.println(queue.enQueue(2));  // Output: true
    System.out.println(queue.enQueue(3));  // Output: true
    System.out.println(queue.enQueue(4));  // Output: false
    System.out.println(queue.Rear());      // Output: 3
    System.out.println(queue.isFull());    // Output: true
    System.out.println(queue.deQueue());   // Output: true
    System.out.println(queue.enQueue(4));  // Output: true
    System.out.println(queue.Rear());      // Output: 4
  }
}
