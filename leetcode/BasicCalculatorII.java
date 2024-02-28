import java.util.*;

public class BasicCalculatorII {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int curr = 0;
    char operator = '+';
    for(int i=0;i<s.length();i++) {
      if(Character.isDigit(s.charAt(i))) {
        curr = curr*10 + (s.charAt(i) - '0');
      }
      else if(s.charAt(i) !=' ') {
        if(operator == '+' || operator == '-') {
          stack.push(operator == '+' ? curr : -curr);          
        }
        else {
          int prev = stack.pop();
          stack.push(operator == '*' ? prev*curr : prev/curr);
        }

        operator = s.charAt(i);
        curr = 0;
      }
    }

    if(operator == '+' || operator == '-') {
      stack.push(operator == '+' ? curr : -curr);          
    }
    else {
      int prev = stack.pop();
      stack.push(operator == '*' ? prev*curr : prev/curr);
    }

    while(stack.size() > 1) {
      stack.push(stack.pop() + stack.pop());
    }
    
    return stack.pop();
  }

  public static void main(String[] args) {
    BasicCalculatorII bc = new BasicCalculatorII();
    // String s = "3+2*2";
    String s = "(1+(4+5+2)-3)+(6+8)";
    // String s = " 3/2 ";
    // String s = " 3+5 / 2 ";
    // String s = " 3+5 / 2 * 2";
    // String s = "42";
    System.out.println(bc.calculate(s));
  }
}
