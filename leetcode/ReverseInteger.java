import java.util.Scanner;

public class ReverseInteger {
  // solution 1
  // public int reverse(int x) {
  //   String s= Integer.toString(x);
  //   long result = 0;

  //   if(s.charAt(0) != '-') {
  //     s = new StringBuilder(s).reverse().toString();
  //     result = Long.parseLong(s);
  //   }
  //   else {
  //     s = s.substring(1);
  //     s = '-' + new StringBuilder(s).reverse().toString();
  //     result = Long.parseLong(s);
  //   }

  //   if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
  //     return 0;
  //   }

  //   return (int) result;
  // }

  // solution 2 
    public int reverse(int x) {
    // MAX_VALUE: 2147483647
    // MIN_VALUE: -2147483648
    int result =0;
    while(x!=0) {
        int mod = x % 10;

        if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE /10 && mod >7 )) {
            return 0;
        }
        
        if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 &&  mod == -9)) {
            return 0;
        }

        result = result * 10 + mod;
        x/=10;
    }

    return result;
    }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    ReverseInteger reverseInteger = new ReverseInteger();
    System.out.println(reverseInteger.reverse(x));
  }

}
