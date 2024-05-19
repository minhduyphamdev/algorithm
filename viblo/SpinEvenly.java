package viblo;

import java.util.*;

public class SpinEvenly {
  public static void SpinEvenly(String input, String spinTime) {
    String[] inputs = input.split(",");
    int[] arr = new int[inputs.length];
    for(int i=0;i<inputs.length;i++) {
      arr[i] = Integer.parseInt(inputs[i]);
    }

    int time = Integer.parseInt(spinTime) % arr.length;

    for(int i = arr.length-time; i< arr.length;i++ ) {
      System.out.print(inputs[i]); 
      if(i!=arr.length-1) {
        System.out.print(",");
      }
    }

    if(time == arr.length) {
      return;
    }

    if(time!=0) {
      System.out.print(",");
    }

    for(int i=0;i<arr.length-time;i++) {
      System.out.print(inputs[i]);
      if(i!=arr.length-time-1) {
        System.out.print(",");
      }
    }


  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    String spinTime = scanner.nextLine();
    SpinEvenly(input, spinTime);
  }
}
