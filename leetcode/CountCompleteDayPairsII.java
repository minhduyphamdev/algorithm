import java.util.*;

public class CountCompleteDayPairsII {
  public long countCompleteDayPairs(int[] hours) {
    HashMap<Integer, Long> map = new HashMap<>();
    long count = 0;
    for(int hour: hours) {
      Integer remaining = (24 - hour % 24) % 24;
      if(map.containsKey(remaining)) {
        count += map.get(remaining);
      }

      map.put(hour % 24, map.getOrDefault(hour % 24,0L) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    CountCompleteDayPairsII countCompleteDayPairsII = new CountCompleteDayPairsII();
    int[] hours = {72,48,24,3};
    System.out.println();
    System.out.println(countCompleteDayPairsII.countCompleteDayPairs(hours));
  }
}