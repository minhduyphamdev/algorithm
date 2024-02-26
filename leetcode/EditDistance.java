import java.util.*;

public class EditDistance {
  public int minDistance(String word1, String word2) {
    Map<Character, Integer> newMap = new HashMap<>();
    int count = 0;
    for(int i = 0 ; i<word2.length();i++) {
      newMap.put(word2.charAt(i),count++);
    }

    
  }
}
