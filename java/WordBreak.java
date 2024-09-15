package java;
import java.util.*;

public class WordBreak {
  // public boolean wordBreak(String s, List<String> wordDict) {
  //   boolean[]dp = new boolean[s.length()+1];
  //   dp[0] = true;
  //   for(int i=1;i<=s.length();i++) {
  //     for(int j=0;j<i;j++) {
  //       if(dp[j] && wordDict.contains(s.substring(j,i))) {
  //         dp[i] = true;
  //         break;
  //       }
  //     }
  //   }

  //   return dp[s.length()];
  // }

  public boolean wordBreak(String s, List<String> wordDict) {
    return helper(s.toCharArray(), 0, wordDict, new HashSet<>());
  } 

  public boolean helper(char)

  public static void main(String[] args) {
    WordBreak wb = new WordBreak();
    List<String> wordDict = new ArrayList<String>();
    wordDict.add("car");
    wordDict.add("ca");
    wordDict.add("rs");
    System.out.println(wb.wordBreak("cars", wordDict));
  }
}
