package java;

// có 2 dạng palindrome, dạng đi từ 1 chỉ số (aba), dạng đi từ 2 chỉ số (abba)

import java.util.Scanner;

public class LongestPalindromicString {
  public String longestPalindrome(String s) {
    if(s.length() <=1) {
        return s;
    }

    int maxLen = 1;
    String longestStr = s.charAt(0)+"";
    for(int i=0;i<s.length();i++) {
        for(int j=i+maxLen;j<=s.length();j++) {
         if(j-i > maxLen && isPalindrome(s.substring(i,j))) {
             maxLen = j-i;
             longestStr = s.substring(i,j);
         }
        }
    }

    return longestStr;
}

public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() -1;

    while(left<right) {
        if(s.charAt(left) != s.charAt(right)) {
           return false;
        }
        left ++;
        right --;
    }

 return true;
}

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    LongestPalindromicString myClass = new LongestPalindromicString();
    
    System.out.println(myClass.longestPalindrome(s));
  }
}