import java.util.Stack;

class MinStack {
   Stack<Integer> stack;
   Stack<Integer> minStack;

   MinStack() {
     stack = new Stack<>();
     minStack = new Stack<>();
   }

   public void push(int x) {
    stack.push(x);
    if(minStack.isEmpty() || minStack.peek() >=x) {
        minStack.push(x);
    }
   }

   public void pop() {
    if(stack.isEmpty()) {
        return;
    }
    if(stack.peek().equals(minStack.peek())) {
        minStack.pop();
    }

    stack.pop();
   }

   public int top() {
    return stack.peek();
   }

   public int getMin() {
    return minStack.peek();
   }

    public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      minStack.getMin(); // return -3
      minStack.pop();
      minStack.top();    // return 0
      minStack.getMin(); // return -2
    }
}
