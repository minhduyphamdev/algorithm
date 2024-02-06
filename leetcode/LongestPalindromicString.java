
// có 2 dạng palindrome, dạng đi từ 1 chỉ số (aba), dạng đi từ 2 chỉ số (abba)

import java.util.Scanner;

public class LongestPalindromicString {
  public int getPalindromeLength(String s, int start, int end, int len) {
    while(start>=0 && end < len && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }

    return end - start -1;
  }
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }

    String longestString = "";
    int len = s.length();

    for(int i=0;i<=len-1;i++) {
      int lenOfPalindromeCase1 = getPalindromeLength(s,i,i,len);
      int lenOfPalindromeCase2 = getPalindromeLength(s,i,i+1,len);
      int maxLen = Math.max(lenOfPalindromeCase1, lenOfPalindromeCase2);

      if(maxLen > longestString.length()) {
        int start = i-(maxLen-1) /2 ;
        int end = i+ maxLen / 2;
        longestString = s.substring(start, end+1);
      }
    }

    return longestString;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    LongestPalindromicString myClass = new LongestPalindromicString();
    
    System.out.println(myClass.longestPalindrome(s));
  }
}