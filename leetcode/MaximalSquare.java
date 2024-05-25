public class MaximalSquare {
    // brute force
    // public int maximalSquare(char[][] matrix) {
    //   int m = matrix.length;
    //   int n = matrix[0].length;
    //   int result = 0;

    //   for(int i = 0; i< m;i++) {
    //     for(int j = 0;j <n;j++) {
    //       if(matrix[i][j] != '1') continue;
    //       int squareSize = 1;

    //       boolean flag = true;
    //       while(i+squareSize < m && j + squareSize < n && flag) {
    //         for(int k=i;k<=i+squareSize;k++) {
    //             if(matrix[k][j+squareSize] !='1') {
    //               flag = false;
    //               break;
    //             }
    //         }

    //         if(flag == true) {
    //           for(int k=j;k<j+squareSize;k++) {
    //             if(matrix[i+squareSize][k] !='1') {
    //               flag = false;
    //               break;
    //             }
    //           }
    //         }

    //         if(flag == true) {
    //             squareSize ++;
    //         }
    //       }

    //       result = Math.max(squareSize,result);
    //     }
    //   }

    //   return result*result;
    // }

    public static void main(String[] args) {
      System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }


    // dynamic programming
    public int maximalSquare(char[][] matrix) {
      int[][] op = new int[matrix.length + 1][matrix[0].length + 1];
      int max = 0;
      
      for(int i=1;i<=matrix.length;i++) {
        for(int j=1;j<=matrix[0].length;j++) {
          if(matrix[i-1][j-1] == '1') {
            op[i][j] = Math.min(op[i-1][j-1],Math.min(op[i-1][j], op[i][j-1])) + 1;
            max = Math.max(max, op[i][j]);
          }
        }
      }

      return max*max;
    }
} 