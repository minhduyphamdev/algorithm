package java;
import java.util.*;

public class EditDistance {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m+1][n+1];// dp[m][n] = transform from word[0..m-1] -> word2[0..n-1]

    dp[0][0] = 0;
    //word1
    for(int i=1;i<=m;i++) {
      dp[i][0] = i; // delete character at position i
    }

    for(int j=1;j<=n;j++) {
      dp[0][j] = j;
    }


    // dp[i-1][j-1] -> dp[i][j] if word1[i-1] == word2[j-1]
    // dp[i-1][j-1] + 1 is replace
    // dp[i-1][j] + 1 is delete character i-1
    // dp[i][j-1] + 1 is insert character j-1
    for(int i=1;i<=m;i++) {
      for(int j=1;j<=n;j++) {
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        }
        else {
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(new EditDistance().minDistance("horse", "ros"));
  }
}
