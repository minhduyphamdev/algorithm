package java;
public class SearchMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
      int top = 0;
      int right = matrix[0].length-1;
      while(top < matrix.length && right > -1) {
        if(matrix[top][right] == target) {
          return true;
        }
        
        if(matrix[top][right] < target) {
          top++;
        }
        else {
          right--;
        }
      }

      return false;
  }

  public static void main(String[] args) {
    SearchMatrix obj = new SearchMatrix();
    // int[][] matrix = {
    //   {1, 4, 7, 11, 15},
    //   {2, 5, 8, 12, 19},
    //   {3, 6, 9, 16, 22},
    //   {10, 13, 14, 17, 24},
    //   {18, 21, 23, 26, 30}
    // };
    int[][] matrix = {{-1,3}};
    int target = 3;
    System.out.println(obj.searchMatrix(matrix, target));
  }
}
