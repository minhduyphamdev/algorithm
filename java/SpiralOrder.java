package java;
import java.util.*;

public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> sol = new ArrayList<>();
    int top = 0;
    int left = 0;
    int right = matrix[0].length-1;
    int bottom = matrix.length-1;
    while(top <= bottom && left <= right) {
      for(int i = left; i <= right; i++) {
        sol.add(matrix[top][i]);
      }
      top++;
      for(int i = top; i <= bottom; i++) {
        sol.add(matrix[i][right]);
      }
      right--;
      if(top > bottom || left > right) {
        break;
      }
      for(int i = right; i >= left; i--) {
        sol.add(matrix[bottom][i]);
      }
      bottom--;
      
      for(int i = bottom; i >= top; i--) {
        sol.add(matrix[i][left]);
      }
      left++;
      
    }

    return sol;
  }

  public static void main(String[] args) {
    SpiralOrder so = new SpiralOrder();
    // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    List<Integer> sol = so.spiralOrder(matrix);
    for(int i : sol) {
      System.out.println(i);
    }
  }
}
