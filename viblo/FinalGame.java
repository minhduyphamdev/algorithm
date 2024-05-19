package viblo;

import java.util.*;

public class FinalGame {

  public static int minSlime(int[][] arr) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[1] - a[1]);

    for(int[] ele: arr){
      queue.add(ele);
    }

    while(true) {
      
    }
  }

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    int[][] arr = new int[n][2];
     for(int i=0;i<n;i++) {
         String row = scanner.nextLine();
         String[] rows = row.split(",");
          arr[i][0] =Integer.parseInt(rows[0]);
          arr[i][1] = Integer.parseInt(rows[1])
        }

    minSlime(arr);
  }
}
