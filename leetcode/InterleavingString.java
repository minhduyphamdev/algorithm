import java.util.*;

public class InterleavingString {
  // public boolean isInterleave(String s1, String s2, String s3) {
  //   if(s3.length() == 0) {
  //     return true;
  //   }

  //   int i = 0;
  //   int j = 0;
  //   int k = 0;
  //   int m =0;
  //   int n = 0;
  //   int oldK = 0;
  //   while(i<s1.length() || j<s2.length() && k <s3.length()) {
  //     while(i<s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
  //       i++;
  //       k++;
  //     }
  //     while(j<s2.length() && k <s3.length() && s2.charAt(j) == s3.charAt(k)) {
  //       j++;
  //       k++;
  //     }

  //     if(oldK == k) {
  //       return false;
  //     }

  //     oldK = k;
  //   }

  //   if(i==s1.length() && j == s2.length() && k==s3.length()) {
  //     return true;
  //   }

  //   return false;
  // }

  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    int l = s3.length();

    if (m + n != l) {
        return false;
    }

    boolean[][] dp = new boolean[m+1][n+1];
    dp[0][0] = true;

    for(int i=1;i<=m;i++) {
      dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    }

    for(int j=1;j<=n;j++) {
      dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    }

    for(int i=1;i<=m;i++) {
      for(int j=1;j<=n;j++) {
        dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    InterleavingString interleavingString = new InterleavingString();
    System.out.println(interleavingString.isInterleave("aa", "ab", "aaba"));
  }
}
