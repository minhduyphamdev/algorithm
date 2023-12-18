import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> list = new Stack<>();
    for(int i = 0; i< s.length();i++) {
      char ch = s.charAt(i);
      if(ch == '(' || ch == '{' || ch=='[') {
        list.add(ch);
      }
      else {
        if(list.isEmpty()) {
          return false;
        }

        char lastCh = list.pop();
        if(ch == ')' && lastCh != '(') {
            return false;
        }
        else if (ch=='}' && lastCh != '{') {
          return false;
        }
        else if (ch==']' && lastCh !='[') {
          return false;
        }
      }
    }

    if(list.size() > 0) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s= scanner.nextLine();
    System.out.println(new ValidParentheses().isValid(s));
  }
}
