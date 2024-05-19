package viblo;

import java.util.*;

public class MergeRoutes {
  public static void countNumOfVehicles(int[][] arr) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    
    for(int[] ele: arr) {
      queue.add(ele);
    }

    int[] current = queue.poll();
    int[] next = null;
    while(!queue.isEmpty()) {
      next = queue.poll();
      if(current[1] >= next[0]) {
        current[1] = Math.max(current[1], next[1]);
      } else {
        System.out.println(current[0]+ ","+ current[1]);
        current = next;
      }
    }

    System.out.println(current[0]+ ","+ current[1]);
}   

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    int[][] arr = new int[n][2];
     for(int i=0;i<n;i++) {
         String row = scanner.nextLine();
         String[] rows = row.split(",");
         arr[i][0] = Integer.parseInt(rows[0]);
         arr[i][1] = Integer.parseInt(rows[1]);
        }

    countNumOfVehicles(arr);
}
}