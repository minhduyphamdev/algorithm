package java;
import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    int result = 0;
    int curr = 0;
    int sign = 1;
    Stack<Integer> stack = new Stack<>();
    for(int i=0;i<s.length();i++) {
      Character ch = s.charAt(i);
      if(Character.isDigit(ch)) {
        curr = curr*10 + (int)(ch-'0');
      }
      else if(ch == '+') {
        result += curr*sign;
        sign = 1;
        curr = 0;
      }
      else if(ch == '-') {
        result +=curr*sign;
        sign=-1;
        curr = 0;
      }
      else if(ch == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign=1;
      }
      else if(ch==')'){
        result = (result+curr*sign)*stack.pop() + stack.pop();
        curr = 0; 
        sign = 1;
      }
    }

    if(curr!=0) {
      result += sign*curr; 
    }

    return result;
  }

  public static void main(String[] args) {
    //String s = "1+1";
    // String s = "(1-(-2))";
    String s= "-(3+(4+5))";
    System.out.println(new BasicCalculator().calculate(s));
  }
}
