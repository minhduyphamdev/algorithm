public class TranposeMatrix {
  public int[][] transpose(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] B = new int[m][n];
    for(int i=0;i<m;i++) {
      for (int j=0;j<n;j++) {
        B[i][j] = matrix[j][i];
      }
    }

    return B;
  }

  public static void main(String[] args) {
    TranposeMatrix obj = new TranposeMatrix();
    // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    int[][] matrix = {{2,4,-1},{-10,5,11},{18,-7,6}};
    int[][] result = obj.transpose(matrix);
    for(int i=0;i<result.length;i++) {
      for(int j=0;j<result[0].length;j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }
}
