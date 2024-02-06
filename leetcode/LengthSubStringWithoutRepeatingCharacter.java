// problem : https://leetcode.com/problems/longest-substring-without-repeating-characters/ 

import java.util.HashMap;
import java.util.Scanner;

public class LengthSubStringWithoutRepeatingCharacter {
  public int lengthOfLongestSubstring(String s) {
    int longestLen = 0;
    int left = 0;
    HashMap <Character,Integer> map = new HashMap<>();
    for(int i=0;i<s.length();i++) {
      Character c = s.charAt(i);
      if(map.containsKey(c)) {
        longestLen= Math.max(longestLen, i-left);
        left = Math.max(map.get(c) +1,left);
        map.remove(c);
      }

      map.put(c,i);
    }

    longestLen = Math.max(longestLen,s.length()-left);

    return longestLen;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    LengthSubStringWithoutRepeatingCharacter owner = new LengthSubStringWithoutRepeatingCharacter();
    System.out.println(owner.lengthOfLongestSubstring(s));
  }
}
