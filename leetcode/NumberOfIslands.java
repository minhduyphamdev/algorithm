public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j, n,m);
                    ++count;
                }
        }    
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j, int n, int m) {
        if(i<0||j<0||i==n||j==m|| grid[i][j] == '0') return;
        grid[i][j] = '0';
        DFSMarking(grid, i+1, j, n, m);
        DFSMarking(grid, i-1, j, n, m);
        DFSMarking(grid, i, j+1, n, m);
        DFSMarking(grid, i, j-1, n, m);
    }

    public static void main(String[] args) {
      char[][] grid = new char[][]{
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}

      };
      System.out.println(new NumberOfIslands().numIslands(grid));
    
    }
}
