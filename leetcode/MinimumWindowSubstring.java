import java.util.*;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if( s== null || t == null || s.length() < t.length()) {
      return "";
    }
    // dictionary of frequency characters in t
    Map<Character, Integer> tFreq = new HashMap<>();
    for(Character c: t.toCharArray()) {
      tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
    }

    int des = tFreq.size(), count = 0;
    int left = 0, right  = 0;
    Map<Character, Integer> sFreq = new HashMap<>();
    int[] pos = new int[2];
    pos[0] = -1;
    int minLen = Integer.MAX_VALUE;
    while(right < s.length()) {
      char sChar = s.charAt(right);

      if(tFreq.containsKey(sChar)) {
        sFreq.put(sChar, sFreq.getOrDefault(sChar, 0) + 1);

        if(Objects.equals(sFreq.get(sChar), tFreq.get(sChar))) {
          count++;
        }
      }

      while(count == des && right - left + 1 >= des) {
         char sLeft = s.charAt(left);
         minLen = Math.min(minLen, right - left + 1);
         if(minLen == right - left + 1) {
           pos[0] = left; 
           pos[1] = right;
         }
         if(tFreq.containsKey(sLeft)) {
            sFreq.put(sLeft, sFreq.get(sLeft) - 1);

            if(sFreq.get(sLeft) < tFreq.get(sLeft)) {
              count -- ;
            }
         }

         left ++;
      }

      right ++;
    }

    return pos[0] == -1 ? "" : s.substring(pos[0], pos[1] + 1);
  }

  public static void main(String[] args) {
    MinimumWindowSubstring mws = new MinimumWindowSubstring();
    // String s = "ab";
    // String t = "a";
    String s = "aa";
    String t = "aa";
    System.out.println(mws.minWindow(s, t));
  }
}