package viblo;

import java.util.*;

public class Oneforall {
  static String slurpStdin() {
    String input = "";
    Scanner scan = new Scanner(System.in);

    while (true) {
        input += scan.nextLine();
        if (scan.hasNextLine()) {
            input += "\n";
        } else {
            break;
        }
    }

    return input;
  }
  
  public static void main(String[] args) {
    String input = slurpStdin();

    System.out.println(countNumOfChanges(input));
  }

  public static int countNumOfChanges(String input) {
    int num = Integer.parseInt(input);
    if(num == 1) {
      return 0;
    }

    int count2 = 0;
    int count3 = 0;
    while(num > 1) {
      while(num%2 == 0) {
        num/=2;
        count2++;
      }

      while(num%3==0) {
        num/=3;
        count3++;
      }
    }

    if(num!=1 || count2 > count3) {
      return -1;
    }

    return 2*count3 - count2;
  }
}
