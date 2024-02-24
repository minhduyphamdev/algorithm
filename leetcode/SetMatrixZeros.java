public class SetMatrixZeros {
  //O(m+n) space and O(n2) complexity 
  // public void setZeroes(int[][] matrix) {
  //   int m = matrix.length;
  //   int n = matrix[0].length;
  //   boolean[] zeroPos = new boolean[m+n];
  //   for(int i=0;i<m;i++) {
  //     for(int j=0;j<n;j++) {
  //       if(matrix[i][j] == 0) {
  //         zeroPos[i] = true;
  //         zeroPos[m+j] = true;
  //       }
  //     }
  //   }

  //   for(int i=0;i<m;i++) {
  //     for(int j=0;j<n;j++)  {
  //       if(zeroPos[i] || zeroPos[m+j]) {
  //         matrix[i][j] = 0;
  //       }
  //     }
  //   }
  // }


  //O(1) space and O(n2) complexity
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRowZero = false;
    boolean firstColZero = false;
    for(int i=0;i<m;i++) {
      for(int j=0;j<n;j++) {
        if(matrix[i][j] == 0) {
          if(i == 0) {
            firstRowZero = true;
          }

          if(j == 0) {
            firstColZero = true;
          }

          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for(int i=1;i<m;i++) {
      for(int j=1;j<n;j++) {
        if(matrix[0][j] == 0 || matrix[i][0] == 0) {
          matrix[i][j] = 0;
        }
    
      }
    }

    if(firstRowZero) {
      for(int i=0;i<n;i++) {
        matrix[0][i] = 0;
      }
    }

    if(firstColZero) {
      for(int i=0;i<m;i++) {
        matrix[i][0] = 0;
      }
    }
  }

  public static void main(String[] args) {
    SetMatrixZeros smz = new SetMatrixZeros();
    // int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
    int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    smz.setZeroes(matrix);
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<matrix[0].length;j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
 