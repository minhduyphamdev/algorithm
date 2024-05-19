package viblo;

import java.util.HashSet;

public class SubsetSum {
  public static String findSpecialSubString(String str, int k) {
    String maxSubStr = "";
    int maxLen = 0;

    for(int i=0;i<str.length();i++) {
      for(int j=i+1;j<=str.length();j++) {
        String substr = str.substring(i, j);

        if(substr.length() % 2 == 0 && countDistinctChar(substr) <=k) {
          if(substr.length() > maxLen) {
            maxSubStr = substr;
            maxLen = substr.length();
          }
          
        } else if(countDistinctChar(substr) > k) {
          break;
        }
      }
    }

    return maxSubStr;
  }

  public static int countDistinctChar(String str) {
    HashSet<Character> set = new HashSet<>();
    for(char c: str.toCharArray()) {
      set.add(c);
    }

    return set.size();
  }

  public static void main(String[] args) {
    System.out.println();
    System.out.println(findSpecialSubString("bcab",2));
  }
}
