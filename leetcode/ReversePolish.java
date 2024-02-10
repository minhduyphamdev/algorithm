import java.util.*;

public class ReversePolish {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();   
    String math = "+-*/";
    for(String token: tokens) {
      if(!math.contains(token)) {
        stack.push(Integer.parseInt(token));
      }
      else {
        int a = stack.pop();
        int b = stack.pop();
        if(token.equals("+")) {
          stack.push(a+b);
        }
        else if(token.equals("-")) {
          stack.push(b-a);
        }
        else if(token.equals("*")) {
          stack.push(a*b);
        }
        else {
          stack.push(b/a);
        }
      }
    }  

    return stack.pop();
  }
  public static void main(String[] args) {
    // String[] tokens = new String[] {"2","1","+","3","*"};
    String[] tokens = new String[] {"4","13","5","/","+"};
    System.out.println(new ReversePolish().evalRPN(tokens));
  }
  
}
