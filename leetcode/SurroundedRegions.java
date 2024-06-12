import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
  // dfs implementation
  // public void solve(char[][] board) {
  //   if(board == null || board.length == 0) return;

  //   int row = board.length;
  //   int col = board[0].length;

  //   for(int i=0;i<row;i++) {
  //     if(board[i][0] == 'O') {
  //         dfs(board, row, col, i ,0 );
  //     }

  //     if(board[i][col-1] == 'O') {
  //       dfs(board, row, col, i, col-1);
  //     }
  //   }

  //   for(int i=0;i<col;i++) {
  //     if(board[0][i] == 'O') {
  //       dfs(board, row, col, 0, i);
  //     }

  //     if(board[row-1][i] == 'O') {
  //       dfs(board, row, col, row-1, i);
  //     }
  //   }

  //   for(int i=0;i<row;i++) {
  //     for(int j=0; j < col; j++) {
  //       if(board[i][j] == 'O') {
  //         board[i][j] = 'X';
  //       } else if(board[i][j] == 'Y') {
  //         board[i][j] = 'O';
  //       }
  //     }
  //   }
  // }

  // public void dfs(char[][]board, int row, int col, int x, int y) {
  //   if(x < 0 || x == row || y < 0 || y == col || board[x][y] != 'O') return ;

  //   board[x][y] = 'Y';
  //   dfs(board, row, col, x-1, y);
  //   dfs(board, row, col, x, y+1);
  //   dfs(board, row, col, x+1, y);
  //   dfs(board, row, col, x, y-1);
  // }

  // bfs implementation
  public void solve(char[][] board) {
    if(board == null || board.length == 0) return;
    
    int row = board.length;
    int col = board[0].length;

    for(int i=0;i<row;i++) {
      if(board[i][0] == 'O') {
          bfs(board, row,col, i ,0 );
      }

      if(board[i][col-1] == 'O') {
        bfs(board, row, col, i, col-1);
      }
    }

    for(int i=0;i<col;i++) {
      if(board[0][i] == 'O') {
        bfs(board, row, col, 0, i);
      }

      if(board[row-1][i] == 'O') {
        bfs(board, row, col, row-1, i);
      }
    }

    for(int i=0;i<row;i++) {
      for(int j=0; j < col; j++) {
        if(board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if(board[i][j] == 'Y') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public void bfs(char[][] board, int row, int col, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {i,j});
    int[][] directions= {{-1,0}, {1,0}, {0,-1}, {0,1}};

    while(!queue.isEmpty()) {
      int[] pos = queue.poll();
      
      if(board[pos[0]][pos[1]] !='O') {
        continue;
      }
      board[pos[0]][pos[1]] = 'Y';

      for(int[] direction: directions) {
        int i1 = pos[0] + direction[0];
        int j1 = pos[1] + direction[1];

        if(i1 < 0 || i1 == row || j1 < 0 || j1==col || board[i1][j1] != 'O') continue;
        
        queue.add(new int[] {i1,j1});
      }
    }
  }

  public static void main(String[] args) {
    SurroundedRegions sr = new SurroundedRegions();
    // char[][] board = {
    //   {'X', 'X', 'X', 'X'},
    //   {'X', 'O', 'O', 'X'},
    //   {'X', 'X', 'O', 'X'},
    //   {'X', 'O', 'X', 'X'}
    // };

    char[][] board = {
      {'O','O','O'},
      {'O','O','O'},
      {'O','O','O'}
    };
    sr.solve(board);
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[0].length; j++) {
         System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
