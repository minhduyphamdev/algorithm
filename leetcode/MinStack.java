import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        mainStack.push(x);

        // Update the minStack with the current minimum element
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    /** Pop the element on top of the stack. */
    public void pop() {
        if (!mainStack.isEmpty()) {
            // If the popped element is the current minimum, update minStack
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }
    }

    /** Get the top element of the stack. */
    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }

    /** Retrieve the minimum element in the stack. */
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty");
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
