import java.util.Arrays;

public class CustomQueue {
    private static final int DEFAULT_CAPACITY = 5;
    private int[] arr;
    private int front;
    private int rear;
    private int size;


    public CustomQueue(int capacity) {
      arr = new int[capacity];
      front = 0;
      rear = 0;
      size = 0;
    }

    public CustomQueue() {
      this(DEFAULT_CAPACITY);
    }

    public void enqueue(int element) {
      if(size == DEFAULT_CAPACITY) {
        resizeArr();
      }

      arr[rear++] = element;
      size++;
    }

    public int dequeue() throws IllegalStateException {
      if(isEmpty()) {
        throw new IllegalStateException("Index is out of bound");
      }
      size --;
      return arr[front--];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public void resizeArr() {
      int newCapacity = size*2;
      int[] newArr = new int[newCapacity];
      System.arraycopy(arr, front, newArr, 0, size);
      arr = newArr;
      front = 0;
      rear = size - 1;
    }

    public static void main(String[] args) {
        // Create a queue
        CustomQueue queue = new CustomQueue();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Enqueue more elements
        queue.enqueue(4);
        queue.enqueue(5);

        // Dequeue the remaining elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}
