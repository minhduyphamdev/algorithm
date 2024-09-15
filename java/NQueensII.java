package java;
import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    List<List<Boolean>> board = new ArrayList<>();
    int count = 0;
    public int totalNQueens(int n) {
      for(int i=0;i < n;i++) {
        List<Boolean> row = new ArrayList<>();
        for(int j=0;j<n;j++) {
          row.add(false);
        }
        board.add(row);
      }

      solve(board, 0);
      return count;
    }

    public void solve(List<List<Boolean>> board, int row) {
      if(row == board.size()) {
        count++;
        return;
      }

      for(int i=0;i< board.size();i++) {
        if(isValid(board,row,i)) {
          board.get(row).set(i, true);
          solve(board, row+1);
          board.get(row).set(i, false);
        }
      }
    }

    public boolean isValid(List<List<Boolean>> board, int row, int col) {
      for(int i=row; i>=0 ; i--) {
        if(board.get(i).get(col)) {
          return false;
        }
      }

      for(int i=row, j=col; i>=0 && j>=0;i--, j--) {
        if(board.get(i).get(j)) {
          return false;
        }
      }

      for(int i=row, j=col;i>=0 && j < board.size();i--, j++) {
        if(board.get(i).get(j)) {
          return false;
        }
      }

      return true;
    }

    public static void main(String[] args) {
      NQueensII nQueensII = new NQueensII();
      System.out.println(nQueensII.totalNQueens(4));
    }
}