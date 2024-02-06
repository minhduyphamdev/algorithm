public class FiFoQueue {
  int maxSize;
  int[] arr;
  int front;
  int back;

  FiFoQueue(int maxSize) {
    this.maxSize = maxSize;
    this.arr = new int[maxSize];
    this.front = 0;
    this.back = -1;
  }

  public boolean isFull() {
    return back - front + 1 == maxSize - 1;
  }

  public boolean isEmpty() {
    return back < front;
  }

  public void enqueue(int num) {
    if(!isFull()) {
      arr[++back] = num;
      return;
    }

  }

  public int dequeue() {
    if(!isEmpty()) {
      return arr[front++];
    }

    throw new IllegalArgumentException("Queue is empty");
  }

  public boolean isExist(int num) {
    for(int i= front; i< back; i++) {
      if(arr[i] == num) {
        return true;
      }
    }

    return false;
  }
 
  public static void main(String[] args) {
    FiFoQueue queue = new FiFoQueue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    queue.dequeue();
    queue.enqueue(4);
  }
}
