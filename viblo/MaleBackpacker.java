package viblo;

import java.util.*;

public class MaleBackpacker {
  static int shortestLen = Integer.MAX_VALUE;
  public static void findShortestLen(int[][] arr, int n) {
    boolean[] visited = new boolean[n];
    findMinRoute(arr, n, visited, 0,1,0);
  }

  static void findMinRoute(int[][] arr, int n, boolean[] visited, int currLen, int count, int pos) {
    if(count == n) {
      shortestLen = Math.min(shortestLen, currLen + arr[pos][0]);
    }

    for(int i=0;i<n;i++) {
      if(!visited[i]) {
        visited[i] = true;
        findMinRoute(arr, n, visited, currLen + arr[pos][i], count+1, i);
        visited[i] = false;
      }
    }
  } 

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    int[][] arr = new int[n][n];
     for(int i=0;i<n;i++) {
         String row = scanner.nextLine();
         String[] rows = row.split(",");
         for(int j=0;j<n;j++) {
          arr[i][j] =Integer.parseInt(rows[j]);
         }
        }

    findShortestLen(arr, n);
    System.out.println(shortestLen);
  }
}