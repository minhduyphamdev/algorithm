import java.util.Scanner;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
      int len = s.length();
      if (numRows == 1 || numRows > len) {
        return s;
      }
      StringBuilder builder = new StringBuilder();
      StringBuilder[] builders = new StringBuilder[numRows];
      int k = 0;;
      Boolean bool = false;
      for(int i = 0; i < len; i++) {
        if(builders[k] == null) {
          builders[k] = new StringBuilder();
        }
        builders[k].append(s.charAt(i));
        if(k == 0 || k == numRows -1) {
          bool = !bool;
        }

        k+=bool ? 1 : -1;
      }

      for(int i=0;i<numRows;i++){
        builder.append(builders[i].toString());
      }

      return builder.toString();
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String s= scanner.nextLine();
      int numRows = scanner.nextInt();
      ZigZagConversion zigzag = new ZigZagConversion();
      System.out.println(zigzag.convert(s, numRows));
    }
}