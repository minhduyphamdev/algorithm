package java;
import java.util.Scanner;

public class StringToInt {

    public int myAtoi(String s) {
      s = s.trim();

      if(s.length() == 0) {
        return 0;
      }

      int sign = 1;
      if(s.charAt(0) == '-') {
        s = s.substring(1);
        sign = -1;
      }
      else if (s.charAt(0) == '+') {
        s = s.substring(1);
      }
      
      int result = 0;
      for(int i=0; i < s.length(); i++) {


        if(s.charAt(i) <'0'|| s.charAt(i) > '9') {
          break;
        }

        int num = Character.getNumericValue(s.charAt(i));
        if(sign == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7))) {
          return Integer.MAX_VALUE;
        } 
        if(sign == -1 && (result*sign < Integer.MIN_VALUE / 10 || (result*sign == Integer.MIN_VALUE*sign && num == 9))) {
          return Integer.MIN_VALUE;
        }

        result = result * 10 + num;
      }

      return result * sign;
    }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    StringToInt stringToInt = new StringToInt();
    System.out.println(stringToInt.myAtoi(s));
  }

}
