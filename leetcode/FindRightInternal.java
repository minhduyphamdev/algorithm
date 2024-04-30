import java.util.*;

public class FindRightInternal {
  // public int[] findRightInterval(int[][] intervals) {
  //   TreeMap<Integer,Integer> treeMap = new TreeMap<>();
  //   for(int i=0; i < intervals.length;i++) {
  //     treeMap.put(intervals[i][0],i);
  //   }

  //   int[] ans  = new int[intervals.length];
  //   int i =0;
  //   for(int[] interval: intervals) {
  //     Integer pos = treeMap.ceilingKey(interval[1]);
  //     ans[i] = pos == null ? -1 : treeMap.get(pos);
  //     i++;
  //   }

  //   return ans;
  // }

  public int[] findRightInterval(int[][] intervals) {
    PriorityQueue<int[]> minHeapStart = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    PriorityQueue<int[]> minHeapEnd = new PriorityQueue<>((a,b) -> a[0]-b[0]);

    for(int i=0;i<intervals.length;i++) {
      minHeapStart.add(new int[]{intervals[i][0], i});
      minHeapEnd.add(new int[]{intervals[i][1],i});
    }
     
    int[] result = new int[intervals.length];
    Arrays.fill(result, -1);
    while(!minHeapEnd.isEmpty()) {
      int[] currEnd = minHeapEnd.poll();
      int endVal = currEnd[0];
      int endPos = currEnd[1];

      while(!minHeapStart.isEmpty() && endVal > minHeapStart.peek()[0]) {
        minHeapStart.poll();
      }

      if(minHeapStart.isEmpty()) {
        return result;
      }

      result[endPos] = minHeapStart.peek()[1];

    }

    return result;
  }

  public static void main(String[] args) {
    FindRightInternal obj = new FindRightInternal();
    // int[][] intervals = {{1,2}};
    // int[][] intervals = {{3,4},{2,3},{1,2}};
    int[][] intervals = {{1,12},{2,9},{3,10},{13,14},{15,16},{16,17}};
    System.out.println(obj.findRightInterval(intervals)); // [-1]
  }
}
 