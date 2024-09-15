package java;
public class UniquePaths {
  // public int uniquePaths(int m, int n) {
  //   int[][] graph = new int[m][n];

  //   for(int i=0;i<m;i++) {
  //     graph[i][0] = 1;
  //   }
    
  //   for(int i=0;i<n;i++) {
  //     graph[0][i] = 1;
  //   }

  //   return findUniquePaths(graph, m-1,n-1);
  // }

  // public int findUniquePaths(int[][] graph, int row, int col) {
  //   if(row == 0 || col == 0) {
  //     return graph[row][col];
  //   }

  //   return findUniquePaths(graph, row-1, col) + findUniquePaths(graph, row, col-1);
  // }

// tabutation
    public int uniquePaths(int m, int n) {
      int[][] graph = new int[m][n];

      for(int i=0;i<m;i++) {
        graph[i][0] = 1;
      }
      
      for(int i=0;i<n;i++) {
        graph[0][i] = 1;
      }

      for(int i=1;i<m;i++) {
        for(int j=1;j<n;j++) {
          graph[i][j] = graph[i-1][j] + graph[i][j-1];
        }
      }

      return graph[m-1][n-1];
    }


  public static void main(String[] args) {
    UniquePaths up = new UniquePaths();
    System.out.println(up.uniquePaths(3, 7));
  }
}
