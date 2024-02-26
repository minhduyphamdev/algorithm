public class RotateImage {

  //c1: tranponse matrix[i][j] -> matrix[j][i] then reverse matrix[j][i] -> matrix[j][n-1-i]
  // public void rotate(int[][] matrix) {
  //   int m = matrix.length;
  //   int n = matrix[0].length;

  //   //matrix[i][j] -> matrix[j][i]
  //   for(int i=0;i <m;i++) {
  //     for(int j=0;j<n;j++) {
  //       if(i!=j && i <j) {
  //         int temp = matrix[i][j];
  //         matrix[i][j] = matrix[j][i];
  //         matrix[j][i] = temp;
  //       }
  //     }
  //   }

  //   //reverse each row
  //   for(int i=0;i<m;i++) {
  //     reverseRow(matrix[i],n);
  //   }
  // }

  // public void reverseRow(int[] row, int n) {
  //   int left = 0;
  //   int right = n-1;

  //   while(left<right) {
  //     int temp = row[left];
  //     row[left] = row[right];
  //     row[right] = temp;
  //     left++;
  //     right--;
  //   }
  // }

  //c2: reverse matrix[i][j] -> matrix[n-1-i][j] then transpose matrix[n-1-i][j] -> matrix[j][n-1-i]
  public void rotate(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    //reverse each col
      reverseRow(matrix, m);

    for(int i=0;i<m;i++) {
      for(int j=0;j<n;j++) {
        if(i!=j && i < j) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }
  }

  public void reverseRow(int[][] matrix, int row) {
    int top = 0;
    int bottom = row-1;

    while(top<bottom) {
      int[] temp = matrix[top];
      matrix[top] = matrix[bottom];
      matrix[bottom] = temp;
      top++;
      bottom--;
    }
  }


  public static void main(String[] args) {
    RotateImage ri = new RotateImage();
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    ri.rotate(matrix);
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<matrix[0].length;j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
