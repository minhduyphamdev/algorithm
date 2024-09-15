package java;
public class UniquePathsII {
  // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
  //   int m = obstacleGrid.length;
  //   int n = obstacleGrid[0].length;
  //   if(m == 1 && n ==1) {
  //     return obstacleGrid[0][0] == 0 ? 1 : 0;
  //   }
  //   if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
  //     return 0;
  //   }
  //   int[][] graph = new int[m][n];
  //   for(int i=1;i<m;i++) {
  //     if(obstacleGrid[i][0] == 0) {
  //       graph[i][0]= 1;
  //     }
  //     else {
  //       for(int j=i;j<m;j++) {
  //         graph[j][0] = 0;
  //       }
  //       break;
  //     }
  //   }

  //   for(int i=1;i<n;i++) {
  //     if(obstacleGrid[0][i] == 0) {
  //       graph[0][i] = 1;
  //     }
  //     else {
  //       for(int j=i;j<n;j++) {
  //         graph[0][j] = 0;
  //       }
  //       break;
  //     }
  //   }

  //   for(int i=1;i<m;i++) {
  //     for(int j=1;j<n;j++) {
  //       if(obstacleGrid[i][j] == 0) {
  //         graph[i][j] = graph[i-1][j] + graph[i][j-1];
  //       }
  //       else {
  //         graph[i][j] = 0;
  //       }
  //     }
  //   }

  //   return graph[m-1][n-1];
  // }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for(int[] row: obstacleGrid) {
      for (int i=0;i<width;i++) {
          if(row[i] == 1) {
            dp[i] = 0;
          }
          else if(i > 0) {
            dp[i] +=dp[i-1];
          }
      }
    }

    return dp[width-1];
  }

  public static void main(String[] args) {
    UniquePathsII uniquePathsII = new UniquePathsII();
    int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
    // int[][] obstacleGrid = new int[][]{{0,1},{0,0}};
    // int[][] obstacleGrid = new int[][]{{0}};
    // int[][] obstacleGrid = new int[][] {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
  }
}
