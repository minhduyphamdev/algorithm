package java;
import java.util.*;

public class PascalTriangle {
  // public List<List<Integer>> generate(int numRows) {
  //   int[][] dp = new int[numRows][numRows];
  //   List<List<Integer>> res = new ArrayList<>();

  //   // cols
  //   for(int i=0;i<numRows;i++) {
  //     dp[0][i] = 1;
  //   }

  //   // rows
  //   for(int j=1;j<numRows;j++) {
  //     dp[j][0] = 1;
  //   }

  //   for(int i=1;i<numRows;i++) {
  //     for(int j=1;j<numRows;j++) {
  //       dp[i][j] = dp[i-1][j] + dp[i][j-1];
  //     }
  //   }

  //   for(int i=0;i<numRows;i++) {
  //     List<Integer> temp = new ArrayList<>();
  //     for(int j=0;j<=i;j++) {
  //       temp.add(dp[j][i-j]);
  //     }
      
  //     res.add(new ArrayList<>(temp));
  //   }

  //   return res;
  // }

  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) return new ArrayList<>();
    if(numRows == 1) {
      List<List<Integer>> res = new ArrayList<>();
      res.add(Arrays.asList(1));
      return res;
    }

    List<List<Integer>> prevRows = generate(numRows-1);
    List<Integer> newRow = new ArrayList<>();

    for(int i=0;i<numRows;i++) {
      newRow.add(1);
    }

    for(int i=1;i<numRows-1;i++) {
      newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));

    }

    prevRows.add(newRow);
    return prevRows;
}

  public static void main(String[] args) {
    System.out.println(new PascalTriangle().generate(5));
  }
}
