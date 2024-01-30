public class QueueImpl {
  public static void main(String[] args){
    insert(3);
    insert(5);
    insert(9);
    insert(1);
    insert(12);
    insert(15);
    System.out.print("Queue: ");
    while(!isEmpty()) {
        int n = removeData();
        System.out.print(n + " ");
    }
  }
    static final int MAX = 6;
    static int intArray[] = new int[MAX];
    static int front = -1;
    static int rear = -1;
    static int itemCount = 0;
    public static boolean isFull(){
      return itemCount == MAX;
    }
    public static boolean isEmpty(){
      return itemCount == 0;
    }
    public static int removeData(){
      int data = intArray[++front];
      if(front == MAX) {
          front = 0;
      }
      itemCount--;
      return data;
    }
    public static void insert(int data){
      if(!isFull()) {
          if(rear == MAX-1) {
            rear = -1;
          }
          intArray[++rear] = data;
          itemCount++;
      }
    }
}