package java;
import java.util.*;

public class FindMissingAndRepeatedValues {
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    Set<Integer> set = new HashSet<>();
    int len = grid.length;
    int xor = 0;
    int dup = 0;
    for(int i=0;i<len*len;i++) {
      int num = grid[i/len][i%len];
      xor = xor ^ (i+1) ^ num;
      if(set.contains(num)) {
        dup = num;
      }

      set.add(num);
    }

    xor = xor ^ dup;

    return new int[]{dup,xor};
  }

  public static void main(String[] args) {
    FindMissingAndRepeatedValues fmrv = new FindMissingAndRepeatedValues();
    int[][] grid = {{1,3},{2,2}};
    int[] result = fmrv.findMissingAndRepeatedValues(grid);
    System.out.println(result[0] + " " + result[1]);
  }


}
