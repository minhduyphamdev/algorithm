package java;
import java.util.*;

public class PascalTriangleII {
  public List<Integer> getRow(int rowIndex) {
    Integer[] rows = new Integer[rowIndex+1];
    Arrays.fill(rows,0);
    rows[0] = 1;
    
    for(int i=1;i<=rowIndex;i++) {
      for(int j=i;j>0;j--) {
        rows[j] = rows[j] + rows[j-1];
      }
    }

    return Arrays.asList(rows);
  }

  public static void main(String[] args) {
    PascalTriangleII obj = new PascalTriangleII();
    System.out.println(obj.getRow(1));
  }
}
