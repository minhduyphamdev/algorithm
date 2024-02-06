import java.util.HashMap;
import java.util.Scanner;

public class IntToRoman {
  public String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    StringBuilder romanValues = new StringBuilder();

   for(int i=0;i<values.length;i++) {
    while(num>=values[i]){
      romanValues.append(romanLetters[i]);
      num-=values[i];
    }
  }

    return romanValues.toString();
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    IntToRoman myClass = new IntToRoman();
    System.out.println(myClass.intToRoman(num));
  }
}
