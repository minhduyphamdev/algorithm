package java;
import java.util.*;

public class NonOverlappingIntervals {
  // < 0 is asc, > 0 is desc
  // count the nuber of valid;
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
    int n = intervals.length;
    int prev = 0;
    int count = 1;
    for(int i=1;i<n;i++) {
      if(intervals[i][0] >= intervals[prev][1]) {
        count++;
        prev = i;
      }
    }

    return n - count;
  }

  // count the number of invalid
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> {
      return Integer.compare(a[1],b[1]);
    });

    int prev = 0;
    int count = 0;
    for(int i =1; i<intervals.length;i++) {
      if(intervals[i][0] < intervals[prev][1]) {
        count ++;
      }
      else {
        prev = i;
      }
    }

    return count;
  }
  public static void main(String[] args) {
    NonOverlappingIntervals obj = new NonOverlappingIntervals();
    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
    System.out.println();
    System.out.println(obj.eraseOverlapIntervals(intervals)); // 1
  }
}
